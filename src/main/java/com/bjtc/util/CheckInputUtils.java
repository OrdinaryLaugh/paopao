package com.bjtc.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 检查输入数据的工具
 */
public class CheckInputUtils {
    private static Pattern pattern=Pattern.compile("[0-9]*");

    public static boolean checkPhone(String phone){
        boolean result=true;
        result=checkNumber(phone);
        //手机号长度是11位
        if(result&&phone.length()!=11){
           return false;
        }
        return result;
    }
    public static boolean checkOrder(String orderId){
        boolean result=true;
        result=checkNumber(orderId);
        //订单号长度大于11位
        if(result&&orderId.length()<=11){
            return false;
        }
        return result;
    }
    //检查数字格式
    public static boolean checkNumber(String input){
        boolean result=true;
        //输入的数据为空
        if(StringUtils.isEmpty(input)){
            result=false;
            return result;
        }
        boolean hasSpace = StringUtils.containsWhitespace(input);
        //输入的手机号或订单号中有空格
        if(hasSpace){
            result=false;
            return result;
        }
        //输入的数据是否是纯数字
        boolean isNumber = isNumber(input);
        if(!isNumber){
            return false;
        }
        return result;
    }

    /**
     * 判断输入的数据是否是纯数字
     * @param number
     * @return
     */
    public static boolean isNumber(String number){
        Matcher matcher=pattern.matcher(number);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
}
