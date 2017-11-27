package book.chapter07.$7_2_4;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

//发起一个“获取数据”请求，分析其请求协议
public class A_simple_get_data_request implements Watcher {
    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("192.168.73.101:2181,192.168.73.102:2181,192.168.73.103:2181",//
        		5000,//
        		new A_simple_get_data_request());
        zk.getData("/$7_2_4/get_data", true, null);
    }
    public void process(WatchedEvent event) {}
}