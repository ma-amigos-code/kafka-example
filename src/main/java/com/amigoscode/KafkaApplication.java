package com.amigoscode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			//kafkaTemplate.send("amigoscode", "hello kafka :)");
			for (int i = 0; i < 10; i++) {
				kafkaTemplate.send("amigoscode", "hello kafka :) " + i);
			}
		};
	}*/

	@Bean
	CommandLineRunner commandLineRunnerMessage(KafkaTemplate<String, Message> kafkaTemplate) {
		return args -> {
			for (int i = 0; i < 1; i++) {
				kafkaTemplate.send(
						"amigoscodeMessage",
						 new Message(
								"Hello Kafka ",
								LocalDateTime.now()
						)
				);
			}
		};
	}

}
