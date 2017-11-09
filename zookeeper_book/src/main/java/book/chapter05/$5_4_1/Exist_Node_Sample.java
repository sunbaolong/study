package book.chapter05.$5_4_1;

import book.ConnectUtil;
import org.I0Itec.zkclient.ZkClient;

//ZkClient检测节点是否存在
public class Exist_Node_Sample {
    public static void main(String[] args) throws Exception {
    	String path = "/zk-book";
    	ZkClient zkClient = new ZkClient("192.168.73.101:2181,192.168.73.102:2181,192.168.73.103:2181", 2000);
        System.out.println("Node " + path + " exists " + zkClient.exists(path));
    }
}