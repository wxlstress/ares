package com.qudian.pay.ares.service.enums;

/**
 * Created with IntelliJ IDEA.
 * User: zhangdelong
 * Date: 18/3/13
 * Time: 下午7:10
 * Description:
 */
public enum EnumInstitution {

    JIANGXI("JX01", "江西银行", "/home/%s/%s/%s/");
    private String code;
    private String desc;
    private String path;

    EnumInstitution(String code, String desc, String path) {
        this.code = code;
        this.desc = desc;
        this.path = path;
    }

    public static EnumInstitution getEnumByCode(String code) {
        for (EnumInstitution enumInstitution : EnumInstitution.values()) {
            if (enumInstitution.code.equals(code)) {
                return enumInstitution;
            }
        }
        return null;
    }

    public static String getFilePath(EnumInstitution enumInstitution, String date, EnumReport enumReport) {
        return String.format(enumInstitution.path, enumInstitution.code, date, enumReport.getCode());
    }

    public static void main(String[] args) {
        System.out.println(getFilePath(EnumInstitution.JIANGXI, "20170110", EnumReport.DCDETAIL));
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
