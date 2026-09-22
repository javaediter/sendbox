/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.editer.kafka.publisher.controllers;

import ec.editer.kafka.publisher.dtos.Letter;
import ec.editer.kafka.publisher.services.EventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edison Teran
 */
@AllArgsConstructor
@RestController
@RequestMapping("api/pub")
public class PublisherController {
    
    private final EventPublisher publisher;    
    
    @PostMapping("/send")
    public ResponseEntity<?> publish(@RequestBody Letter letter){
        publisher.publish(letter);
        return ResponseEntity.ok(true);
    }
}
