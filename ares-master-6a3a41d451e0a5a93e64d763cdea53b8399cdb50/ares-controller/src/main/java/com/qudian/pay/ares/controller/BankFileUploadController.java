package com.qudian.pay.ares.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qudian.pay.ares.dao.entity.local.BankFileUpload;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.util.DateUtil;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.service.BankFileService;
import com.qudian.pay.ares.service.ICSVSftpService;
import com.qudian.pay.ares.service.cache.StrCache;
import com.qudian.pay.ares.service.enums.EnumReport;
import com.qudian.pay.ares.service.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhangdelong
 * Date: 18/3/20
 * Time: 下午2:29
 * Description:
 */
@Controller
@RequestMapping(value = "bankFile")
public class BankFileUploadController {
    @Resource
    BankFileService bankFileService;


    @RequestMapping(value = "/upload", produces = "application/json;charset=UTF-8")
    @ResponseBody
    Object filesUpload2(String json) {
        return bankFileService.uploadAndSaveFile(json);
    }

    @RequestMapping(value = "/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    Object list(int rows, int page, BankFileUpload bankFileUpload) throws Exception {
        JSONObject jsonObject = new JSONObject();
        PageInfoPO<BankFileUpload> bankFileUploadPageInfoPO = bankFileService.queryByPage(bankFileUpload, page, rows);
        List<BankFileUpload> list = new ArrayList<>();
        for (BankFileUpload bank : bankFileUploadPageInfoPO.getResults()){
            bank.setUploadTimeStr(DateUtil.formatToDay2(bank.getUploadTime()));
            bank.setUpdateTimeStr(DateUtil.formatToDay3(bank.getUpdateTime()));
            bank.setCreateTimeStr(DateUtil.formatToDay3(bank.getCreateTime()));
            list.add(bank);
        }
        int totalPage = (bankFileUploadPageInfoPO.getCount() + Integer.valueOf(rows) - 1) / Integer.valueOf(rows);
        jsonObject.put("rows",list);
        jsonObject.put("page", page);
        jsonObject.put("total", totalPage);
        jsonObject.put("records", bankFileUploadPageInfoPO.getCount());
        return jsonObject;
    }


}
