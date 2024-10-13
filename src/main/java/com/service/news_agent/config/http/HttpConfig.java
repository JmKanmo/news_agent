package com.service.news_agent.config.http;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "yml")
@Data
public class HttpConfig {
    @Value("${util-config.http_config.connect_time_out}")
    private Integer connectTimeOut;

    @Value("${util-config.http_config.read_time_out}")
    private Integer readTimeOut;

    @Value("${util-config.http_config.write_time_out}")
    private Integer writeTimeOut;
}
