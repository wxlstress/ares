package com.qudian.pay.ares.service.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qudian.pay.ares.dao.annotation.ReportAnnotation;
import com.qudian.pay.ares.dao.dto.FinancingCostVo;
import com.qudian.pay.ares.dao.util.SftpUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Excel导出
 *
 * @author liupo
 */
@SuppressWarnings("unused")
public class ExcelUtil implements Closeable {

    private SftpUtils qudianSftp;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static int etimes = 0;

    public ExcelUtil() {
    }

    /**
     * 将数据写入到Excel文件
     *
     * @param filePath  文件路径
     * @param sheetName 工作表名称
     * @param title     工作表标题栏
     * @param data      工作表数据
     * @throws FileNotFoundException 文件不存在异常
     * @throws IOException           IO异常
     */
    public void writeToFile(String filePath, String fileName, String[] sheetName, List<? extends Object[]> title, List<? extends List<? extends Object[]>> data)
            throws Exception {
        // 创建并获取工作簿对象
        Workbook wb = getWorkBook(sheetName, title, data);
        // 写入到文件
        OutputStream out = qudianSftp.getUpLoadStream(filePath, fileName);
        wb.write(out);
        out.close();
    }

    /**
     * 创建工作簿对象<br>
     * <font color="red">工作表名称，工作表标题，工作表数据最好能够对应起来</font><br>
     * 比如三个不同或相同的工作表名称，三组不同或相同的工作表标题，三组不同或相同的工作表数据<br>
     * <b> 注意：<br>
     * 需要为每个工作表指定<font color="red">工作表名称，工作表标题，工作表数据</font><br>
     * 如果工作表的数目大于工作表数据的集合，那么首先会根据顺序一一创建对应的工作表名称和数据集合，然后创建的工作表里面是没有数据的<br>
     * 如果工作表的数目小于工作表数据的集合，那么多余的数据将不会写入工作表中 </b>
     *
     * @param sheetName 工作表名称的数组
     * @param title     每个工作表名称的数组集合
     * @param data      每个工作表数据的集合的集合
     * @return Workbook工作簿
     * @throws FileNotFoundException 文件不存在异常
     * @throws IOException           IO异常
     */
    public static Workbook getWorkBook(String[] sheetName, List<? extends Object[]> title, List<? extends List<? extends Object[]>> data)
            throws FileNotFoundException, IOException {
        // 创建工作簿
        Workbook wb = new SXSSFWorkbook();
        // 创建一个工作表sheet
        Sheet sheet = null;
        // 申明行
        Row row = null;
        // 申明单元格
        Cell cell = null;
        // 单元格样式
        CellStyle titleStyle = wb.createCellStyle();
        CellStyle cellStyle = wb.createCellStyle();
        // 字体样式
        Font font = wb.createFont();
        // 粗体
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        titleStyle.setFont(font);
        // 水平居中
        titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
        // 垂直居中
        titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 水平居中
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        // 垂直居中
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        cellStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
        // 标题数据
        Object[] title_temp = null;
        // 行数据
        Object[] rowData = null;
        // 工作表数据
        List<? extends Object[]> sheetData = null;
        // 遍历sheet
        for (int sheetNumber = 0; sheetNumber < sheetName.length; sheetNumber++) {
            // 创建工作表
            sheet = wb.createSheet();
            // 设置默认列宽
            sheet.setDefaultColumnWidth(18);
            // 设置工作表名称
            wb.setSheetName(sheetNumber, sheetName[sheetNumber]);
            // 设置标题
            title_temp = title.get(sheetNumber);
            row = sheet.createRow(0);
            // 写入标题
            for (int i = 0; i < title_temp.length; i++) {
                cell = row.createCell(i);
                cell.setCellStyle(titleStyle);
                cell.setCellValue(title_temp[i].toString());
            }
            try {
                sheetData = data.get(sheetNumber);
            } catch (Exception e) {
                continue;
            }
            // 写入行数据
            for (int rowNumber = 0; rowNumber < sheetData.size(); rowNumber++) {
                // 如果没有标题栏，起始行就是0，如果有标题栏，行号就应该为1
                row = sheet.createRow(title_temp == null ? rowNumber : (rowNumber + 1));
                rowData = sheetData.get(rowNumber);
                for (int columnNumber = 0; columnNumber < rowData.length; columnNumber++) {
                    cell = row.createCell(columnNumber);
                    cell.setCellStyle(cellStyle);
                    if (rowData[columnNumber] != null) {
                        cell.setCellValue(rowData[columnNumber] + "");
                    } else {
                        cell.setCellValue("");
                    }

                }
            }
        }
        return wb;
    }

