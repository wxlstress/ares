package com.qudian.pay.ares.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qudian.pay.ares.dao.entity.local.*;
import com.qudian.pay.ares.dao.mapper.local.BankFileUploadMapper;
import com.qudian.pay.ares.dao.util.DateUtil;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.service.BankFileService;
import com.qudian.pay.ares.service.ICSVSftpService;
import com.qudian.pay.ares.service.enums.EnumInstitution;
import com.qudian.pay.ares.service.enums.EnumReport;
import com.qudian.pay.ares.service.utils.StreamUtlis;
import com.qudian.pay.ares.service.utils.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangdelong
 * Date: 18/3/26
 * Time: 下午2:20
 * Description:
 */
@Service
public class BankFileServiceImpl implements BankFileService {

    private static Logger logger = LoggerFactory.getLogger(BankFileServiceImpl.class);


    @Resource
    ICSVSftpService icsvSftpService;

    @Resource
    BankFileUploadMapper bankFileUploadMapper;

    @Override
    public int count(BankFileUpload record) throws Exception {
        return 0;
    }

    @Override
    public int insert(BankFileUpload record) throws Exception {
        return bankFileUploadMapper.insert(record);
    }

    @Override
    public int delete(BankFileUpload record) throws Exception {
        return 0;
    }

    @Override
    public List<BankFileUpload> query(BankFileUpload record) throws Exception {
        return null;
    }

    @Override
    public int update(BankFileUpload record) throws Exception {
        return bankFileUploadMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 分页查询
     *
     * @param record     条件
     * @param startLimit 页码
     * @param endLimit   每页记录数 默认30
     * @return
     */
    @Override
    public PageInfoPO<BankFileUpload> queryByPage(BankFileUpload record, int startLimit, int endLimit) throws Exception {
        BankFileUploadExample bankFileUploadExample = new BankFileUploadExample();
        bankFileUploadExample.setPageNum(startLimit, endLimit);
        bankFileUploadExample.setOrderByClause("id desc");
        PageInfoPO<BankFileUpload> res = new PageInfoPO<BankFileUpload>();
        res.setResults(bankFileUploadMapper.selectByExampleByPage(bankFileUploadExample));
        res.setCount(bankFileUploadMapper.countByExample(bankFileUploadExample));
        res.setPageNum(startLimit);
        res.setPageSize(endLimit);
        return res;
    }

    @Override
    public Object uploadAndSaveFile(String json) {
        JSONObject resJson =new JSONObject();
        JSONObject jsonObject = JSONObject.parseObject(json);
        String insName = jsonObject.getString("institution");
        String optName = jsonObject.getString("optName");
        String realDate = jsonObject.getString("realDate");
        String type = jsonObject.getString("type");
        JSONArray jsonArray = jsonObject.getJSONArray("fileArray");
        EnumInstitution enumInstitution = EnumInstitution.getEnumByCode(insName);
        if (ObjectUtil.isEmpty(enumInstitution)) {
            resJson.put("code","-1");
            resJson.put("msg","金融机构有误");
            return resJson;
        }

        JSONObject dataJson = new JSONObject();
        for (Object o : jsonArray) {
            JSONObject j = (JSONObject) o;
            String fileName = j.getString("fileName");
            EnumReport enumReport = EnumReport.existEnum(fileName);
            if (ObjectUtil.isEmpty(enumReport)) {
                resJson.put("code","-1");
                resJson.put("msg", "文件 " + fileName + " 名称有误");
                return resJson;
            }
            if (!fileName.equals(EnumReport.getFileName(fileName, realDate))) {
                resJson.put("code","-1");
                resJson.put("msg", "文件" + fileName + "名称时间有误");
                return resJson;
            }
            InputStream inputStream = StreamUtlis.byte2Input(j.getBytes("file"));
            try {
                dataJson.put(enumReport.getCode(), icsvSftpService.uploadFile(EnumInstitution.getFilePath(enumInstitution, realDate, enumReport), fileName, inputStream,enumInstitution));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        int count = 0;

        if ("add".equals(type)) {
            try {
                count = this.insert(bulid(dataJson, insName, optName, realDate));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("update".equals(type)) {
            try {
                count = this.update(bulid(dataJson, insName, optName, realDate));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        resJson.put("code","200");
        resJson.put("msg", "操作成功");
        return resJson;
    }

    private BankFileUpload bulid(JSONObject dataJson, String insName, String optName, String realDate) {
        BankFileUpload bankFileUpload = JSON.parseObject(dataJson.toString(), BankFileUpload.class);
        bankFileUpload.setInsName(insName);
        bankFileUpload.setOptName(optName);
        try {
            bankFileUpload.setUploadTime(DateUtil.stringDateToDate(realDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bankFileUpload.setCreateTime(new Date());
        bankFileUpload.setUpdateTime(new Date());
        return bankFileUpload;
    }
}
