import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sunbaolong on 2017/9/22.
 */
public class JConsoleThreadTest {

    private static void testBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {}
            }
        }, "testBusyThread");
        thread.start();
    }

    private static void testLockThread(final Object object) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    private static void testSynLockThread(final int a, final int b) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " a=" + a + ",b=" + b + " run");
                synchronized (Integer.valueOf(a)) {
                    System.out.println(Thread.currentThread().getName() + " " + a);
                    synchronized (Integer.valueOf(b)) {
                        System.out.println(Thread.currentThread().getName() + " " + b);
                        System.out.println(a + b);
                    }
                }
            }
        });
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException {
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            reader.readLine();
//            testBusyThread();
//            reader.readLine();
//            testLockThread(new Object());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Thread.sleep(10000);
        for (int i = 1; i <= 50; i++) {
            System.out.println("第" + i + "次循环");
            testSynLockThread(1, 2);
            testSynLockThread(2, 1);
        }
    }

}
