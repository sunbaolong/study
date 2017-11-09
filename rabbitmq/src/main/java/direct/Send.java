package direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by sunbaolong on 2017/7/4.
 */
public class Send {

    private static final String QUEUE_NAME = "queue_1";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        for (int i = 1; i <= 100; i++) {
            message = "message " + i;
            System.out.println("[x] Sent '" + message + "'");
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }

        channel.close();
        connection.close();
    }

}