    /**
     * 将数据写入到EXCEL文档
     *
     * @param list     数据集合
     * @param edf      数据格式化，比如有些数字代表的状态，像是0:女，1：男，或者0：正常，1：锁定，变成可读的文字
     *                 该字段仅仅针对Boolean,Integer两种类型作处理
     * @param filePath 文件路径
     * @throws Exception
     */
    public <T> void writeToFile(List<T> list, ExcelDataFormatter edf, String filePath, String fileName) throws Exception {
        // 创建并获取工作簿对象
        Workbook wb = getWorkBook(list, edf);
        // String fileName=geFileName().
        // 写入到文件
        OutputStream qudianOut = qudianSftp.getUpLoadStream(filePath, fileName);
        wb.write(qudianOut);
        qudianOut.close();
    }

    public static String getFileName(Date fileDate, Integer conter, String name) {
        String si = conter.toString();
        StringBuilder sb = new StringBuilder(name);
        sb.append("_").append(DateFormatUtils.format(fileDate, "yyyyMMdd")).append("_");
        for (int i = 0; i < 3 - si.length(); i++) {
            sb.append("0");
        }
        sb.append(si);
        sb.append(".xlsx");
        return sb.toString();
    }

    public static String getFileZipName(Date fileDate, String name) {
        StringBuilder sb = new StringBuilder(name);
        sb.append("_").append(DateFormatUtils.format(fileDate, "yyyyMMdd"));
        sb.append(".zip");
        return sb.toString();
    }

