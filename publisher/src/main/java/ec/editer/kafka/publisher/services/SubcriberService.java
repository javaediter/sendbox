/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.editer.kafka.publisher.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

/**
 *
 * @author Edison Teran
 */
@AllArgsConstructor
@Slf4j
@Service
public class SubcriberService {
    
    final private RestClient restClient;
    
    public String[] getAuthors(){
        return restClient
                .get()
                .uri("/authors")
                .retrieve()
                .body(String[].class);
    }
}
