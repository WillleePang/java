package com.willlee.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ProducerAndConsumer {
	private static Session session = null;

	static {
		try {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
					ActiveMQConnection.DEFAULT_PASSWORD, "tcp://192.168.136.135.61616");
			Connection connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void producer() throws Exception {
		Queue destination = session.createQueue("MessageQueue");
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		ObjectMessage objectMessage = session.createObjectMessage("hello everyone!");
		producer.send(objectMessage);
		session.commit();
	}

	public void consumer() throws Exception {
		Queue destination = session.createQueue("MessageQueue");
		MessageConsumer consumer = session.createConsumer(destination);
		while (true) {
			ObjectMessage receive = (ObjectMessage) consumer.receive();
			if (null != receive) {
				String messageContent = (String) receive.getObject();
				System.out.println(messageContent);
			} else {
				break;
			}
		}
	}

	public void topic() throws JMSException {
		Topic topic = session.createTopic("MessageTopic");
		MessageProducer producer = session.createProducer(topic);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		TextMessage message = session.createTextMessage();
		message.setText("message_hello_pangweili");
		producer.send(message);
	}

	public void listener() throws JMSException {
		Topic topic = session.createTopic("MessageTopic");
		MessageConsumer consumer = session.createConsumer(topic);
		consumer.setMessageListener(new MessageListener() {

			public void onMessage(Message message) {
				TextMessage tm = (TextMessage) message;
				try {
					System.out.println(tm.getText());
				} catch (Exception e) {
				}
			}
		});
	}

}
