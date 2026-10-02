/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.editer.kafka.subscriber.controllers;

import ec.editer.kafka.subscriber.services.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edison Teran
 */
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("api/sub")
@CrossOrigin("http://localhost:4200")
public class SubcriberController {
    
    final private FileService fileService;
    
    @GetMapping("/authors")
    public ResponseEntity getAllAuthors(){
        log.info("----- getAllAuthors -----");
        return ResponseEntity.ok(fileService.getAuthors());
    }
}
