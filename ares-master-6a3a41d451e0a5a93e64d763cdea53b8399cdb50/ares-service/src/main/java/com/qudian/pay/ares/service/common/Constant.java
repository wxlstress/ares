package com.qudian.pay.ares.service.common;

/**
 * Created by zhangdelong on 17/1/15.
 */
public class Constant {
    public static class sys{
        public final static int sys_id = -1;
        public final static String sys_name = "系统";
    }
    public static class taskInfo {
        //'任务状态：0:初始化,1:已完成,2:失败',
        public final static int task_status_init = 0;
        public final static int task_status_done = 1;
        public final static int task_status_faile = 2;
        //'任务类型：0:数据初始化，1:定时任务,2手动触发',
        public final static int task_type_data_init = 0;
        public final static int task_type_timer = 1;
        public final static int task_type_hand = 2;

        //
        public final static String zhaiquanzhuanrang = "债权转让";
        public final static String wangjinshe = "网金社";

        public  final static String FAILE_MSG ="系统异常";
    }
}
