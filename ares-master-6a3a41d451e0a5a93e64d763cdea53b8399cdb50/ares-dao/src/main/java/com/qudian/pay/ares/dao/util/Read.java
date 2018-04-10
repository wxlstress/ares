package com.qudian.pay.ares.dao.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhangdelong on 17/1/18.
 */
public class Read  extends Properties {

    private static final long serialVersionUID = 1L;
    private static Read instance;

    private Read()
            throws Exception
    {
        InputStream is = getClass().getResourceAsStream("/app.properties");
        if (is == null) {
            throw new Exception("config.properties Not found");
        }
        try
        {
            load(is);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Read getInstance()
            throws Exception
    {
        if (instance != null) {
            return instance;
        }
        makeInstance();
        return instance;
    }

    private static synchronized void makeInstance()
            throws Exception
    {
        if (instance == null) {
            instance = new Read();
        }
    }
}
