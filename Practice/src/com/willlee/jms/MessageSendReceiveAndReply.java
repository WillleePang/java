package com.willlee.jms;

import javax.jms.Connection;
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
public class MessageSendReceiveAndReply {
	
	public static void main(String[] args) throws Exception {
	
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
				"vm://localhost");

		Connection connection = factory.createConnection();
		connection.start();

		// ��Ϣ���͵����Queue
		Queue queue = new ActiveMQQueue("testQueue");

		// ��Ϣ�ظ������Queue
		Queue replyQueue = new ActiveMQQueue("replyQueue");

		final Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		// ����һ����Ϣ������������JMSReplyToΪreplyQueue��
		Message message = session.createTextMessage("Andy");
		message.setJMSReplyTo(replyQueue);

		MessageProducer producer = session.createProducer(queue);
		producer.send(message);

		// ��Ϣ�Ľ�����
		MessageConsumer comsumer = session.createConsumer(queue);
		comsumer.setMessageListener(new MessageListener() {
			public void onMessage(Message m) {
				try {
					// ����һ���µ�MessageProducer������һ���ظ���Ϣ��
					MessageProducer producer = session.createProducer(m
							.getJMSReplyTo());
					producer.send(session.createTextMessage("Hello "
							+ ((TextMessage) m).getText()));
				} catch (JMSException e1) {
					e1.printStackTrace();
				}
			}

		});

		// ����������������ջظ�����Ϣ
		MessageConsumer comsumer2 = session.createConsumer(replyQueue);
		comsumer2.setMessageListener(new MessageListener() {
			public void onMessage(Message m) {
				try {
					System.out.println(((TextMessage) m).getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
