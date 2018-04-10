package com.qudian.pay.ares.service.impl;

import com.qudian.pay.ares.dao.entity.local.BaseOrderId;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.entity.local.TaskInfo;
import com.qudian.pay.ares.dao.mapper.local.BaseOrderIdMapper;
import com.qudian.pay.ares.dao.mapper.local.TaskInfoMapper;
import com.qudian.pay.ares.service.InitBaseDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangdelong on 17/1/13.
 */
@Service
public class InitBaseDataServiceImpl implements InitBaseDataService {
    @Resource
    BaseOrderIdMapper baseOrderIdMapper;
    @Resource
    TaskInfoMapper taskInfoMapper;
    private static Logger logger = LoggerFactory.getLogger(InitBaseDataServiceImpl.class);

    @Override
    public boolean fileToDb(String path) throws Exception {
        TaskInfo taskInfo = new TaskInfo();

        try {
            FileInputStream in = new FileInputStream(new File(path));
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "GBK"));
            ArrayList<String> dataList = new ArrayList();
            String line;
            while ((line = br.readLine()) != null) {
                BaseOrderId baseOrderId = new BaseOrderId();
                baseOrderId.setOrderId(Integer.valueOf(line.split(",")[0].trim()));
                baseOrderId.setBillId(Integer.valueOf(line.split(",")[1].trim()));
                baseOrderIdMapper.insert(baseOrderId);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public int count(BaseOrderId record) {
        return 0;
    }

    @Override
    public int insert(BaseOrderId record) {
        return baseOrderIdMapper.insert(record);
    }

    @Override
    public int delete(BaseOrderId record) {
        return 0;
    }

    @Override
    public List<BaseOrderId> query(BaseOrderId record) {
        return null;
    }

    @Override
    public int update(BaseOrderId record) {
        return 0;
    }

    @Override
    public PageInfoPO<BaseOrderId> queryByPage(BaseOrderId record, int startLimit, int endLimit) {
        return null;
    }
}
