package pubsub;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;
import javax.sound.midi.Soundbank;

/**
 * Created by sunbaolong on 2017/6/25.
 */
public class Consumer {


    public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    public static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageConsumer consumer = null;

        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, URL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = new ActiveMQTopic("FirstTopic");
            consumer = session.createConsumer(destination);

            long start = System.currentTimeMillis();
            long count = 1;
            long end = System.currentTimeMillis();
            long total = 0;

            while (true) {
                Message message = consumer.receive();
                if (message instanceof TextMessage) {
                    String text = ((TextMessage) message).getText();
                    if ("shutdown".equals(text)) {
                        total = System.currentTimeMillis() - start;
                        System.out.println(String.format("Received %d in %.2f seconds", count, (1.0 * total / 1000.0)));
                    } else {
                        int id = message.getIntProperty("id");
                        if (count != id) {
                            System.out.println("mismatch: " + count + "!=" + id);
                        }
                        count = id;
                        if (count == 1) {
                            start = System.currentTimeMillis();
                        }
                        if (count % 100 == 0) {
                            System.out.println(String.format("Receive %d message", count));
                        }
                        count++;
                    }
                } else {
                    System.out.println("Message error...");
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
