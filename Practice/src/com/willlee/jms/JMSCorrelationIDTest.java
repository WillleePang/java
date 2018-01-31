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

public class JMSCorrelationIDTest {
	private Queue queue;
	private Session session;

	public JMSCorrelationIDTest() throws JMSException {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
				"vm://localhost");
		Connection connection = factory.createConnection();
		connection.start();

		queue = new ActiveMQQueue("testQueue");
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		setupConsumer("ConsumerA");
		setupConsumer("ConsumerB");
		setupConsumer("ConsumerC");

		setupProducer("ProducerA", "ConsumerA");
		setupProducer("ProducerB", "ConsumerB");
		setupProducer("ProducerC", "ConsumerC");
	}

	private void setupConsumer(final String name) throws JMSException {
		// ����һ�������ߣ���ֻ�����������Լ�����Ϣ
		MessageConsumer consumer = session.createConsumer(queue, "receiver='"
				+ name + "'");
		consumer.setMessageListener(new MessageListener() {
			public void onMessage(Message m) {
				try {
					MessageProducer producer = session.createProducer(queue);
					System.out.println(name + " get:"
							+ ((TextMessage) m).getText());
					// �ظ�һ����Ϣ
					Message replyMessage = session
							.createTextMessage("Reply from " + name);
					// ����JMSCorrelationIDΪ�ղ��յ�����Ϣ��ID
					replyMessage.setJMSCorrelationID(m.getJMSMessageID());
					producer.send(replyMessage);
				} catch (JMSException e) {
				}
			}
		});
	}

	private void setupProducer(final String name, String consumerName)
			throws JMSException {
		MessageProducer producer = session.createProducer(queue);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		// ����һ����Ϣ��������һ������receiver��Ϊ�����ߵ����֡�
		Message message = session.createTextMessage("Message from " + name);
		message.setStringProperty("receiver", consumerName);
		producer.send(message);

		// �ȴ��ظ�����Ϣ
		MessageConsumer replyConsumer = session.createConsumer(queue,
				"JMSCorrelationID='" + message.getJMSMessageID() + "'");
		replyConsumer.setMessageListener(new MessageListener() {
			public void onMessage(Message m) {
				try {
					System.out.println(name + " get reply:"
							+ ((TextMessage) m).getText());
				} catch (JMSException e) {
				}
			}
		});
	}

	public static void main(String[] args) throws Exception {
		new JMSCorrelationIDTest();
	}
}
