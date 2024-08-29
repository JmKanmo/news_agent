package com.service.news_agent.config.batch;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "yml")
@Data
public class BatchConfig {
    @Value("${util-config.scheduling.3_hours.batch_scheduled_news_cron_job}")
    private String batchScheduledNewsCronJob3Hours; // 3시간 주기 배치 스케쥴링

    @Value("${util-config.scheduling.6_hours.batch_scheduled_news_cron_job}")
    private String batchScheduledNewsCronJob6Hours; // 6시간 주기 배치 스케쥴링

    @Value("${util-config.batch_config.old_news_clean_period}")
    private Long oldNewsCleanPeriod;
}
