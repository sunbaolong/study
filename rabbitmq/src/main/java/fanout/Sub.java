package fanout;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by sunbaolong on 2017/7/5.
 */
public class Sub {

    // 定义exchange名称
    private final static String EXCANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 创建exchange
        channel.exchangeDeclare(EXCANGE_NAME, "fanout");
        // 创建queue
        String queueName = channel.queueDeclare().getQueue();
        // 绑定
        channel.queueBind(queueName, EXCANGE_NAME, "");

        System.out.println("Waiting for messages...");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("Received '" + message + "'");
            }
        };

        channel.basicConsume(queueName, true, consumer);
    }
}
