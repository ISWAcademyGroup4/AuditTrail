package com.interswitch.audittrail.audit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interswitch.audittrail.domain.AuditTrail;
import com.interswitch.audittrail.domain.CustomMessage;
import com.interswitch.audittrail.dao.AuditRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    AuditRepository auditRepository;
//
//    @RabbitListener(queues = "${jsa.rabbitmq.queue}")
//    public void receivedMessage(String msg) {
//        AuditTrail auditTrail = new AuditTrail();
//        auditTrail.setAuditlog(msg);
//        auditRepository.insert(auditTrail);
//        System.out.println("Received Message: " + msg);
//    }

    @RabbitListener(queues = "${jsa.rabbitmq.queue}")
    public void receivedMessage(CustomMessage msg) {
        AuditTrail auditTrail = new AuditTrail();
        auditTrail.setDescription(msg.getDescription());
        auditTrail.setEvent(msg.getEvent());
        auditTrail.setRole(msg.getRole());
        auditTrail.setEventdate(msg.getEventdate());
        auditRepository.insert(auditTrail);
        System.out.println("Received Message: " + msg);
    }

}
