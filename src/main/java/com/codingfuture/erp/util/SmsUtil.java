package com.codingfuture.erp.util;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;

public class SmsUtil {

    private static final String ACCESS_KEY_ID = "";
    private static final String ACCESS_KEY_SECRET = "";
    private static final String ENDPOINT = "";
    private static final String SIGN_NAME = "";
    private static final String TEMPLATE_CODE = "";

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
