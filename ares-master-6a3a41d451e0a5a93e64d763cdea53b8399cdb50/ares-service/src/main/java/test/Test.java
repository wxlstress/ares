package test;

import com.qudian.pay.ares.dao.entity.laifenqi.BillItems;
import com.qudian.pay.ares.dao.entity.local.BaseOrderId;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.util.DateUtil;
import com.qudian.pay.ares.service.utils.CsvUtils;
import com.qudian.pay.ares.service.utils.FileUtils;
import com.qudian.pay.ares.service.utils.Utils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by zhangdelong on 17/1/14.
 */
public class Test {

    //    //    private static final Integer TASK_SIZE = 2000;
////
////    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
////
//////        Date time = new Date();
//////        Calendar cal = Calendar.getInstance();
//////        cal.setTime(time);
//////        Date begin = DateUtil.getCurrentDayStartTime(cal.getTime());
//////        Date end = DateUtil.getCurrentDayEndTime(cal.getTime());
//////        System.out.println(begin+"----"+end);
////
////
////    }
//    Thread t = new Thread(new Runnable() {
//        @Override
//        public void run() {
//
//        }
//    });
//    public static void main(String[] args) {
//        BigDecimal b = new BigDecimal("44.24");
//        System.out.println( b.subtract(new BigDecimal("12.57")));
//    }
//    public static void main(String[] args) {
//        Integer TASK_SIZE = 100;
//        int orderSize = 10000;
//        int end = 0;
//        int begin =0;
//        int size = orderSize % TASK_SIZE == 0 ? orderSize / TASK_SIZE : orderSize / TASK_SIZE + 1;
//        System.out.println(size);
//        for (int i = 0; i <= size - 1; i++) {
//             begin = (i * TASK_SIZE)+1;
//            end = ((i + 1) * TASK_SIZE);
//            System.out.println("--b---"+begin+"--e---"+end);
//        }
//    }

    //    public static void main(String[] args) throws IOException, FileNotFoundException {
//        // 要被压缩的文件夹
//        String fileName1 ="/Users/zhangdelong/Desktop/wait.online.sql/aaa";
//        File file = new File(fileName1);
//        String zipFileName = "/Users/zhangdelong/Desktop/wait.online.sql/a.zip";
//        File zipFile = new File(zipFileName);
//
//        InputStream input = null;
//        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
//        // zip的名称为
//        zipOut.setComment(file.getName());
//        if (file.isDirectory()) {
//            File[] files = file.listFiles();
//            for (int i = 0; i < files.length; ++i) {
//                input = new FileInputStream(files[i]);
//                zipOut.putNextEntry(new ZipEntry(file.getName() + File.separator + files[i].getName()));
//                int temp = 0;
//                while ((temp = input.read()) != -1) {
//                    zipOut.write(temp);
//                }
//                input.close();
//            }
//        }
//        zipOut.close();
//    }


    //
//    public static void main(String[] args) throws Exception {
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        Date d2 = df.parse("2004-12-31");
//        Date d1 = df.parse("2005-1-1");
//        long diff = d1.getTime() - d2.getTime();
//        long days = diff / (1000 * 60 * 60 * 24);
//        System.out.println(days);
//    }
//
//    public static String readTxtLine(String txtPath, int lineNo) {
//
//        String line = "";
//        String encoding = "GBK";
//        try {
//            File txtFile = new File(txtPath);
//            InputStream in = new FileInputStream(txtFile);
//            InputStreamReader read = new InputStreamReader(in, encoding);
//            BufferedReader reader = new BufferedReader(read);
//            int i = 0;
//            while (i < lineNo) {
//                line = reader.readLine();
//                i++;
//            }
//            reader.close();
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//
//        return line;
//    }

    public static void main(String[] args) {
//        BigDecimal lilv = new BigDecimal("15").divide(new BigDecimal("100")).divide(new BigDecimal("365"), 32, BigDecimal.ROUND_DOWN).multiply(new BigDecimal("7").divide(new BigDecimal("12"), 32, BigDecimal.ROUND_DOWN));
//      BigDecimal  sumlixi = BigDecimal.valueOf(Utils.getInterestCount(new BigDecimal("800").doubleValue(), lilv.doubleValue(), 6));
//        //判断是否为最后一期？
//        if (orders.getFenqi() == Integer.valueOf(billItems.getOrder())) {
//            //  贷方末期利息 = sumlixi -［ (sumlixi/期数)*(期数 - 1)］
//           BigDecimal daiFanglixi = sumlixi.subtract((sumlixi.divide(new BigDecimal(6), 2, BigDecimal.ROUND_DOWN).multiply((new BigDecimal(6).subtract(new BigDecimal("1"))))));
//            if (daiFanglixi.doubleValue() >= billItems.getInterest().doubleValue()) {
//                daiFanglixi = billItems.getInterest();
//              BigDecimal  jieFanglixi = new BigDecimal("0.00");
//            } else {
//              BigDecimal  jieFanglixi = billItems.getInterest().subtract(daiFanglixi);
//            }
//
//        }

        BigDecimal lilv = new BigDecimal("15").divide(new BigDecimal("100")).divide(new BigDecimal("365"), 32, BigDecimal.ROUND_DOWN).multiply(new BigDecimal("7").divide(new BigDecimal("12"), 32, BigDecimal.ROUND_DOWN));
         BigDecimal  sumlixi = BigDecimal.valueOf(Utils.getInterestCount(new BigDecimal("800").doubleValue(), lilv.doubleValue(), 6));
        BigDecimal daiFanglixi = sumlixi.divide(new BigDecimal(6), 2, BigDecimal.ROUND_DOWN);
        BigDecimal   jieFanglixi;
        if (daiFanglixi.doubleValue() >= 8) {
            daiFanglixi = new BigDecimal("8");
            jieFanglixi= new BigDecimal("0.00");
        } else {
            //贷方当期利息 = 当期应收利息 - 贷方当期利息
           jieFanglixi = new BigDecimal("8").subtract(daiFanglixi);
        }
        System.out.println("jieFanglixi="+jieFanglixi+"---daiFanglixi"+daiFanglixi);
    }
}