    /**
     * 获得Workbook对象
     *
     * @param list 数据集合
     * @return Workbook
     * @throws Exception
     */
    public static <T> Workbook getWorkBook(List<T> list, ExcelDataFormatter edf) throws Exception {
        // 创建工作簿
        Workbook wb = new SXSSFWorkbook();
        if (list == null || list.size() == 0)
            return wb;
        // 创建一个工作表sheet
        Sheet sheet = wb.createSheet();
        // 申明行
        Row row = sheet.createRow(0);
        // 申明单元格
        Cell cell = null;
        CreationHelper createHelper = wb.getCreationHelper();
        Field[] fields = ReflectUtils.getClassFieldsAndSuperClassFields(list.get(0).getClass());
        // XSSFCellStyle titleStyle = (XSSFCellStyle) wb.createCellStyle();
        // titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        // // 设置前景色
        // titleStyle.setFillForegroundColor(new XSSFColor(new
        // java.awt.Color(159, 213, 183)));
        // titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
        //
        // Font font = wb.createFont();
        // font.setColor(HSSFColor.BROWN.index);
        // font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        // // 设置字体
        // titleStyle.setFont(font);
        int columnIndex = 0;
        ReportAnnotation excel = null;
        for (Field field : fields) {
            field.setAccessible(true);
            excel = field.getAnnotation(ReportAnnotation.class);
            if (excel == null || excel.skip() == true) {
                continue;
            }
            // 列宽注意乘256
            sheet.setColumnWidth(columnIndex, excel.width() * 256);
            // 写入标题
            cell = row.createCell(columnIndex);
            // cell.setCellStyle(titleStyle);
            cell.setCellValue(excel.name());
            columnIndex++;
        }
        int rowIndex = 1;
        CellStyle cs = wb.createCellStyle();
        for (T t : list) {
            row = sheet.createRow(rowIndex);
            columnIndex = 0;
            Object o = null;
            for (Field field : fields) {
                field.setAccessible(true);
                // 忽略标记skip的字段
                excel = field.getAnnotation(ReportAnnotation.class);
                if (excel == null || excel.skip() == true) {
                    continue;
                }
                // 数据
                cell = row.createCell(columnIndex);
                o = field.get(t);
                // 如果数据为空，跳过
                if (o == null)
                    continue;
                // 处理日期类型
                if (o instanceof Date) {
                    cs.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
                    cell.setCellStyle(cs);
                    cell.setCellValue((Date) field.get(t));
                } else if (o instanceof Double || o instanceof Float) {
                    cell.setCellValue((Double) field.get(t));
                } else if (o instanceof Boolean) {
                    Boolean bool = (Boolean) field.get(t);
                    if (edf == null) {
                        cell.setCellValue(bool);
                    } else {
                        Map<String, String> map = edf.get(field.getName());
                        if (map == null) {
                            cell.setCellValue(bool);
                        } else {
                            cell.setCellValue(map.get(bool.toString().toLowerCase()));
                        }
                    }
                } else if (o instanceof Integer) {
                    Integer intValue = (Integer) field.get(t);
                    if (edf == null) {
                        cell.setCellValue(intValue);
                    } else {
                        Map<String, String> map = edf.get(field.getName());
                        if (map == null) {
                            cell.setCellValue(intValue);
                        } else {
                            cell.setCellValue(map.get(intValue.toString()));
                        }
                    }
                } else if (o instanceof Byte) {
                    Byte aByte = Byte.valueOf(field.get(t).toString());
                    if (edf == null) {
                        cell.setCellValue(aByte);
                    } else {
                        Map<String, String> map = edf.get(field.getName());
                        if (map == null) {
                            cell.setCellValue(aByte);
                        } else {
                            cell.setCellValue(map.get(aByte.toString()));
                        }
                    }
                }else if (o instanceof String) {
                  String value  =field.get(t).toString();
                    if (edf == null) {
                        cell.setCellValue(value);
                    } else {
                        Map<String, String> map = edf.get(field.getName());
                        if (map == null) {
                            cell.setCellValue(value);
                        } else {
                            cell.setCellValue(map.get(value.toString()));
                        }
                    }
                }
                else {
                    cell.setCellValue(field.get(t).toString());
                }
                columnIndex++;
            }
            rowIndex++;
        }
        return wb;
    }


    public static <T> File writeToFileLocal(List<T> list, ExcelDataFormatter edf, String fileName) throws Exception {
        // 创建并获取工作簿对象
        Workbook wb = getWorkBook(list, edf);
        // String fileName=geFileName().
        File file = File.createTempFile(fileName, ".xlsx");

//        File file = new File("/Users/laifenqi/Downloads/批量录入模版222.xlsx");
        // 写入到文件
        OutputStream qudianOut = new FileOutputStream(file);
        wb.write(qudianOut);
        qudianOut.close();
        return file;
    }


    public InputStream downFile(String remotePath, String remoteFile) throws Exception {
        return qudianSftp.downFile(remotePath, remoteFile);
    }


    @Override
    public void close() throws IOException {
        IOUtils.closeQuietly(qudianSftp);
    }

