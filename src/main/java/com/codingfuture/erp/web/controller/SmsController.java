package com.codingfuture.erp.web.controller;

import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.codingfuture.erp.entity.Storealert;
import com.codingfuture.erp.service.StoreService;
import com.codingfuture.erp.service.StorealertService;
import com.codingfuture.erp.util.Result;
import com.codingfuture.erp.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class SmsController {

    @Autowired
    private StorealertService storealertService;
    @Autowired
    private StoreService storeService;


/**
 * @description:发送预警短信
 * @author: lxy
 * @date: 2024/9/7 10:24
 * @param: []
 * @return: com.codingfuture.erp.util.Result<?>
 **/
    @GetMapping("/sendMessage")
    public Result<?> sendMessage(){
        List<Storealert> getstorealert = storealertService.getstorealert(null, null);
        StringBuilder stringBuilder = new StringBuilder();

        for (Storealert storealert : getstorealert) {
            if (storealert.getOutnum()>=storealert.getStorenum()){
                String name = storealert.getName();
                stringBuilder.append(name+"/");
            }
        }
        // 去掉最后一个 "/"
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        String goodsName = stringBuilder.toString();
        SendSmsResponse sendSmsResponse = SmsUtil.sendSms( "小梁", "仓库中的", goodsName);
        if ("OK".equals(sendSmsResponse.getBody().code)){
            return Result.ok("短信发送成功");
        }
        return Result.ok("短信发送失败");
    }
}
