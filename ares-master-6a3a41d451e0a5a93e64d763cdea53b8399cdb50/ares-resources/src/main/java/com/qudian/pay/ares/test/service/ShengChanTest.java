package com.qudian.pay.ares.test.service;

import com.qudian.pay.ares.dao.entity.local.BaseOrderId;
import com.qudian.pay.ares.dao.entity.local.TaskInfo;
import com.qudian.pay.ares.service.BaseOrderService;
import com.qudian.pay.ares.service.InitBaseDataService;
import com.qudian.pay.ares.service.TaskService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Random;

public class ShengChanTest {

    public static final String test() {

        String t = "";
        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (NumberFormatException e) {
            t = "catch";

            throw new IllegalArgumentException();
        } finally {
            t = "finally";

            Integer.parseInt(null);
            return t;
        }
    }

    public static final String test1() {
        try {
            return test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
