package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.dto.GoodsSaleDTO;
import com.codingfuture.erp.dto.MarketAddDTO;
import com.codingfuture.erp.util.MarketDetailUtil;
import com.codingfuture.erp.entity.Supplier;
import com.codingfuture.erp.service.GoodsService;
import com.codingfuture.erp.service.StoreService;
import com.codingfuture.erp.service.SupplierService;
import com.codingfuture.erp.service.MarketAddService;
import com.codingfuture.erp.util.DataResult;
import com.codingfuture.erp.util.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static com.codingfuture.erp.constant.MarketConstant.*;

@RestController
@RequestMapping("/v2")
public class MarketAddController {
    @Autowired
    private MarketAddService marketAddService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private StoreService storeService;

    /**
     * @param pageNum
     * @param pageSize
     * @param state
     * @Description: 销售订单全部查询
     * @return: com.company.erp.util.Result<com.company.erp.util.DataResult < java.util.List < com.company.erp.DTO.MarketAddDTO>>>
     * @Author: Heyt
     * @date: 2024/9/4 15:51
     */
    // market/listByPage?state=0
    @GetMapping("/market/listByPage")
    public Result<DataResult<List<MarketAddDTO>>> findListByPage(@RequestParam("page") Integer pageNum,
                                                          @RequestParam("rows") Integer pageSize,
                                                          String state) {
        Page<MarketAddDTO> page = PageHelper.startPage(pageNum, pageSize);
        List<MarketAddDTO> marketAddList = marketAddService.findListByPage(state);

        for (MarketAddDTO marketAddDTO : marketAddList) {
            Long uuid = marketAddDTO.getUuid();
            List<GoodsSaleDTO> goodsSale = marketAddService.findGoodsSale(uuid);
            marketAddDTO.setOrderDetailList(goodsSale);
        }

        DataResult<List<MarketAddDTO>> listDataResult = new DataResult<>(page.getResult(), page.getTotal());
        page.close();
        return Result.ok(listDataResult);
    }

    /**
     * @Description: 查询商品列表
     * @return: com.company.erp.util.Result<com.company.erp.util.DataResult>
     * @Author: Heyt
     * @date: 2024/9/4 15:52
     */
    // orders/listByPage1
    @GetMapping("/orders/listByPage1")
    public Result<DataResult> findAllGoods() {
        List<GoodsSaleDTO> goodsList = goodsService.findAllGoods();
        long size = goodsList.size();
        DataResult<List<GoodsSaleDTO>> listDataResult = new DataResult<>(goodsList, size);
        return Result.ok(listDataResult);
    }

    /**
     * @param type
     * @Description: 查询客户列表
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < java.util.List < com.codingfuture.erp.entity.Supplier>>>
     * @Author: Heyt
     * @date: 2024/9/4 18:42
     */
    // market/showsupplier  ?&type=2
    @GetMapping("market/showsupplier")
    public Result<DataResult<List<Supplier>>> findCustomers(String type) {
        List<Supplier> customers = supplierService.findCustomers(type);
        long size = customers.size();
        DataResult<List<Supplier>> listDataResult = new DataResult<>(customers, size);
        return Result.ok(listDataResult);
    }

    /**
     * @param marketDetailDTO
     * @param session
     * @Description: 新增销售订单
     * @return: void
     * @Author: Heyt
     * @date: 2024/9/4 18:42
     */
    // market/add
    @PostMapping("/market/add")
    public Result<Void> addMarket(@RequestBody MarketDetailUtil marketDetailDTO,
                                  HttpSession session) {
        Object username = session.getAttribute("username");

        // 商品信息
        List<GoodsSaleDTO> marketDetails = marketDetailDTO.getMarketDetails();
        // 仓库信息
//        List<StoreDetail> storeList = storeService.findStoreDetail();
        Double totalMoney = 0.0;

        MarketAddDTO marketAddDTO = new MarketAddDTO();
        marketAddDTO.setCreatetime(new Date());
        marketAddDTO.setCreatername(username.toString());
        marketAddDTO.setSupplieruuid(Long.valueOf(marketDetailDTO.getCustomeruuid()));
        marketAddDTO.setState(UN_OUT_STATE);

        // 给Market添加总金额
        for (GoodsSaleDTO marketDetail : marketDetails) {
            totalMoney += marketDetail.getMoney();
            marketAddService.addMarketDetail(marketDetail);
        }
        marketAddDTO.setTotalmoney(totalMoney);

        // 插入数据，拿到MarketId
        boolean addMarket = marketAddService.addMarket(marketAddDTO);
        Long uuid = marketAddDTO.getUuid();

        for (GoodsSaleDTO marketDetail : marketDetails) {
            marketDetail.setMarketuuid(uuid);
            marketDetail.setState(UN_OUT_STATE);
//            for (StoreDetail storeDetail : storeList) {
//                if (storeDetail.getGoodsUuid().equals(marketDetail.getGoodsuuid())) {
//                    marketDetail.setStoreuuid(storeDetail.getStoreUuid());
//                }
//            }
            marketAddService.addMarketDetail(marketDetail);
        }

        return addMarket ? Result.ok("添加成功") : Result.err("添加失败");

    }


}
