package com.codingfuture.erp.util;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;

public class SmsUtil {

    private static final String ACCESS_KEY_ID = "LTAI5t6frzQvZ2jfnWyaWtpP";
    private static final String ACCESS_KEY_SECRET = "AwNOX2m1mSkmuivBk5CHqt0zAuVew1";
    private static final String ENDPOINT = "dysmsapi.aliyuncs.com";
    private static final String SIGN_NAME = "码上未来管理系统";
    private static final String TEMPLATE_CODE = "SMS_472455407";

    /**
     * 创建阿里云 SMS 客户端
     *
     * @return Client
     * @throws Exception
     */
    private static Client createClient() throws Exception {
        Config config = new Config()
                .setAccessKeyId(ACCESS_KEY_ID)
                .setAccessKeySecret(ACCESS_KEY_SECRET);
        config.endpoint = ENDPOINT;
        return new Client(config);
    }

    /**
     * 发送短信
     *
     * @param empName      员工姓名
     * @param storeName    店铺名称
     * @param goodName     商品名称
     * @return SendSmsResponse
     */
    public static SendSmsResponse sendSms( String empName, String storeName, String goodName) {
        try {
            Client client = createClient();
            SendSmsRequest sendSmsRequest = new SendSmsRequest()
                    .setPhoneNumbers("13149760798")
                    .setSignName(SIGN_NAME)
                    .setTemplateCode(TEMPLATE_CODE)
                    .setTemplateParam("{\"name\":\"" + empName + "\",\"store\":\"" + storeName + "\",\"good\":\"" + goodName + "\"}");
            RuntimeOptions runtime = new RuntimeOptions();
            SendSmsResponse sendSmsResponse = client.sendSmsWithOptions(sendSmsRequest, runtime);
            System.out.println(sendSmsResponse.getBody().getMessage());
            System.out.println(sendSmsResponse.getBody().code);
            return sendSmsResponse;
        } catch (TeaException error) {
            System.out.println(error.getMessage());
            if (error.getData() != null) {
                System.out.println(error.getData().get("Recommend"));
            }
            throw error;
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            System.out.println(error.getMessage());
            if (error.getData() != null) {
                System.out.println(error.getData().get("Recommend"));
            }
            throw error;
        }
    }
}