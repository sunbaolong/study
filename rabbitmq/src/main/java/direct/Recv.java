package direct;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by sunbaolong on 2017/7/4.
 */
public class Recv {

    private static final String QUEUE_NAME = "queue_1";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicQos(1);
        System.out.println("[*] Waiting for message.To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            int i = 0;
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    if (i == 100) {
                        try {
                            Thread.sleep(1000 * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String message = new String(body);
                    System.out.println("[X] Received '" + message + "'");
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        channel.basicConsume(QUEUE_NAME, false, consumer);
    }

}
