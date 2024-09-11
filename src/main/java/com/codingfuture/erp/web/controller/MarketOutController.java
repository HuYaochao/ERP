package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.dto.StoreDTO;
import com.codingfuture.erp.service.MarketOutService;
import com.codingfuture.erp.service.StoreService;
import com.codingfuture.erp.util.DataResult;
import com.codingfuture.erp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v2")
public class MarketOutController {
    @Autowired
    private MarketOutService marketOutService;

    @Autowired
    private StoreService storeService;

    /**
     * @param id
     * @Description: 销售订单出库
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult>
     * @Author: Heyt
     * @date: 2024/9/5 9:58
     */
    // returnorders/doStart?id=${obj.data.uuid}
    @PostMapping("/returnorders/doStart")
    public Result<Void> doStart(Long id,
                                HttpSession session) {
        String name = session.getAttribute("username").toString();

        return marketOutService.doStart(id,name,new Date()) ? Result.ok("出库成功") : Result.err("出库失败");
    }

    /**
     * @Description: 选择仓库列表
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < com.codingfuture.erp.dto.GoodsSaleDTO>>
     * @Author: Heyt
     * @date: 2024/9/4 20:48
     */
    //returnorders/selectStore
    @GetMapping("returnorders/selectStore")
    public Result<DataResult<List<StoreDTO>>> selectStore() {
        List<StoreDTO> store = storeService.findStore();
        long size = store.size();
        DataResult<List<StoreDTO>> storeListDataResult = new DataResult<>(store, size);

        return Result.ok(storeListDataResult);
    }

    /**
     * @Description: 商品出库
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DoOutStoreResult>
     * @Author: Heyt
     * @date: 2024/9/4 20:48
     */
    // marketdetail/doOutStore
    @PostMapping("marketdetail/doOutStore")
    public Result<Void> doOutStore(@RequestParam("id") Long uuid,
                                   Long goodsuuid,
                                   Long storeuuid,
                                   Long num) {
        storeService.minusNum(storeuuid, num, goodsuuid);

        return marketOutService.doOutStore(uuid, storeuuid) ? Result.ok("出库成功") : Result.err("出库失败");
    }


}
