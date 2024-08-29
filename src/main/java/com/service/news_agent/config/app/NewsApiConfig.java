package com.service.news_agent.config.app;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "yml")
@Data
public class NewsApiConfig {
    @Value("${util-config.news_api.api_url}")
    private String apiUrl;

    @Value("${util-config.news_api.api_key}")
    private String apiKey; // api key

    @Value("${util-config.news_api.api_host}")
    private String apiHost; // api host
}
