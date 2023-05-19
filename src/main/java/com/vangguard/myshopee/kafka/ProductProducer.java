package com.vangguard.myshopee.kafka;

import com.vangguard.myshopee.models.ProductEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {
private  static final Logger LOGGER=LoggerFactory.getLogger(ProductProducer.class);
   private NewTopic topic;
   private KafkaTemplate<String, ProductEvent> kafkaTemplate;

    public ProductProducer(NewTopic topic, KafkaTemplate<String, ProductEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }


    public  void produceevent(ProductEvent productEvent)
    {

        Message<ProductEvent>eventMessage= MessageBuilder.withPayload(productEvent).setHeader(KafkaHeaders.TOPIC,topic.name()).build();
    kafkaTemplate.send(eventMessage);
        LOGGER.info(String.format(" event publish from product to topic%s",eventMessage));
    }
}
