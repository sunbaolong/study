import book.ConnectUtil;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * 清单7-1-4-1 使用正确的scheme进行授权
 */
public class Sample_AuthFailed1 implements Watcher {

    final static String SERVER_LIST = "192.168.73.101:2181,192.168.73.102:2181,192.168.73.103:2181";

    static ZooKeeper zkClient = null;

    public static void main(String[] args) throws Exception {

        zkClient = new ZooKeeper(SERVER_LIST, 300000, new Sample_AuthFailed1());

        try {
            zkClient.getData("/test", true, null);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            zkClient.getChildren("/test", true);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println(event.getState());
        System.out.println(event.getType());
    }

}
