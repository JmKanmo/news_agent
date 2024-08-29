package com.service.news_agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NewsAgentApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewsAgentApplication.class, args);
    }
}
