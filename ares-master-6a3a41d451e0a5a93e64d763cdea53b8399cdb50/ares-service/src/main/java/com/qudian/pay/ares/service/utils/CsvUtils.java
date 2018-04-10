package com.qudian.pay.ares.service.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CsvUtils {
    public  byte[] createCSVFile(List exportData, LinkedHashMap map) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = Calendar.getInstance().getTime();
        String name="exporttemp"+format.format(date);
        File csvFile = File.createTempFile(name, ".csv");
        BufferedWriter csvFileOutputStream =null;
        csvFileOutputStream=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GBK"), 1024);
        // 写入文件头部
        for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
            java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
            csvFileOutputStream.write("\"" + propertyEntry.getValue() != null ? (String) propertyEntry.getValue() : "\"");
            if (propertyIterator.hasNext()){
                csvFileOutputStream.write(",");
            }
        }
        csvFileOutputStream.newLine();
        // 写入文件内容
        for (Iterator iterator= exportData.iterator();iterator.hasNext();){
            Object row = (Object)iterator.next();
            for(Iterator propertyIterator=map.entrySet().iterator();propertyIterator.hasNext();){
                java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
                String value=(String) BeanUtils.getProperty(row,(String) propertyEntry.getKey());
                value=value==null?"":value;
                String value1=value.replaceAll("(\r\n|\n)", "");
                csvFileOutputStream.write(value1);
                if(propertyIterator.hasNext()){
                    csvFileOutputStream.write(",");
                }
            }
            if (iterator.hasNext()) {
                csvFileOutputStream.newLine();
            }
        }
        csvFileOutputStream.flush();
        FileInputStream fis = new FileInputStream(csvFile);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int n;
        while ((n = fis.read(b)) != -1) {
            bos.write(b, 0, n);
        }
        fis.close();
        bos.close();
        byte[] buffer = bos.toByteArray();
        csvFile.delete();
        return buffer;
    }
}
