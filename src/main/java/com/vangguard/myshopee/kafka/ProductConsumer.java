package com.vangguard.myshopee.kafka;

import com.vangguard.myshopee.models.ProductEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductConsumer {
    private  static final Logger LOGGER= LoggerFactory.getLogger(ProductProducer.class);

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}",topics = "${spring.kafka.topic.name}")
    public void consume(ProductEvent productEvent)
    {
        LOGGER.info(String.format(" consume data is %s",productEvent));

    }
}
