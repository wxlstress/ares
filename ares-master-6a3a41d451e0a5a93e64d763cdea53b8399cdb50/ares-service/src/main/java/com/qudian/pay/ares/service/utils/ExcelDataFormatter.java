package com.qudian.pay.ares.service.utils;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by lp on 17/12/7.
 */
public class ExcelDataFormatter {



        @SuppressWarnings("unchecked")
        private Map<String, Map<String, String>> formatter = new HashedMap();

        public void set(String key, Map<String, String> map) {
            formatter.put(key, map);
        }

        public Map<String, String> get(String key) {
            return formatter.get(key);
        }



}
