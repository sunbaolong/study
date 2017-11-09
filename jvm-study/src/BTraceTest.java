import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

/**
 * Created by sunbaolong on 2017/9/24.
 */
public class BTraceTest {

    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            System.out.println("请输入回车...");

            reader.readLine();

            int a = (int) (Math.random() * 1000);
            int b = (int) (Math.random() * 1000);

            System.out.println(add(a, b));
        }
    }

}
