package pubsub;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;

/**
 * Created by sunbaolong on 2017/6/25.
 */
public class Producer {

    public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    public static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageProducer producer = null;

        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, URL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            destination = session.createTopic("FirstTopic");
            destination = new ActiveMQTopic("FirstTopic");
            producer = session.createProducer(destination);
            for (int i = 1; i <= 20000; i++) {
                TextMessage message = session.createTextMessage(String.format("Send %d message", i));
                message.setIntProperty("id", i);
                producer.send(message);
                if (i % 100 == 0) {
                    System.out.println(String.format("Has send %d message", i));
                }
            }
            producer.send(session.createTextMessage("shutdown"));
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
