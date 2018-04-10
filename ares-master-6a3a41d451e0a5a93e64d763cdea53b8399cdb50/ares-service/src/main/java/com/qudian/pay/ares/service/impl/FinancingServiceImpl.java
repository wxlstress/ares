package com.qudian.pay.ares.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qudian.pay.ares.dao.dto.FinancingCostVo;
import com.qudian.pay.ares.dao.entity.local.FinancingCost;
import com.qudian.pay.ares.dao.entity.local.FinancingCostExample;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.mapper.local.FinancingCostMapper;
import com.qudian.pay.ares.dao.util.DateUtil;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.service.FinancingService;
import com.qudian.pay.ares.service.utils.ExcelDataFormatter;
import com.qudian.pay.ares.service.utils.ExcelUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FinancingServiceImpl implements FinancingService {
    @Resource
    private FinancingCostMapper financingCostMapper;
    private static Logger logger = LoggerFactory.getLogger(FinancingServiceImpl.class);

    @Override
    public int count(FinancingCost record) {
        return 0;
    }

    @Override
    public int insert(FinancingCost record) {
        return financingCostMapper.insertSelective(record);
    }

    @Override
    public int delete(FinancingCost record) {
        return financingCostMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FinancingCost> query(FinancingCost record) {
        return null;
    }

    @Override
    public int update(FinancingCost record) {
        return financingCostMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public PageInfoPO<FinancingCost> queryByPage(FinancingCost record, int startLimit, int endLimit) throws Exception {
        FinancingCostExample example = new FinancingCostExample();
        FinancingCostExample.Criteria cc = example.createCriteria();
        //拼装页面传参
        if (ObjectUtil.isNotEmpty(record.getChannelType())) {
            if (record.getChannelType() != -1)
                cc.andChannelTypeEqualTo(record.getChannelType());
        }
        if (ObjectUtil.isNotEmpty(record.getChannelClassified())) {
            if (record.getChannelClassified() != -1)
                cc.andChannelClassifiedEqualTo(record.getChannelClassified());
        }
        if (ObjectUtil.isNotEmpty(record.getChannelId())) {
            if (record.getChannelId() != -1)
                cc.andChannelIdEqualTo(record.getChannelId());
        }
        if (ObjectUtil.isNotEmpty(record.getCreateTime())) {
            if (record.getCreateTime() != null)
                cc.andCreateTimeEqualTo(record.getCreateTime());
        }
        if (ObjectUtil.isNotEmpty(record.getRepayMethod())) {
            if (record.getRepayMethod() != -1)
                cc.andRepayMethodEqualTo(record.getRepayMethod());
        }
        if (ObjectUtil.isNotEmpty(record.getChannelName())) {
            if (StringUtils.isNotEmpty(record.getChannelName())&&!"-1".equals(record.getChannelName()))
                cc.andChannelNameEqualTo(record.getChannelName());
        }  if (ObjectUtil.isNotEmpty(record.getExt1())) {
            if (StringUtils.isNotEmpty(record.getExt1())&&!"-1".equals(record.getExt1()))
                cc.andExt1EqualTo(record.getExt1());
        }

        example.setPageNum(startLimit, endLimit);
        example.setOrderByClause("id desc");
        PageInfoPO<FinancingCost> res = new PageInfoPO<FinancingCost>();
        res.setResults(financingCostMapper.selectByExampleByPage(example));
        res.setCount(financingCostMapper.countByExample(example));
        res.setPageNum(startLimit);
        res.setPageSize(endLimit);
        //转换页面展示结果
        for (int i = 0; i < res.getResults().size(); i++) {
//            res.getResults().getL(i).(DateUtil.formatToDay2(res.getResults().get(i).getCreateTime()));
            res.getResults().get(i).setLoanDayStr(DateUtil.formatToDay2(res.getResults().get(i).getLoanDay()));
            res.getResults().get(i).setRepayDayStr(DateUtil.formatToDay2(res.getResults().get(i).getRepayDay()));
        }
        return res;
    }

    @Override
    public FinancingCost selectByPrimaryKey(Integer id) {
        return financingCostMapper.selectByPrimaryKey(id);
    }


    public byte[] downloadFile(FinancingCost record){
        FinancingCostExample example = new FinancingCostExample();
        FinancingCostExample.Criteria cc = example.createCriteria();
        //拼装页面传参
        if (ObjectUtil.isNotEmpty(record.getChannelType())) {
            if (record.getChannelType() != -1)
                cc.andChannelTypeEqualTo(record.getChannelType());
        }
        if (ObjectUtil.isNotEmpty(record.getChannelClassified())) {
            if (record.getChannelClassified() != -1)
                cc.andChannelClassifiedEqualTo(record.getChannelClassified());
        }
        if (ObjectUtil.isNotEmpty(record.getChannelId())) {
            if (record.getChannelId() != -1)
                cc.andChannelIdEqualTo(record.getChannelId());
        }
        if (ObjectUtil.isNotEmpty(record.getCreateTime())) {
            if (record.getCreateTime() != null)
                cc.andCreateTimeEqualTo(record.getCreateTime());
        }
        if (ObjectUtil.isNotEmpty(record.getRepayMethod())) {
            if (record.getRepayMethod() != -1)
                cc.andRepayMethodEqualTo(record.getRepayMethod());
        }
        if (ObjectUtil.isNotEmpty(record.getChannelName())) {
            if (StringUtils.isNotEmpty(record.getChannelName())&&!"-1".equals(record.getChannelName()))
                cc.andChannelNameEqualTo(record.getChannelName());
        }
        if (ObjectUtil.isNotEmpty(record.getExt1())) {
            if (StringUtils.isNotEmpty(record.getExt1())&&!"-1".equals(record.getExt1()))
                cc.andExt1EqualTo(record.getExt1());
        }

        example.setOrderByClause("id desc");
        List<FinancingCost> financingCosts = financingCostMapper.selectByExample(example);

        ArrayList<FinancingCostVo> financingCostsVos = Lists.newArrayList();

        for (int i=0;i<financingCosts.size();i++){
            FinancingCostVo financingCostVo = new FinancingCostVo();
            BeanUtils.copyProperties(financingCosts.get(i),financingCostVo);
            financingCostVo.setLoanDayStr(DateUtil.formatToDay2(financingCosts.get(i).getLoanDay()));
            financingCostVo.setRepayDayStr(DateUtil.formatToDay2(financingCosts.get(i).getRepayDay()));
            financingCostsVos.add(financingCostVo);

        }

        HashMap<String, String> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("0", "外部");
        objectObjectHashMap.put("1", "自有");
        objectObjectHashMap.put("2", "混合");
        //0:信托,1:p2p,2:银行
        HashMap<String, String> channelTypeMap = Maps.newHashMap();
        channelTypeMap.put("0", "信托");
        channelTypeMap.put("1", "P2P");
        channelTypeMap.put("2", "银行");
        channelTypeMap.put("3", "自有资金");
        channelTypeMap.put("4", "股东资金");
        channelTypeMap.put("5", "金交所");
        channelTypeMap.put("6", "单笔项目");
        channelTypeMap.put("7", "其他");
        channelTypeMap.put("8", "信托&其他");
        channelTypeMap.put("9", "ABS");

        //方式  计息类型 0:计头 1:计尾'
        HashMap<String, String> interestTypeMap = Maps.newHashMap();
        interestTypeMap.put("0", "计头");
        interestTypeMap.put("1", "计尾");
        //方式  0:等额本息，1:到期一次还本息，2:每期还息到期还本'
        HashMap<String, String> repayMethodMap = Maps.newHashMap();
        repayMethodMap.put("0", "等额本息");
        repayMethodMap.put("1", "到期一次还本息");
        repayMethodMap.put("2", "每期还息到期还本");
        HashMap<String, String> statusMap = Maps.newHashMap();
        statusMap.put("0", "待审核");
        statusMap.put("1", "已审核");
        ExcelDataFormatter excelDataFormatter = new ExcelDataFormatter();
        excelDataFormatter.set("channelClassified", objectObjectHashMap);
        excelDataFormatter.set("channelType",channelTypeMap);
        excelDataFormatter.set("repayMethod",repayMethodMap);
        excelDataFormatter.set("interestType",interestTypeMap);
        excelDataFormatter.set("ext1",statusMap);
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = Calendar.getInstance().getTime();
            String name="exporttemp"+format.format(date);
            File file = ExcelUtil.writeToFileLocal(financingCostsVos, excelDataFormatter, name);
            byte[] bytes = IOUtils.toByteArray(new FileInputStream(file));
            file.delete();
            return bytes;
        } catch (Exception e) {
            logger.info("下载异常",e);
        }
        return  null;
    }
}
