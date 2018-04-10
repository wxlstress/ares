package com.qudian.pay.ares.dao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间格式化类
 *
 * @author wangyunfeng
 */
public class DateUtil {
//    private final SimpleDateFormat shortSdf;
//    private final SimpleDateFormat longHourSdf;
//    private final SimpleDateFormat longSdf;
//
//    public DateUtil() {
//        this.shortSdf = new SimpleDateFormat("yyyy-MM-dd");
//        this.longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
//        this.longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    }

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static Date addYear(Date date, int year) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, year);//属性很多也有月等等，可以操作各种时间日期
        return c.getTime();
    }

    public static String formatToSecond(Date date) {
        java.text.DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }

    public static String formatToDay(Date date) {
        java.text.DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

    public static String formatToDay2(Date date) {
        if (date == null) return "";
        java.text.DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public static String formatToDay3(Date date) {
        java.text.DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static String formatToMinute(Date date) {
        java.text.DateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        return format.format(date);
    }

    public static String formatToMonth(Date date) {
        java.text.DateFormat format = new SimpleDateFormat("yyyyMM");
        return format.format(date);
    }

    public static Date formatToMonthNoDay(String date) throws ParseException {
        java.text.DateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.parse(date);
    }

    public static String formatToHour(Date date) {
        java.text.DateFormat format = new SimpleDateFormat("yyyyMMddHH");
        return format.format(date);
    }

    public static String formatToYear(Date date) {
        java.text.DateFormat format = new SimpleDateFormat("yyyy");
        return format.format(date);
    }

    public static Date stringSecondToDate(String str) throws ParseException {
        java.text.DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.parse(str);
    }

    public static Date stringSecondToDate2(String str) throws ParseException {
        java.text.DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(str);
    }

    public static Date stringDateToDate(String str) throws ParseException {
        java.text.DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.parse(str);
    }

    public static Date stringDateToDate2(String str) throws ParseException {
        java.text.DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(str);
    }

    public static Date addDay(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, day);//属性很多也有月等等，可以操作各种时间日期
        return c.getTime();
    }

    public static String addDayFormat(Date date, int day, String mat) {
        java.text.DateFormat format = new SimpleDateFormat(mat);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, day);//属性很多也有月等等，可以操作各种时间日期

        return format.format(c.getTime());
    }

    public static Date addMinutes(Date date, int minutes) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minutes);//属性很多也有月等等，可以操作各种时间日期
        return c.getTime();
    }

    public static String addDayFormat0(Date date, int day) {
        java.text.DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 000);

        return format.format(c.getTime());
    }

    public static String addDayFormat(Date date, int day) {

        java.text.DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - 1);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);

        return format.format(c.getTime());
    }

    public static String getYesterdayStart() {
        java.text.DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 000);

        return format.format(c.getTime());
    }

    public static String getYesterdayEnd() {

        java.text.DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - 1);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);

        return format.format(c.getTime());
    }


    /**
     * 得到昨日日期
     *
     * @param date 日期
     * @return Date
     */
    public static Date getYesterdayForDay(Date date) {
        try {
            return stringDateToDate(formatToDay(addDay(date, -1)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date getYesterDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);
        return calendar.getTime();
    }
/*

    public static Date getStartTime(Date date) {
        if (ObjectUtil.isNull(date)) return null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
*/

    public static Date getEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

//    public static Date getStartTime(String strDate) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = null;
//        try {
//            date = simpleDateFormat.parse(strDate);
//        } catch (Exception e) {
//            LogUtil.logInfo(logger, "转换时间异常" + e.getMessage() + "传入时间为" + strDate);
//            return null;
//        }
//        return getStartTime(date);
//    }

    public static Date getEndTime(String strDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(strDate);
        } catch (Exception e) {
            //   LogUtil.logInfo(logger, "转换时间异常" + e.getMessage() + "传入时间为" + strDate);
            return null;
        }
        return getEndTime(date);
    }

    /**
     * 获取昨天的日期，时分秒为0
     *
     * @return
     */
    public static Date getYesterday() {

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 000);

        return c.getTime();
    }

    /**
     * 计算两
     * 个时间差
     */
    public static Long dateDiff(String startTime, String endTime) {
        if (StringUtils.isEmpty(startTime) || StringUtils.isEmpty(startTime))
            return null;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        // 获得两个时间的毫秒时间差异
        try {
            diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
            day = diff / nd;// 计算差多少天
            hour = diff % nd / nh + day * 24;// 计算差多少小时
            min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
            sec = diff % nd % nh % nm / ns;// 计算差多少秒
            // 输出结果
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hour;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        /*Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();*/
        long between_days = (bdate.getTime() - smdate.getTime()) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static String getDateStr(String strTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Long time = new Long(strTime);
        return format.format(time);

    }

    /**
     * 获取本月的1号
     */
    public static Date thisMonthFirstDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 比较两个日期大小
     *
     * @param DATE1
     * @param DATE2
     * @return
     */
    public static int compareDate(String DATE1, String DATE2) {


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {

                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {

                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static Date stringDateToDate9(String str) throws ParseException {
        java.text.DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        return format.parse(str);
    }

    public static Date stringDateToDate10(String str) throws ParseException {
        java.text.DateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.parse(str);
    }

    /*
  * 获取当前月的下个月的前一天
  *
  * eg:今天日期 2016-09-14
  * return : 2016-10-13
  *
  */
    public static String getNextMonthDay(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);

        return String.valueOf(sdf.format(calendar.getTime()));
    }

    /**
     * 获取某月的天数
     *
     * @throws
     * @Title:getLastDayOfMonth
     * @Description:
     * @param:@param year
     * @param:@param month
     * @param:@return
     * @return:String
     */
    public static Integer getDayOfMonth(Date dateStr) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(sdf.format(dateStr));
        Calendar cal = Calendar.getInstance();
        cal.setTime(parse);
        //设置年份
      /*  cal.set(Calendar.YEAR,year);*/
        //设置月份
        //  cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return lastDay;
        //设置日历中月份的最大天数
       /* cal.set(Calendar.DAY_OF_MONTH, lastDay);*/
       /* //格式化日期*/
/*
*/

       /* String lastDayOfMonth = sdf.format(cal.getTime());*/
/*
*/

       /* return lastDayOfMonth;*/
    }

    /**
     * 获取上个月的今天
     *
     * @param date
     * @return
     */
    public static Date getBeforeMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    public static int getMonthSpace(String date1, String date2)
            throws ParseException {

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));

        result = c2.get(Calendar.MONDAY) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);
    }

    /*
         * 获取一个到另一个时间段内的月份(2016-01 :2016-05)
         *
         * @param beginDate
         * @param endDate
         * @return 例如 [2016-01-01,2016-01-31] ,[2016-02-01,2016-02-28]
         * @throws Exception
         */
    public static List<String[]> getMonths(String beginDate, String endDate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date beginD = sdf.parse(beginDate);
        Date endD = sdf.parse(endDate);
        Calendar c = Calendar.getInstance();
        List<String[]> rs = new LinkedList<>();
        while (beginD.before(endD)) {
            c.setTime(beginD);
            addMonth(sdf, beginD, c, rs);
            c.add(Calendar.MONTH, 1);
            beginD = c.getTime();
        }
        addMonth(sdf, beginD, c, rs);
        return rs;
    }

    private static void addMonth(SimpleDateFormat sdf, Date beginD, Calendar c, List<String[]> rs) {
        String[] s = new String[2];
        String formatMonth = sdf.format(beginD);
        s[0] = new StringBuilder().append(formatMonth).append("-").
                append("01").toString();
        s[1] = new StringBuilder().append(formatMonth).append("-").
                append(c.getActualMaximum(Calendar.DAY_OF_MONTH)).toString();
        rs.add(s);
    }

    /**
     * 获得本天的开始时间，即2012-01-01 00:00:00
     *
     * @return
     */
    public static Date getCurrentDayStartTime(Date now) {
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            now = simpleDateFormat.parse(shortSdf.format(now));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获得本天的结束时间，即2012-01-01 23:59:59
     *
     * @return
     */
    public static Date getCurrentDayEndTime(Date now) {
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        // Date now = new Date();
        try {
            now = longSdf.parse(shortSdf.format(now) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }


    /**
     * @param dBegin
     * @param dEnd
     * @return
     */
    public static List<Date> getDateRange(Date dBegin, Date dEnd) {
        List lDate = new ArrayList();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }

    /**
     * 两个日期间的时间差(天)
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int dayDiff(String startDate, String endDate) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date sDate = df.parse(startDate);
        Date eDate = df.parse(endDate);
        long diff = eDate.getTime() - sDate.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        return (int) days;
    }

    public static void main(String[] args) throws ParseException {
//        BigDecimal b1 = new BigDecimal("100").multiply(new BigDecimal("10").divide(new BigDecimal("100")));
//        BigDecimal b2 = b1.divide(new BigDecimal("365"), 5, BigDecimal.ROUND_HALF_UP);
//        int num = DateUtil.dayDiff("2017-05-01", "2017-05-31");
//        BigDecimal b3 = b2.multiply(BigDecimal.valueOf(num));
//        System.out.println(b3);

        //System.out.println(differentDays(DateUtil.stringDateToDate2("2016-02-01"), DateUtil.stringDateToDate2("2016-03-01")));
    }


}
