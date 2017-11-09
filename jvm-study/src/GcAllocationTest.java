import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbaolong on 2017/9/11.
 */
public class GcAllocationTest {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] b1 = new byte[ 2 * _1MB];
        byte[] b2 = new byte[ 2 * _1MB];
        byte[] b3 = new byte[ 2 * _1MB];
        byte[] b4 = new byte[ 2 * _1MB];
        byte[] b5 = new byte[ 4 * _1MB];

//        try {
//            List<OOMTest> list = new ArrayList<>();
//            for (int i = 0; i < 2000; i++) {
//                System.out.println("当前次数:" + i);
//                Thread.sleep(20);
//                list.add(new OOMTest());
//            }
//            System.gc();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    static class OOMTest {
        byte[] bytes = new byte[64 * 1024];
    }
}
