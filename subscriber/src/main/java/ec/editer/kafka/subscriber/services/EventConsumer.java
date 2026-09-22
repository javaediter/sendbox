/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.editer.kafka.subscriber.services;

import ec.editer.kafka.subscriber.dtos.Letter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author Edison Teran
 */
@Slf4j
@Component
public class EventConsumer {
    
    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(ConsumerRecord<String, Letter> record){
        Letter letter = record.value();
        log.info(">>>>> From topic {}", record.topic()); 
        log.info(">>>>> Messaged received {}", letter.getMessage());
    }
}
