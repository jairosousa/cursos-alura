package br.com.caelum.jms.topico;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Properties;
import java.util.Scanner;

public class TesteConsumidorTopicoComercial {

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.setProperty("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");

        properties.setProperty("java.naming.provider.url", "tcp://192.168.15.5:61616");
        properties.setProperty("queue.financeiro", "fila.financeiro");

        InitialContext context = new InitialContext(properties);

//        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.setClientID("comercial");
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topico = (Topic) context.lookup("loja");

        MessageConsumer consumer = session.createDurableSubscriber(topico, "assinatura");

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {

                TextMessage textMessage = (TextMessage) message;

                try {
                    System.out.println("Recebendo msg: " + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        });


        new Scanner(System.in).nextLine();


        session.close();
        connection.close();
        context.close();
    }
}
