package direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by sunbaolong on 2017/7/4.
 */
public class SendBind {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.exchangeDeclare("bind_logs", "direct");

        String message = "Hello World!";
        for (int i = 1; i <= 100; i++) {
            message = "message " + i;
            System.out.println("[x] Sent '" + message + "'");
            channel.basicPublish("bind_logs", "one", null, message.getBytes());
        }

        channel.close();
        connection.close();
    }

}
