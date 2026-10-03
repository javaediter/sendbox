/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.editer.kafka.publisher.services;

import ec.editer.kafka.publisher.dtos.Envelope;
import ec.editer.kafka.publisher.dtos.Letter;
import java.util.List;
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
    
    public List<Envelope> getFilesByAuthor(String author){
        return restClient
                .get()
                .uri("/files?author=" + author)
                .retrieve()
                .body(List.class);
    }
    
    public Letter getContentFile(String author, String fileName){
        return restClient
                .get()
                .uri("/read?author=" + author + "&fileName=" + fileName)
                .retrieve()
                .body(Letter.class);
    }
}
