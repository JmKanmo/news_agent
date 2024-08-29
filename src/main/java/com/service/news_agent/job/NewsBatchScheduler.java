package com.service.news_agent.job;

import com.service.news_agent.config.batch.BatchConfig;
import com.service.news_agent.web.service.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NewsBatchScheduler {
    private final BatchConfig batchConfig;
    private final NewsService newsService;

    /**
     * 3 시간 기준 뉴스 데이터 작업 스케쥴링 시작
     * 국가별로 순차적으로 수행
     * US(미국)
     * ...
     */
    @Scheduled(cron = "#{@batchConfig.batchScheduledNewsCronJob3Hours}")
    public void batchScheduledNewsCronJob3Hours() {
        try {
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob3Hours] 3hours news batch scheduler done");
            // TODO
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob3Hours] 3hours scheduler error =>", t);
        }
    }

    /**
     * 6 시간 기준 뉴스 데이터 작업 스케쥴링 시작
     * 국가별로 순차적으로 수행
     * kR(한국)
     * ...
     */
    @Scheduled(cron = "#{@batchConfig.batchScheduledNewsCronJob6Hours}")
    public void batchScheduledNewsCronJob6Hours() {
        try {
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob6Hours] 6hours news batch scheduler done");
            // TODO
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob6Hours] 6hours scheduler error =>", t);
        }
    }

    // TODO 필요시에 추가
}
