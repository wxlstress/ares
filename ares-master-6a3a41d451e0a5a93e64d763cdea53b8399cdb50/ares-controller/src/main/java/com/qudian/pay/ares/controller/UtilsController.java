package com.qudian.pay.ares.controller;


import com.qudian.pay.ares.dao.dto.TaskInfoExt;
import com.qudian.pay.ares.dao.entity.local.TaskInfo;
import com.qudian.pay.ares.dao.enumeration.TaskStatusEnum;
import com.qudian.pay.ares.dao.util.DateUtil;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.dao.vo.FileVo;
import com.qudian.pay.ares.service.TaskService;
import com.qudian.pay.ares.service.UtilService;
import com.qudian.pay.ares.service.utils.FileUtils;
import com.qudian.pay.ares.service.utils.ZipUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipOutputStream;

/**
 * Created by zhangdelong on 17/1/17.
 */
@Controller
@RequestMapping("/util")
public class UtilsController {
    private static Logger logger = LoggerFactory.getLogger(UtilsController.class);
    @Resource
    private TaskService taskService;

    @Resource
    private UtilService utilService;

    @RequestMapping(value = "/down")
    @ResponseBody
    public String down(HttpServletRequest request, HttpServletResponse response) {
        // logger.info((Marker) logger, "根据文件路径名称下载:" + request.getParameter("filePath") + request.getParameter("fileName"));
        logger.info("根据文件路径名称下载,路径,{},文件名{},", request.getParameter("filePath"), request.getParameter("fileName"));
        String filePath = request.getParameter("filePath");
        String fileName = request.getParameter("fileName");
        boolean flag = false;
        byte[] datas = null;
        try {
            datas = utilService.downLoad2Ftp(filePath, fileName);
            if (ObjectUtil.isNotNull(datas)) {
                flag = true;
            }
            if (flag) {
                if (ObjectUtil.isEmpty(fileName)) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                    fileName = "exportDetail_" + format.format(Calendar.getInstance().getTime()) + fileName;
                }
                response.reset();
                response.addHeader("Content-Disposition", "attachment;filename="
                        + new String(fileName.getBytes(), "ISO8859-1"));
                response.addHeader("Content-Length", "" + datas.length);
                OutputStream ous = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                ous.write(datas);
                ous.flush();
                ous.close();
            } else {
                logger.error(" 数据不存在{},{}", fileName, filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 打包压缩下载文件
     */
    @RequestMapping(value = "/batchDownLoad")
    public void downLoadZipFile(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String paragms = request.getParameter("paragms");
        List<Integer> idList = new ArrayList<Integer>();
        if (ObjectUtil.isNotEmpty(paragms)) {
            String[] strs = paragms.split(",");
            for (String id : strs) {
                idList.add(Integer.valueOf(id));
            }
        }

        TaskInfoExt record = new TaskInfoExt();

        record.setTaskStatus(Integer.valueOf(TaskStatusEnum.TASK_DONE.getCode()));
        record.setIds(idList);
        List<TaskInfo> taskInfoList = taskService.queryByExt(record);
        List<FileVo> fileList = new ArrayList<FileVo>();

        for (TaskInfo task : taskInfoList) {
            FileVo fileVo = new FileVo();
            if (ObjectUtil.isNotEmpty(task.getFileName()) && ObjectUtil.isNotEmpty(task.getFilePath())) {
                fileVo.setFileName(task.getFileName());
                fileVo.setFilePath(task.getFilePath());
                fileList.add(fileVo);
            }
        }

        if (ObjectUtil.isEmpty(fileList)) {
            return;
        }
        String zipName = "batchDown_" + DateUtil.formatToSecond(new Date()) + ".zip";
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", zipName);
        ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
        try {
            for (FileVo f : fileList) {
                byte[] bytes = utilService.downLoad2Ftp(f.getFilePath(), f.getFileName());
                ZipUtils.doCompress(FileUtils.byte2Input(bytes), f.getFileName(), out);
                response.flushBuffer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    /**
     * 打包压缩下载文件
     */
    @RequestMapping(value = "/summaryDownLoad")
    public void summaryDownLoad(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String paragms = request.getParameter("paragms");
        List<Integer> idList = new ArrayList<Integer>();
        if (ObjectUtil.isNotEmpty(paragms)) {
            String[] strs = paragms.split(",");
            for (String id : strs) {
                idList.add(Integer.valueOf(id));
            }
        }

        TaskInfoExt record = new TaskInfoExt();

        record.setTaskStatus(Integer.valueOf(TaskStatusEnum.TASK_DONE.getCode()));
        record.setIds(idList);
        List<TaskInfo> taskInfoList = taskService.queryByExt(record);
        try {
            // 创建工作薄
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 创建工作表
            HSSFSheet sheet = workbook.createSheet("sheet1");
            HSSFRow row2 = sheet.createRow(0);
            row2.createCell(0).setCellValue("唯一 Key");
            row2.createCell(1).setCellValue("应付贷方本金总和");
            row2.createCell(2).setCellValue("应付贷方收入总和");
            row2.createCell(3).setCellValue("应付借方收入总和");
            row2.createCell(4).setCellValue("账单总数");
            row2.createCell(5).setCellValue("应还日期");
            row2.createCell(6).setCellValue("任务名称");

            for (int i = 0; i < taskInfoList.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(taskInfoList.get(i).getId());
                row.createCell(1).setCellValue(taskInfoList.get(i).getPayLoanCapital().toString());
                row.createCell(2).setCellValue(taskInfoList.get(i).getPayLoanInterst().toString());
                row.createCell(3).setCellValue(taskInfoList.get(i).getPayBorrowInterst().toString());
                row.createCell(4).setCellValue(taskInfoList.get(i).getBillItemsNum().toString());
                row.createCell(5).setCellValue(DateUtil.formatToDay2(taskInfoList.get(i).getRepairDate()));
                row.createCell(6).setCellValue(taskInfoList.get(i).getTaskName());
            }

            Random r = new Random();

            String fileName = DateUtil.formatToSecond(new Date()) + "_" + r.nextInt(100) + ".xls";
            File file = new File(fileName);
            FileOutputStream xlsStream = new FileOutputStream(file);
            workbook.write(xlsStream);
            response.flushBuffer();

            InputStream in = new FileInputStream(file);
            byte[] input2byte = FileUtils.input2byte(in);
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition", fileName);
            OutputStream ous = new BufferedOutputStream(response.getOutputStream());
            ous.write(input2byte);
            ous.flush();
            ous.close();
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}
