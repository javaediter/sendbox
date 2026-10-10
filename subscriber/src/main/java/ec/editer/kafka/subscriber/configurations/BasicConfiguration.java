/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.editer.kafka.subscriber.configurations;

import ec.editer.kafka.subscriber.dtos.Letter;
import ec.editer.kafka.subscriber.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.kafka.dsl.Kafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConsumerProperties;

/**
 *
 * @author Edison Teran
 */
@Configuration
public class BasicConfiguration {
    
    private final FileService fileService;
    
    public BasicConfiguration(FileService fileService){
        this.fileService = fileService;
    }
    
    @Value("${spring.kafka.template.default-topic}")
    private String topicName;
    
    @Value("${spring.kafka.template.default-group}")
    private String groupName;
    
    //inboundChannelAdapter es para procesar los mensajes que ingresan a kafka
    @Bean
    public IntegrationFlow flow(ConsumerFactory<String, Letter> cf){
        ConsumerProperties conprops = new ConsumerProperties(topicName);
        conprops.setGroupId(groupName);
        return IntegrationFlow
                .from(Kafka.inboundChannelAdapter(cf, conprops))
                .handle(e -> fileService.writeMessage((Letter)e.getPayload()))
                .get();
    }
}
