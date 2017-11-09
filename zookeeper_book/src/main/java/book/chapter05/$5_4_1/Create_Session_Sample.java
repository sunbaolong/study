package book.chapter05.$5_4_1;
import java.io.IOException;

import book.ConnectUtil;
import org.I0Itec.zkclient.ZkClient;

// 使用ZkClient来创建一个ZooKeeper客户端
public class Create_Session_Sample {
    public static void main(String[] args) throws IOException, InterruptedException {
    	ZkClient zkClient = new ZkClient("192.168.73.101:2181,192.168.73.102:2181,192.168.73.103:2181", 5000);
    	System.out.println("ZooKeeper session established.");
    }
}