    /**
     * 从文件读取数据，最好是所有的单元格都是文本格式，日期格式要求yyyy-MM-dd HH:mm:ss,布尔类型0：真，1：假
     *
     * @param edf 数据格式化
     * @param is  Excel文件，支持xlsx后缀，xls的没写，基本一样
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <E> Map<String,Object> readFromFile(ExcelDataFormatter edf, InputStream is, Class<?> clazz) throws Exception {
        HashMap<String, Object> resultMap = Maps.newHashMap();
        Field[] fields = ReflectUtils.getClassFieldsAndSuperClassFields(clazz);
        Map<String, String> textToKey = new HashMap<String, String>();
        ReportAnnotation _excel = null;
        for (Field field : fields) {
            _excel = field.getAnnotation(ReportAnnotation.class);
            if (_excel == null || _excel.skip() == true) {
                continue;
            }
            textToKey.put(_excel.name(), field.getName());
        }
        //  InputStream is = new FileInputStream(file);
//        Workbook wb = new XSSFWorkbook(is);
        Workbook wb = WorkbookFactory.create(is);
        Sheet sheet = wb.getSheetAt(0);
        Row title = sheet.getRow(0);
        // 标题数组，后面用到，根据索引去标题名称，通过标题名称去字段名称用到 textToKey
        String[] titles = new String[title.getPhysicalNumberOfCells()];
        for (int i = 0; i < title.getPhysicalNumberOfCells(); i++) {
            titles[i] = title.getCell(i).getStringCellValue();
        }
        List<E> list = new ArrayList<E>();
        E e = null;
        int rowIndex = 0;
        int columnCount = titles.length;
        Cell cell = null;
        Row row = null;
        for (Iterator<Row> it = sheet.rowIterator(); it.hasNext(); ) {
            row = it.next();
            if (rowIndex++ == 0) {
                continue;
            }

            if (row == null) {
                break;
            }
            e = (E) clazz.newInstance();
            for (int i = 0; i < columnCount; i++) {
                cell = row.getCell(i);

                String result = CheckRowError(cell, rowIndex-1, i);
                if(!result.equals("success")){
                    resultMap.put("status",result);
                    return resultMap;
                }
                etimes = 0;
                readCellContent(textToKey.get(titles[i]), fields, cell, e, edf);
            }
            //这里主要防止有空行,避免返回list空对象
            list.add(e);
        }
        resultMap.put("list",list);
        resultMap.put("status","success");
        return resultMap;
    }

    //判断某行某列有问题
    private static String CheckRowError(Cell cell, int rowNum, int cell_num) {
        ArrayList<String> error = Lists.newArrayList();
        //判断各个单元格是否为空
        if (null == cell || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK || "".equals(cell.toString().trim())) {
            return "出错啦！请检查第" + (rowNum + 1) + "行第" + (cell_num + 1) + "列。" + "如果您在该行或该列存在错误，建议您'右键-->删除'或更正数值后,检查后重试！";
        }
        return "success";
    }


    public static void main(String[] args) throws Exception {

//        `channel_classified` tinyint(4) NOT NULL DEFAULT '0' COMMENT '渠道分类 0:外部，1:自有，2，混合',
//
        HashMap<String, String> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("外部", "0");
        objectObjectHashMap.put("自有", "1");
        objectObjectHashMap.put("混合", "2");

        //0:信托,1:p2p,2:银行
        HashMap<String, String> channelTypeMap = Maps.newHashMap();
        channelTypeMap.put("信托", "0");
        channelTypeMap.put("P2P", "1");
        channelTypeMap.put("银行", "2");

        //方式  0:等额本息，1:到期一次还本息，2:每期还息到期还本'
        HashMap<String, String> repayMethodMap = Maps.newHashMap();
        repayMethodMap.put("等额本息", "0");
        repayMethodMap.put("到期一次还本息", "1");
        repayMethodMap.put("每期还息到期还本", "2");

        //方式  计息类型 0:计头 1:计尾'
        HashMap<String, String> interestTypeMap = Maps.newHashMap();
        interestTypeMap.put("计头", "0");
        interestTypeMap.put("计尾", "1");


        ExcelDataFormatter excelDataFormatter = new ExcelDataFormatter();
        excelDataFormatter.set("channelClassified", objectObjectHashMap);
        excelDataFormatter.set("channelType",channelTypeMap);
        excelDataFormatter.set("repayMethod",repayMethodMap);
        excelDataFormatter.set("interestType",interestTypeMap);


//
//
//        HashMap<String, String> objectObjectHashMap = Maps.newHashMap();
//        objectObjectHashMap.put("0", "外部");
//        objectObjectHashMap.put("1", "自有");
//        objectObjectHashMap.put("2", "混合");
//        //0:信托,1:p2p,2:银行
//        HashMap<String, String> channelTypeMap = Maps.newHashMap();
//        channelTypeMap.put("0", "信托");
//        channelTypeMap.put("1", "P2P");
//        channelTypeMap.put("2", "银行");
//
//
//        //方式  计息类型 0:计头 1:计尾'
//        HashMap<String, String> interestTypeMap = Maps.newHashMap();
//        interestTypeMap.put("0", "计头");
//        interestTypeMap.put("1", "计尾");
//        //方式  0:等额本息，1:到期一次还本息，2:每期还息到期还本'
//        HashMap<String, String> repayMethodMap = Maps.newHashMap();
//        repayMethodMap.put("0", "等额本息");
//        repayMethodMap.put("1", "到期一次还本息");
//        repayMethodMap.put("2", "每期还息到期还本");
//        ExcelDataFormatter excelDataFormatter = new ExcelDataFormatter();
//        excelDataFormatter.set("channelClassified", objectObjectHashMap);
//        excelDataFormatter.set("channelType",channelTypeMap);
//        excelDataFormatter.set("repayMethod",repayMethodMap);
//        excelDataFormatter.set("interestType",interestTypeMap);
        Map<String, Object> stringObjectMap = readFromFile(excelDataFormatter, new FileInputStream(new File("/Users/laifenqi/Downloads/批量录入模版(1).xlsx")), FinancingCostVo.class);

        System.out.println(stringObjectMap.get("status"));

//
//        ArrayList<FinancingCostVo> objects = Lists.newArrayList();
//
//        FinancingCostVo financingCost = new FinancingCostVo();
//        financingCost.setChannelClassified(1);
//        financingCost.setChannelName("test");
//        financingCost.setChannelType(new Byte("1"));
//        financingCost.setRepayMethod(new Byte("1"));
//
//        FinancingCostVo financingCost2 = new FinancingCostVo();
//        financingCost2.setChannelClassified(1);
//        financingCost2.setChannelName("test");
//        financingCost2.setChannelType(new Byte("1"));
//        financingCost2.setRepayMethod(new Byte("1"));
//
//        FinancingCostVo financingCost1 = new FinancingCostVo();
//        financingCost1.setChannelClassified(1);
//        financingCost1.setChannelName("test");
//        financingCost1.setChannelType(new Byte("1"));
//        financingCost1.setRepayMethod(new Byte("1"));
//        objects.add(financingCost);
//        objects.add(financingCost1);
//        objects.add(financingCost2);
//        File eeeee = writeToFileLocal(objects, excelDataFormatter, "eeeee");
//
//
//        byte[] bytes = IOUtils.toByteArray(new FileInputStream(eeeee));
//
//        IOUtils.write(bytes,new FileOutputStream(new File("/Users/laifenqi/Downloads/批量录入模版2223.xlsx")));
    }

    /**
     * 从单元格读取数据，根据不同的数据类型，使用不同的方式读取<br>
     * 有时候经常和我们期待的数据格式不一样，会报异常，<br>
     * 我们这里采取强硬的方式<br>
     * 使用各种方法，知道尝试到读到数据为止，然后根据Bean的数据类型，进行相应的转换<br>
     * 如果尝试完了（总共7次），还是不能得到数据，那么抛个异常出来，没办法了
     *
     * @param key    当前单元格对应的Bean字段
     * @param fields Bean所有的字段数组
     * @param cell   单元格对象
     * @param obj
     * @throws Exception
     */
    public static void readCellContent(String key, Field[] fields, Cell cell, Object obj, ExcelDataFormatter edf) throws Exception {
        Object o = null;
        try {
            switch (cell.getCellType()) {
                case XSSFCell.CELL_TYPE_BOOLEAN:
                    o = cell.getBooleanCellValue();
                    break;
                case XSSFCell.CELL_TYPE_NUMERIC:
                    o = cell.getNumericCellValue();
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
//                        o = DateUtil.getJavaDate(cell.getNumericCellValue());
                       Date javaDate = DateUtil.getJavaDate(cell.getNumericCellValue());
                       o= com.qudian.pay.ares.dao.util.DateUtil.formatToDay3(javaDate);

                    }
                    break;
                case XSSFCell.CELL_TYPE_STRING:
                    o = cell.getStringCellValue();
                    break;
                case XSSFCell.CELL_TYPE_ERROR:
                    o = cell.getErrorCellValue();
                    break;
                case XSSFCell.CELL_TYPE_BLANK:
                    o = null;
                    break;
                case XSSFCell.CELL_TYPE_FORMULA:
                    o = cell.getCellFormula();
                    break;
                default:
                    o = null;
                    break;
            }

            if (o == null)
                return;

            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getName().equals(key)) {
                    Boolean bool = true;
                    Map<String, String> map = null;
                    if (edf == null) {
                        bool = false;
                    } else {
                        map = edf.get(field.getName());
                        if (map == null) {
                            bool = false;
                        }
                    }

                    if (field.getType().equals(Date.class)) {
                        if (o.getClass().equals(Date.class)) {
                            field.set(obj, o);
                        } else {
                            field.set(obj, sdf.parse(o.toString()));
                        }
                    } else if (field.getType().equals(String.class)) {
                        if (o.getClass().equals(String.class)) {
                            field.set(obj, o);
                        } else {
                            field.set(obj, o.toString());
                        }
                    } else if (field.getType().equals(Long.class)) {
                        if (o.getClass().equals(Long.class)) {
                            field.set(obj, o);
                        } else {
                            field.set(obj, Long.parseLong(o.toString()));
                        }
                    } else if (field.getType().equals(Integer.class)) {
                        if (o.getClass().equals(Integer.class)) {
                            field.set(obj, o);
                        } else {
                            // 检查是否需要转换
                            String ostr = o.toString();
                            ostr = ostr.split("\\.").length > 0 ? ostr.split("\\.")[0] : ostr;
                            if (bool) {
                                field.set(obj, map.get(ostr) != null ? Integer.parseInt(map.get(ostr)) : Integer.parseInt(ostr));
                            } else {
                                field.set(obj, Integer.parseInt(ostr));
                            }

                        }
                    } else if (field.getType().equals(BigDecimal.class)) {
                        if (o.getClass().equals(BigDecimal.class)) {
                            field.set(obj, o);
                        } else {
                            String ovale = o.toString();
                            if (!StringUtils.isEmpty(ovale.trim())) {
                                field.set(obj, BigDecimal.valueOf(Double.parseDouble(ovale)));
                            }
                        }
                    } else if (field.getType().equals(Boolean.class)) {
                        if (o.getClass().equals(Boolean.class)) {
                            field.set(obj, o);
                        } else {
                            // 检查是否需要转换
                            if (bool) {
                                field.set(obj, map.get(o.toString()) != null ? Boolean.parseBoolean(map.get(o.toString())) : Boolean.parseBoolean(o.toString()));
                            } else {
                                field.set(obj, Boolean.parseBoolean(o.toString()));
                            }
                        }
                    } else if (field.getType().equals(Float.class)) {
                        if (o.getClass().equals(Float.class)) {
                            field.set(obj, o);
                        } else {
                            field.set(obj, Float.parseFloat(o.toString()));
                        }
                    } else if (field.getType().equals(Double.class)) {
                        if (o.getClass().equals(Double.class)) {
                            field.set(obj, o);
                        } else {
                            field.set(obj, Double.parseDouble(o.toString()));
                        }

                    }else if (field.getType().equals(Byte.class)) {
                        if (o.getClass().equals(Byte.class)) {
                            field.set(obj, o);
                        } else {
                            // 检查是否需要转换
                            if (bool) {
                                field.set(obj, map.get(o.toString()) != null ? Byte.valueOf(map.get(o.toString())) : Byte.valueOf(o.toString()));
                            } else {
                                field.set(obj, Byte.valueOf(o.toString()));
                            }
                        }

                    }

                }
            }

        } catch (Exception ex) {
            throw ex;
        }
    }


}
