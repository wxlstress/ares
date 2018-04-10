package com.qudian.pay.ares.dao.util;

import java.io.BufferedReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by mac on 16/8/17.
 */
public class CSVParser {

    private static String DEFAULT_CHARSET = "GBK";

    public static <T> List<T> parseFormBufferedReader(BufferedReader br, Class<T> clazz) throws Exception {
            String tmp = null;
            String[] arrTmp = null;
            if((tmp = br.readLine()) == null ) throw new NullPointerException("CSV header is null.");
            TreeMap<String,Integer> index = new TreeMap<String, Integer>();
            arrTmp = tmp.split(",");
            for(int i = 0;i < arrTmp.length ; i++){
                tmp = arrTmp[i];
                //不对金额进行索引 也不填充数据
                if(!tmp.endsWith("期还款") && !tmp.endsWith("期本金") ){
                    index.put(tmp,i);
                }
            }
            List<T> result = new ArrayList<T>();
            CSVName csvName = null;
            Field[] fiellds = clazz.getDeclaredFields();
            T t = null;
            Constructor<T> constructor = clazz.getConstructor();
            while((tmp = br.readLine()) != null){
                t = constructor.newInstance();
                arrTmp = tmp.split(",");
                for(int i = 0 ;i < fiellds.length ; i ++){
                    Field f = fiellds[i];
                    f.setAccessible(true);
                    csvName = f.getAnnotation(CSVName.class);
                    if(csvName != null){
                        Integer arrIndex = index.get(csvName.value());
                        if(arrIndex != null && arrTmp.length - 1 >= arrIndex){
                            f.set(t,arrTmp[arrIndex]);
                        }
                    }
                }
                result.add(t);
            }
            return result;
    }

}
