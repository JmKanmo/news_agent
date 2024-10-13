package com.service.news_agent.job;

import com.service.news_agent.config.batch.BatchConfig;
import com.service.news_agent.web.service.NewsService;
import com.service.news_common.dto.NewsReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class NewsBatchScheduler {
    private final BatchConfig batchConfig;
    private final NewsService newsService;

    /**
     * 1 시간 기준 뉴스 데이터 작업 스케쥴링 시작
     * 국가별로 순차적으로 수행
     * ...
     */
    @Scheduled(cron = "#{@batchConfig.batchScheduledNewsCronJob1Hours}")
    public void batchScheduledNewsCronJob1Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            LocalDateTime currentTime = LocalDateTime.now();
            // TODO
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob1Hours] 1hours news batch scheduler done");
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob1Hours] 1hours news batch scheduler error =>", t);
        }
    }

    /**
     * 3 시간 기준 뉴스 데이터 작업 스케쥴링 시작
     * 국가별로 순차적으로 수행
     * ...
     */
    @Scheduled(cron = "#{@batchConfig.batchScheduledNewsCronJob3Hours}")
    public void batchScheduledNewsCronJob3Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            LocalDateTime currentTime = LocalDateTime.now();

            newsService.processNewsApi(NewsReq.builder()
                    .country("us")
                    .fromDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob3Hours] 3hours news batch scheduler done");
            // TODO
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob3Hours] 3hours news batch scheduler error =>", t);
        }
    }

    /**
     * 6 시간 기준 뉴스 데이터 작업 스케쥴링 시작
     * 국가별로 순차적으로 수행
     * ...
     */
    @Scheduled(cron = "#{@batchConfig.batchScheduledNewsCronJob6Hours}")
    public void batchScheduledNewsCronJob6Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            LocalDateTime currentTime = LocalDateTime.now();
            // TODO
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob6Hours] 6hours news batch scheduler done");
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob6Hours] 6hours news batch scheduler error =>", t);
        }
    }

    /**
     * 6 시간 기준 뉴스 데이터 작업 스케쥴링 시작
     * 국가별로 순차적으로 수행
     * ...
     */
    @Scheduled(cron = "#{@batchConfig.batchScheduledNewsCronJob9Hours}")
    public void batchScheduledNewsCronJob9Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            LocalDateTime currentTime = LocalDateTime.now();
            // TODO
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob9Hours] 9hours news batch scheduler done");
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob9Hours] 9hours news batch scheduler error =>", t);
        }
    }

    /**
     * 12 시간 기준 뉴스 데이터 작업 스케쥴링 시작
     * 국가별로 순차적으로 수행
     * ...
     */
    @Scheduled(cron = "#{@batchConfig.batchScheduledNewsCronJob12Hours}")
    public void batchScheduledNewsCronJob12Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            LocalDateTime currentTime = LocalDateTime.now();

            newsService.processNewsApi(NewsReq.builder()
                    .country("kr")
                    .fromDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob12Hours] 12hours news batch scheduler done");
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob12Hours] 12hours news batch scheduler error =>", t);
        }
    }

    /**
     * 15 시간 기준 뉴스 데이터 작업 스케쥴링 시작
     * 국가별로 순차적으로 수행
     * ...
     */
    @Scheduled(cron = "#{@batchConfig.batchScheduledNewsCronJob15Hours}")
    public void batchScheduledNewsCronJob15Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            LocalDateTime currentTime = LocalDateTime.now();
            // TODO
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob15Hours] 15hours news batch scheduler done");
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob15Hours] 15hours news batch scheduler error =>", t);
        }
    }

    /**
     * 18 시간 기준 뉴스 데이터 작업 스케쥴링 시작
     * 국가별로 순차적으로 수행
     * ...
     */
    @Scheduled(cron = "#{@batchConfig.batchScheduledNewsCronJob18Hours}")
    public void batchScheduledNewsCronJob18Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            LocalDateTime currentTime = LocalDateTime.now();
            // TODO
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob18Hours] 18hours news batch scheduler done");
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob18Hours] 18hours news batch scheduler error =>", t);
        }
    }

    /**
     * 21 시간 기준 뉴스 데이터 작업 스케쥴링 시작
     * 국가별로 순차적으로 수행
     * ...
     */
    @Scheduled(cron = "#{@batchConfig.batchScheduledNewsCronJob21Hours}")
    public void batchScheduledNewsCronJob21Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            LocalDateTime currentTime = LocalDateTime.now();
            // TODO
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob21Hours] 21hours news batch scheduler done");
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob21Hours] 21hours news batch scheduler error =>", t);
        }
    }

    /**
     * 24 시간 기준 뉴스 데이터 작업 스케쥴링 시작
     * 국가별로 순차적으로 수행
     * ...
     */
    @Scheduled(cron = "#{@batchConfig.batchScheduledNewsCronJob24Hours}")
    public void batchScheduledNewsCronJob24Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            LocalDateTime currentTime = LocalDateTime.now();
            // TODO
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob24Hours] 24hours news batch scheduler done");
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob24Hours] 24hours news batch scheduler error =>", t);
        }
    }

    // 10초마다 실행되는 스케줄러 (테스트)
    @Scheduled(cron = "*/10 * * * * *")
    public void test() {
        System.out.println("hello world");
    }
}
