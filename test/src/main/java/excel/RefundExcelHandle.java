package excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
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
public class RefundExcelHandle {

    /** excle 总列数 */
    private final static int COL_COUNT = 2;
    /** 三方流水的列索引 */
    private final static int TRADE_NO_NUM = 1;
    private final static int WRITE_TO_NO_NUM = 2;
    private final static String TO_FILE = "//Users/sunbaolong/work/daojia/document/caiwu/201710/支付宝退款201710.xlsx";
    private final static String FROM_FILE = "//Users/sunbaolong/work/daojia/document/caiwu/201710/from.txt";
    /** key为三方流水，value为商户订单号 */
    private final static Map<String, String> dbMap = new HashMap<String, String>();

    public static void main(String[] args) throws Exception {
        initDatabaseData();

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
        //Get the number of sheets in the xlsx file
        int numberOfSheets = workBook.getNumberOfSheets();

        // 循环 numberOfSheets
        for(int sheetNum = 0; sheetNum < numberOfSheets; sheetNum++){

            // 得到 工作薄 的第 N个表
            Sheet sheet = workBook.getSheetAt(sheetNum);
            Row row;
            String cell;
            for(int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++){
                // 循环行数
                row = sheet.getRow(i);
                // 拿到此行的三方流水
                String tradeNo = row.getCell(TRADE_NO_NUM).toString();
                tradeNo = tradeNo.replace("\t", "");
                // 从dbMap缓存中拿到商户订单号
                String payOrderId = dbMap.get(tradeNo);
                Cell payOrderIdCell = row.getCell(WRITE_TO_NO_NUM);
                payOrderIdCell.setCellValue(payOrderId);
            }
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
