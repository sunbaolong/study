package book.chapter05.$5_4_1;
import book.ConnectUtil;
import org.I0Itec.zkclient.ZkClient;

// 使用ZkClient创建节点
public class Create_Node_Sample {

    public static void main(String[] args) throws Exception {
    	ZkClient zkClient = new ZkClient("192.168.73.101:2181,192.168.73.102:2181,192.168.73.103:2181", 5000);
        String path = "/zk-book/c1";
        zkClient.createPersistent(path, true);
    }
}