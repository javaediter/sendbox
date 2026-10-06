/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.editer.kafka.subscriber.services;

import ec.editer.kafka.subscriber.dtos.Envelope;
import ec.editer.kafka.subscriber.dtos.Letter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edison Teran
 */
@Slf4j
@Service
public class FileService {
    
    @Value("${path.dir.files}")
    private String dirPath;
    
    public void writeMessage(Letter letter){
        log.info(".....writing message from {}", letter.getAuthor());
        long id = Calendar.getInstance().getTimeInMillis();
        
        // Here it'll create the dir root if not exists
        File root = new File(dirPath);
        if(!root.exists()){
            root.mkdir();
        }
        
        // Here it'll create the author's directory if not exists
        File dirAuthor = new File(root, letter.getAuthor());
        if(!dirAuthor.exists()){
            dirAuthor.mkdir();
        }
        
        File file = new File(dirAuthor, "" + id + ".txt");
        
        try(var writer = new BufferedWriter(new FileWriter(file))){
            writer.write(String.format("Date: %s", letter.getDate()));
            writer.newLine();
            writer.write(String.format("City: %s", letter.getCity()));
            writer.newLine();
            writer.write(String.format("Author: %s", letter.getAuthor()));
            writer.newLine();
            writer.write("Message: ");
            writer.newLine();
            writer.write(letter.getMessage());            
        }catch(IOException ex){
            log.error("ERROR: {}", ex.getMessage());
            log.error("FULL ERROR: {}", ex);
        }
    }
    
    public String[] getAuthors(){
        log.info("----- get Authors -----");
        
        // Here it'll create the dir root if not exists
        File root = new File(dirPath);
        if(!root.exists()){
            root.mkdir();
        }
        
        return root.list();
    }
    
    public List<Envelope> getFilesByAuthor(String author){
        log.info("----- get files by author {} -----", author);
        
        File dirAuthor = new File(dirPath + "/" + author);
        if(!dirAuthor.exists()){
            dirAuthor.mkdir();
        }
        
        List<Envelope> envelopes = Arrays.asList(dirAuthor.listFiles())
                .stream()
                .map((file) -> new Envelope(file.getName(), file.getAbsolutePath()))
                .toList();
        
        return envelopes;
    }
    
    public String getContentFile(String author, String fileName){
        log.info("----- getContentFile -----");
        String fullPath = dirPath + "/" + author + "/" + fileName;
        File file = new File(fullPath);
        String content = null;
        try {
            content = Files.readString(file.toPath());
        }catch(IOException ex){
            log.error("ERROR: ", ex.getMessage());
        }
        return content;
    }
    
}
