package com.amigoscode;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    /*@KafkaListener(
            topics = "amigoscode",
            groupId = "groupId"
    )
    void listener(String data) {
        System.out.println("Listener received (String): " + data + " :D");
    }*/

    @KafkaListener(
            topics = "amigoscodeMessage",
            groupId = "groupIdMessage",
            containerFactory = "factoryMessage"
    )
    void listenerMessage( Message data) {
        System.out.println("Listener received (Message): " + data + " :D");
    }

}
