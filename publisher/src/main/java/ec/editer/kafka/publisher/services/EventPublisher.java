/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.editer.kafka.publisher.services;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edison Teran
 */
@AllArgsConstructor
@Service
public class EventPublisher {
    
    private final KafkaTemplate<String, Object> kafkaTemplate;
    
    public void publish(Object payload){
        this.kafkaTemplate.send("my-topic", payload);
    }
}
