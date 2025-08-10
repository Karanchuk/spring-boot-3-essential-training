package com.karanchuk.roomclr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class RoomClrApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomClrApplication.class, args);
    }

    private static final String QUEUE_NAME = "room-cleaner";
    private static final String EXCHANGE_NAME = "operations";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("landon.#");
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate, RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        return args -> {
//            int size = (args.length > 0 && args[0].matches("\\d+"))
//                    ? Integer.parseInt(args[0])
//                    : 100;
//
//            for (int i = 1; i <= size; i++) {
//                String result = "";
//                result += i % 3 == 0 ? "Fizz" : "";
//                result += i % 5 == 0 ? "Buzz" : "";
//                System.out.println(result.isBlank() ? i : result);
//            }
            ResponseEntity<List<Room>> rooms = restTemplate.exchange("http://www.localhost:8080/api/rooms",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Room>>() {});
            rooms.getBody().forEach(r -> {
                AsyncPayload payload = new AsyncPayload();
                payload.setId(r.getId());
                payload.setModel("ROOM");
                try {
                    rabbitTemplate.convertAndSend(EXCHANGE_NAME, "landon.rooms.cleaner", objectMapper.writeValueAsString(payload));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });

        };
    }

}
