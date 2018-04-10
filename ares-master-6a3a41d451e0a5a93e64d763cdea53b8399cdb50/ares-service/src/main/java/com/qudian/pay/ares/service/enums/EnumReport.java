package com.qudian.pay.ares.service.enums;

/**
 * Created with IntelliJ IDEA.
 * User: zhangdelong
 * Date: 18/3/13
 * Time: 下午7:12
 * Description:
 */
public enum EnumReport {
    LOANDETAIL("loandetail", "放款明细"),
    REPAYPLAN("payplan", "还款计划"),
    REPAYDETAIL("paylog", "还款明细"),
    YQDETAIL("indemnity", "逾期明细"),
    DCDETAIL("overdue", "代偿明细"),;

    private String code;
    private String desc;

    EnumReport(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static EnumReport getEnumByCode(String code) {
        for (EnumReport enumReport : EnumReport.values()) {
            if (enumReport.code.equals(code)) {
                return enumReport;
            }
        }
        return null;
    }

    public static EnumReport existEnum(String code) {
        for (EnumReport enumReport : EnumReport.values()) {
            if (code.contains(enumReport.code)) {
                return enumReport;
            }
        }
        return null;
    }

    public static String getFileName(String code,String date) {
        for (EnumReport enumReport : EnumReport.values()) {
            if (code.contains(enumReport.code)) {
                return enumReport.getCode()+"_"+date+".csv";
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
