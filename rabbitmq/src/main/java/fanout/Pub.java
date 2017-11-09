package fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by sunbaolong on 2017/7/5.
 */
public class Pub {

    // 定义exchange名称
    private final static String EXCANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 创建exchange
        channel.exchangeDeclare(EXCANGE_NAME, "fanout");

        for (int i = 1; i <= 10; i++) {
            String message = "message " + i;

            System.out.println("[S]" + message);

            channel.basicPublish(EXCANGE_NAME, "", null, message.getBytes());
        }

        channel.close();
        connection.close();
    }

}
