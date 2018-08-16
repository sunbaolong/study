package excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunbaolong on 2017/11/7.
 */
public class PayExcelHandle {

    /** 取第几个sheet */
    private final static int SHEET_NUM = 1;
    /** excle 总列数 */
    private final static int COL_COUNT = 2;
    /** 三方流水的列索引 */
    private final static int TRADE_NO_NUM = 5;
    private final static int WRITE_TO_NO_NUM = 20;
    private final static int PAY_NAME_NUM = 20; // 支付字段所在的列
    private final static String TO_FILE = "//Users/sunbaolong/work/daojia/document/caiwu/201711/财付通交易账单-11月701.xlsx";
    private final static String FROM_FILE = "//Users/sunbaolong/work/daojia/document/caiwu/201710/from.txt";
    /** key为三方流水，value为服务项id */
    private final static Map<String, String> dbMap = new HashMap<String, String>();

    public static void main(String[] args) throws Exception {
//        initDatabaseData();

        // 从XLSX/ xls文件创建的输入流
        FileInputStream fis = new FileInputStream(TO_FILE);

        // 创建工作薄Workbook
        Workbook workBook = null;

        // 读取2007版，以    .xlsx 结尾
        if(TO_FILE.toLowerCase().endsWith("xlsx")){
            try {
                workBook = new XSSFWorkbook(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 读取2003版，以   .xls 结尾
        else if(TO_FILE.toLowerCase().endsWith("xls")){
            try {
                workBook = new HSSFWorkbook(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 得到 工作薄 的第 N个表
        Sheet sheet = workBook.getSheetAt(SHEET_NUM);
        Row row;
        String cell;
        for(int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++){
            System.out.print("开始解析第" + i + "行数据；");
            // 循环行数
            row = sheet.getRow(i);
            // 拿到此行的三方流水
            String tradeNo = row.getCell(TRADE_NO_NUM).toString();
            tradeNo = tradeNo.replace("\t", "");
            // 拿到此行的支付字段，并判断支付字段
            String payName = row.getCell(PAY_NAME_NUM).toString();
            System.out.print("支付字段：" + payName + "；");
            if ("到家家政".equals(payName)) { // 区分具体是什么服务项
                payName = "到家家政-小时工";
            } else if (!payName.startsWith("到家")) { // 在前面加上"到家平台-"
                payName = "到家平台-" + payName;
            }
            System.out.print("修改后支付字段：" + payName + "；");
            Cell payOrderIdCell = row.getCell(WRITE_TO_NO_NUM);
            payOrderIdCell.setCellValue(payName);
            System.out.println();
        }
        FileOutputStream fos = new FileOutputStream(TO_FILE);
        workBook.write(fos);
        fos.flush();
        //操作结束，关闭流
        fos.close();
    }

    private static void initDatabaseData() throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(new File(FROM_FILE))));
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
            String[] ss = s.split(",");
            dbMap.put(ss[0], ss[1]);
        }
    }

}
