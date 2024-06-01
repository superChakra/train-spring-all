package com.superchakra.train.helper;

import com.aliyun.tea.TeaException;
import com.superchakra.train.resource.AliyunResource;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SmsHelper {
    @Resource
    private AliyunResource aliyunResource;

    public  String generateVerificationCode() {
        // 定义生成验证码的位数
        int codeLength = 4;

        // 随机数生成器
        Random random = new Random();

        // 用于存储生成的验证码
        StringBuilder codeBuilder = new StringBuilder();

        // 生成指定位数的随机数字
        for (int i = 0; i < codeLength; i++) {
            // 生成随机数字，范围在0~9之间
            int digit = random.nextInt(10); // 生成0到9之间的随机数
            codeBuilder.append(digit); // 将随机数添加到验证码中
        }

        // 返回生成的验证码
        return codeBuilder.toString();
    }

    public  com.aliyun.dysmsapi20170525.Client createClient() throws Exception {

        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_ID。
                .setAccessKeyId(aliyunResource.getAccessKeyId())
                // 必填，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_SECRET。
                .setAccessKeySecret(aliyunResource.getAccessKeySecret());

        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }


    public  void SmsService(String phone, String code) throws Exception {
        com.aliyun.dysmsapi20170525.Client client = createClient();
        com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
                .setPhoneNumbers(phone)
                .setSignName("查克拉")
                .setTemplateCode("SMS_465986333")
                .setTemplateParam("{\"code\":\""+code+"\"}");
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
            client.sendSmsWithOptions(sendSmsRequest, runtime);
        } catch (TeaException error) {
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
    }

    public String sendSms(String phone) throws Exception {
        String code = generateVerificationCode();
        SmsService(phone,code);
        return code;
    }

}
