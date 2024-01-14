package com.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Gb32960ReceiverServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Gb32960ReceiverServerApplication.class, args);
        log.info("GB32960 receiver server start success!");
    }
}
