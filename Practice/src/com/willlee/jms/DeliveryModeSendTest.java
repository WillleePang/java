package com.willlee.jms;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;


public class DeliveryModeSendTest {
	public static void main(String[] args) throws Exception {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		Connection connection = factory.createConnection();
		connection.start();

		Queue queue = new ActiveMQQueue("testQueue");
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		MessageProducer producer = session.createProducer(queue);
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		producer.send(session.createTextMessage("a persistent message"));
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		producer.send(session.createTextMessage("A non persistent Message"));
		System.out.println("Send messages sucessfully!");

		MessageConsumer comsumer = session.createConsumer(queue);
		comsumer.setMessageListener(new MessageListener() {
			public void onMessage(Message m) {
				try {
					System.out.println("Consumer get "
							+ ((TextMessage) m).getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});

	}
}
