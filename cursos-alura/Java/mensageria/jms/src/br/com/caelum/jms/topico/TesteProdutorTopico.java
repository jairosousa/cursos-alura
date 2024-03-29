package br.com.caelum.jms.topico;

import br.com.caelum.modelo.Pedido;
import br.com.caelum.modelo.PedidoFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.xml.bind.JAXB;
import java.io.StringWriter;

public class TesteProdutorTopico {

    public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination topico = (Destination) context.lookup("loja");

        MessageProducer producer = session.createProducer(topico);

        Pedido pedido = new PedidoFactory().geraPedidoComValores();

        StringWriter write = new StringWriter();
        JAXB.marshal(pedido, write);
        String xml = write.toString();
        System.out.println(xml,);

            Message message = session.createTextMessage(xml);
//            message.setBooleanProperty("ebook", true);
            producer.send(message);


        session.close();
        connection.close();
        context.close();
    }
}
