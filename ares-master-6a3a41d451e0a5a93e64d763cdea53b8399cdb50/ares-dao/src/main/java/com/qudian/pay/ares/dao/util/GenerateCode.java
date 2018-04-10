package com.qudian.pay.ares.dao.util;

import com.qudian.pay.ares.dao.enumeration.GenerateCodeType;

import java.util.Date;
import java.util.Random;

/**
 * Created by lp on 16/8/15.
 *
 */
public class GenerateCode {


    /**
     * 生产资产包唯一编码
     * @param businessType 业务线
     * @param type GenerateCodeType
     * @return yyyymmddhhMMss+业务线＋GenerateCodeType扩展＋随机数（5）
     */
    public static String GeneratePackageCode(String businessType,GenerateCodeType type){
        return DateUtil.formatToSecond(new Date()) + businessType + type + getRandomCode(5);
    }
    public static String getRandomCode(int length) {
        String str = "0,1,2,3,4,5,6,7,8,9";
        String str2[] = str.split(",");//将字符串以,分割
        Random rand = new Random();//创建Random类的对象rand
        int index = 0;
        String randStr = "";//创建内容为空字符串对象randStr
        randStr = "";//清空字符串对象randStr中的值
        for (int i=0; i<length; ++i)
        {
            index = rand.nextInt(str2.length-1);//在0到str2.length-1生成一个伪随机数赋值给index
            randStr += str2[index];//将对应索引的数组与randStr的变量值相连接
        }
        return  randStr;
    }

    public static void main(String[] args) {
        System.out.println(generateZipCode("jjjjjjj333j3j3j",2));

    }

    public  static String generateZipCode(String rcCode,Integer operType){
       return  DateUtil.formatToSecond(new Date()) + "_" + rcCode.substring(rcCode.length() - 5, rcCode.length())+ "_"+ operType;
    }

}
