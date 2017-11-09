package direct;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by sunbaolong on 2017/7/4.
 */
public class RecvBind {

    private static final String QUEUE_NAME = "queue_1";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.exchangeDeclare("bind_logs", "direct");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, "bind_logs", "one");

//        channel.basicQos(1);
        System.out.println("[*] Waiting for message.To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    String message = new String(body);
                    System.out.println("[X] Received '" + message + "'");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
//                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        channel.basicConsume(queueName, true, consumer);
    }

}
