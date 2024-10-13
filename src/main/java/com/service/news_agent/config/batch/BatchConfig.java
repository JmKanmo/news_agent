package com.service.news_agent.config.batch;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "yml")
@Data
public class BatchConfig {
    @Value("${util-config.scheduling.1_hours.batch_scheduled_news_cron_job}")
    private String batchScheduledNewsCronJob1Hours; // 1시간 주기 배치 스케쥴링

    @Value("${util-config.scheduling.3_hours.batch_scheduled_news_cron_job}")
    private String batchScheduledNewsCronJob3Hours; // 3시간 주기 배치 스케쥴링

    @Value("${util-config.scheduling.6_hours.batch_scheduled_news_cron_job}")
    private String batchScheduledNewsCronJob6Hours; // 6시간 주기 배치 스케쥴링

    @Value("${util-config.scheduling.9_hours.batch_scheduled_news_cron_job}")
    private String batchScheduledNewsCronJob9Hours; // 9시간 주기 배치 스케쥴링

    @Value("${util-config.scheduling.12_hours.batch_scheduled_news_cron_job}")
    private String batchScheduledNewsCronJob12Hours; // 12시간 주기 배치 스케쥴링

    @Value("${util-config.scheduling.15_hours.batch_scheduled_news_cron_job}")
    private String batchScheduledNewsCronJob15Hours; // 15시간 주기 배치 스케쥴링

    @Value("${util-config.scheduling.18_hours.batch_scheduled_news_cron_job}")
    private String batchScheduledNewsCronJob18Hours; // 18시간 주기 배치 스케쥴링

    @Value("${util-config.scheduling.21_hours.batch_scheduled_news_cron_job}")
    private String batchScheduledNewsCronJob21Hours; // 21시간 주기 배치 스케쥴링

    @Value("${util-config.scheduling.24_hours.batch_scheduled_news_cron_job}")
    private String batchScheduledNewsCronJob24Hours; // 24시간 주기 배치 스케쥴링

    @Value("${util-config.batch_config.old_news_clean_period}")
    private Long oldNewsCleanPeriod;
}
