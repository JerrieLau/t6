package com.yxtec.t6.repository;

import com.google.gson.Gson;
import com.yxtec.t6.model.Score;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.ProducerCallback;
import org.springframework.stereotype.Repository;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

/**
 * Created by jerrie on 17-5-22.
 */
@Repository
public class JmsRepository {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ActiveMQQueue queue;

    @Autowired
    private Gson gson;

    public void sendScoreMessage(final Score score) {
        jmsTemplate.execute(new ProducerCallback<Object>() {
            public Object doInJms(Session session, MessageProducer messageProducer) throws JMSException {
                ActiveMQTextMessage message = new ActiveMQTextMessage();
                message.setText(gson.toJson(score));
                messageProducer.send(queue, message);
                return null;
            }
        });
    }

}
