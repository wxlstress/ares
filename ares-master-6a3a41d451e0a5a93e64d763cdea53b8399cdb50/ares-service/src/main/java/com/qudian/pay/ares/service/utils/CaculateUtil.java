package com.qudian.pay.ares.service.utils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zhangdelong on 17/1/14.
 */
public class CaculateUtil {


    /**
     * 等额本息计算获取还款方式为等额本息的每月偿还本金和利息
     * <p>
     * 公式：每月偿还本息=〔贷款本金×月利率×(1＋月利率)＾还款月数〕÷〔(1＋月利率)＾还款月数-1〕
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalmonth 还款总月数
     * @return 每月偿还本金和利息, 不四舍五入，直接截取小数点最后两位
     */
    public static double getPerMonthPrincipalInterest(double invest, double yearRate, int totalmonth) {
        double monthRate = yearRate / 12;
        BigDecimal monthIncome = new BigDecimal(invest)
                .multiply(new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth)))
                .divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2, BigDecimal.ROUND_DOWN);
        return monthIncome.doubleValue();
    }

    /**
     * 等额本息计算获取还款方式为等额本息的每月偿还利息
     * <p>
     * 公式：每月偿还利息=贷款本金×月利率×〔(1+月利率)^还款月数-(1+月利率)^(还款月序号-1)〕÷〔(1+月利率)^还款月数-1〕
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   月利率
     * @param totalmonth 还款总月数
     * @param rounding   BigDecimal.ROUND_HALF_UP :四舍五入 ?
     * @return 每月偿还利息
     */
    public static Map<Integer, BigDecimal> getPerMonthInterest(double invest, double yearRate, int totalmonth, int rounding) {
        Map<Integer, BigDecimal> map = new HashMap<Integer, BigDecimal>();
        double monthRate = yearRate / 12;
        BigDecimal monthInterest;
        for (int i = 1; i < totalmonth + 1; i++) {
            BigDecimal multiply = new BigDecimal(invest).multiply(new BigDecimal(monthRate));
            BigDecimal sub = new BigDecimal(Math.pow(1 + monthRate, totalmonth)).subtract(new BigDecimal(Math.pow(1 + monthRate, i - 1)));
            monthInterest = multiply.multiply(sub).divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2, rounding);
            monthInterest = monthInterest.setScale(2, rounding);
            map.put(i, monthInterest);
        }
        // System.out.println(map);
        return map;
    }

    /**
     * 等额本息计算获取还款方式为等额本息的每月偿还本金
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalmonth 还款总月数
     * @return 每月偿还本金
     */
    public static Map<Integer, BigDecimal> getPerMonthPrincipal(double invest, double yearRate, int totalmonth, int rounding) {
        double monthRate = yearRate / 12;
        BigDecimal monthIncome = new BigDecimal(invest)
                .multiply(new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth)))
                .divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2, rounding);
        Map<Integer, BigDecimal> mapInterest = getPerMonthInterest(invest, yearRate, totalmonth, rounding);
        Map<Integer, BigDecimal> mapPrincipal = new HashMap<Integer, BigDecimal>();

        for (Map.Entry<Integer, BigDecimal> entry : mapInterest.entrySet()) {
            mapPrincipal.put(entry.getKey(), monthIncome.subtract(entry.getValue()));
        }
        return mapPrincipal;
    }

    /**
     * 等额本息计算获取还款方式为等额本息的总利息
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalmonth 还款总月数
     * @return 总利息
     */
    public static double getInterestCount(double invest, double yearRate, int totalmonth, int rounding) {
        //  System.out.println("总借款额（贷款本金）=" + invest + "年利率=" + yearRate + "还款总月数" + totalmonth);
        BigDecimal count = new BigDecimal(0);
        Map<Integer, BigDecimal> mapInterest = getPerMonthInterest(invest, yearRate, totalmonth, rounding);

        for (Map.Entry<Integer, BigDecimal> entry : mapInterest.entrySet()) {
            count = count.add(entry.getValue());
        }
        return count.doubleValue();
    }

    /**
     * 应还本金总和
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalmonth 还款总月数
     * @return 应还本金总和
     */
    public static double getPrincipalInterestCount(double invest, double yearRate, int totalmonth) {
        double monthRate = yearRate / 12;
        BigDecimal perMonthInterest = new BigDecimal(invest)
                .multiply(new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth)))
                .divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2, BigDecimal.ROUND_DOWN);
        BigDecimal count = perMonthInterest.multiply(new BigDecimal(totalmonth));
        count = count.setScale(2, BigDecimal.ROUND_DOWN);
        return count.doubleValue();
    }

    public static void main(String[] args) {
//        double invest = 1500; // 本金
//
//        int month = 3;
//        double yearRate = 0.15/12; // 年利率
//        //  double monthRate = yearRate / 12;
//
//        //BigDecimal lilv = new BigDecimal("10").divide(new BigDecimal("100")).divide(new BigDecimal("12"), 16, BigDecimal.ROUND_DOWN);
//        //BigDecimal lilv = (new BigDecimal("15").divide(new BigDecimal("100")).divide(new BigDecimal("365"), 10, BigDecimal.ROUND_DOWN)).multiply(new BigDecimal("7"));
////        BigDecimal a = new BigDecimal(3.22);
////        BigDecimal b = new BigDecimal(3.22);
////        System.out.println(a.doubleValue()>=b.doubleValue());getPerMonthInterest
//
//        Map<Integer, BigDecimal> mapInterest  = getPerMonthPrincipal(invest, yearRate, month);
////
//        System.out.println("等额本息---每月还款本息：" + mapInterest);
//        Map<Integer, BigDecimal> mapInterest = getPerMonthInterest(invest, yearRate, month);
//        System.out.println("等额本息---每月还款利息：" + mapInterest);
//        Map<Integer, BigDecimal> mapPrincipal = getPerMonthPrincipal(invest, yearRate, month);
//        System.out.println("等额本息---每月还款本金：" + mapPrincipal);
//        double count = getInterestCount(invest, yearRate, month);
//        System.out.println("等额本息---总利息：" + count);
//        double principalInterestCount = getPrincipalInterestCount(invest, yearRate, month);
//        System.out.println("等额本息---应还本息总和：" + principalInterestCount);
//        BigDecimal daiFanglixi = new BigDecimal(0.00);
//        BigDecimal jieFanglixi = new BigDecimal(1.2);
//        BigDecimal activityRate = new BigDecimal(0.00);
//        activityRate = (jieFanglixi.divide(new BigDecimal("7"), 32, BigDecimal.ROUND_DOWN)).multiply(new BigDecimal("365"));
//        System.out.println(activityRate);
//        BigDecimal lilv = new BigDecimal("15").divide(new BigDecimal("100")).divide(new BigDecimal("12"), 32, BigDecimal.ROUND_DOWN);
//        BigDecimal sumlixi = BigDecimal.valueOf(Utils.getInterestCount(1002, lilv.doubleValue(), 1));
//
//
//        BigDecimal daiFanglixi = sumlixi.subtract((sumlixi.divide(new BigDecimal(1), 2, BigDecimal.ROUND_DOWN).multiply((new BigDecimal(1).subtract(new BigDecimal("1"))))));
//        BigDecimal jieFanglixi = new BigDecimal("2.00").subtract(daiFanglixi);
//        System.out.println("daiFanglixi=" + daiFanglixi + "_jieFanglixi=" + jieFanglixi);

//        @param invest     总借款额（贷款本金）
//        * @param yearRate   年利率
//        * @param totalmonth 还款总月数
//        * @return 每月偿还本金
//
//        double invest = 1000;
//        double yearRate = new BigDecimal("23.00").divide(new BigDecimal("100")).doubleValue();
//        int totalmonth = 6;
//        int rounding = BigDecimal.ROUND_HALF_UP;
//        Map<Integer, BigDecimal> map = getPerMonthPrincipal(invest, yearRate, totalmonth, rounding);
////        Map<Integer, BigDecimal> treeMap = new TreeMap();
////        treeMap = map;
//        System.out.println(map);
//        BigDecimal cap = new BigDecimal("0.00");
//        for (Map.Entry<Integer, BigDecimal> entry : map.entrySet()) {
//            if (entry.getKey() > 2) {
//                break;
//            }else {
//                cap = cap.add(entry.getValue());
//            }
//        }
//        System.out.println(cap);
        double invest = 100;
        double yearRate = new BigDecimal("10").divide(new BigDecimal("100")).doubleValue();
        int totalmonth = 6;
        int rounding = BigDecimal.ROUND_HALF_UP;
        Map<Integer, BigDecimal> map = CaculateUtil.getPerMonthInterest(invest,yearRate,totalmonth, BigDecimal.ROUND_HALF_UP);
        System.out.println(map);

    }
}
