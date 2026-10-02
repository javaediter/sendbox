/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.editer.kafka.publisher.controllers;

import ec.editer.kafka.publisher.dtos.Letter;
import ec.editer.kafka.publisher.services.EventPublisher;
import ec.editer.kafka.publisher.services.SubcriberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edison Teran
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/pub")
@CrossOrigin("http://localhost:4200")
public class PublisherController {
    
    final private EventPublisher pub;    
    final private SubcriberService sub;
    
    @PostMapping("/send")
    public ResponseEntity<?> publish(@RequestBody Letter letter){
        log.info("----- sending message -----");
        pub.publish(letter);
        return ResponseEntity.ok(true);
    }
    
    @GetMapping("/authors")
    public ResponseEntity authors(){
        log.info("----- calling authors -----");
        String[] authors = sub.getAuthors();
        return ResponseEntity.ok(authors);
    }
}
