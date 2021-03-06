package com.bjtc.util;

import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;
import java.util.Random;


public class SendVaildCodeUtil {

    // 短信应用SDK AppID
    private static int appid = 1400193243;

    // 短信应用SDK AppKey
    private static String appkey = "97b2c3d4727e73d0c2a1754e93dcacd3";

    //注册发送验证码
    public static String sendVaildCode(String tel){
        int templateId = 292945;

        Random random = new Random();
        String validCode = "(";
        for(int i=0;i<6;i++){
            validCode += random.nextInt(9);
        }
        validCode+=")";
        String[] telArray = new String[]{tel};
        // 指定模板ID单发短信
        try {
            String[] params = {"","5"};
            params[0] = validCode;
            SmsMultiSender msender = new SmsMultiSender(appid, appkey);
            SmsMultiSenderResult result =  msender.sendWithParam("86", telArray,
                    templateId, params, "", "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            return validCode;
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return validCode;
    }

    //忘记密码是发送验证码
    public static String sendVaildCodeOnForget(String tel){
        int templateId = 323371;

        Random random = new Random();
        String validCode = "(";
        for(int i=0;i<6;i++){
            validCode += random.nextInt(9);
        }
        validCode+=")";
        String[] telArray = new String[]{tel};
        // 指定模板ID单发短信
        try {
            String[] params = {"","5"};
            params[0] = validCode;
            SmsMultiSender msender = new SmsMultiSender(appid, appkey);
            SmsMultiSenderResult result =  msender.sendWithParam("86", telArray,
                    templateId, params, "", "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            return validCode;
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return validCode;
    }

    public static void main(String[] args) {
        String sendVaildCode = sendVaildCode("18829076353");
        System.out.println(sendVaildCode);
    }
}
