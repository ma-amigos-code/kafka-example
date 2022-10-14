package com.amigoscode;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    //private KafkaTemplate<String, String> kafkaTemplate;
    private KafkaTemplate<String, Message> kafkaTemplateMessage;

    public MessageController(/*KafkaTemplate<String, String> kafkaTemplate,*/
                             KafkaTemplate<String, Message> kafkaTemplateMessage) {
        //this.kafkaTemplate = kafkaTemplate;
        this.kafkaTemplateMessage = kafkaTemplateMessage;
    }

    /*@PostMapping
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("amigoscode", request.message());
    }*/

    @PostMapping
    public void publishMessage(@RequestBody MessageRequest request) {
        Message message = new Message(request.message(), LocalDateTime.now());
        kafkaTemplateMessage.send("amigoscodeMessage", message);
    }

}
