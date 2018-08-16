package excel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by sunbaolong on 2017/12/2.
 */
public class PayCsvHandle {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new File("//Users/sunbaolong/work/daojia/document/caiwu/201711/财付通交易账单-11月701.xlsx"));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
        String s = null;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
            String[] arr = s.split(",");
            System.out.println(arr[0]);
            Thread.sleep(1000);

        }
    }

}
