package com.service.news_agent.job;

import com.service.news_agent.config.batch.BatchConfig;
import com.service.news_agent.web.service.NewsService;
import com.service.news_common.dto.NewsReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
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
    @Scheduled(fixedDelayString = "#{@batchConfig.batchScheduledNewsCronJob1Hours}")
    public void batchScheduledNewsCronJob1Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            Long batchScheduledNewsCronJob1Hours = Long.parseLong(batchConfig.getBatchScheduledNewsCronJob1Hours());
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime beforeTime = currentTime.minus(Duration.ofMillis(batchScheduledNewsCronJob1Hours));

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
    @Scheduled(fixedDelayString = "#{@batchConfig.batchScheduledNewsCronJob3Hours}")
    public void batchScheduledNewsCronJob3Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            Long batchScheduledNewsCronJob3Hours = Long.parseLong(batchConfig.getBatchScheduledNewsCronJob3Hours());
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime beforeTime = currentTime.minus(Duration.ofMillis(batchScheduledNewsCronJob3Hours));

            // 미국
            newsService.processNewsApi(NewsReq.builder()
                    .country("us")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 호주
            newsService.processNewsApi(NewsReq.builder()
                    .country("at")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 영국
            newsService.processNewsApi(NewsReq.builder()
                    .country("uk")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 러시아
            newsService.processNewsApi(NewsReq.builder()
                    .country("ru")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 중국
            newsService.processNewsApi(NewsReq.builder()
                    .country("zh")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 일본
            newsService.processNewsApi(NewsReq.builder()
                    .country("jp")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 인도
            newsService.processNewsApi(NewsReq.builder()
                    .country("in")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
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
    @Scheduled(fixedDelayString = "#{@batchConfig.batchScheduledNewsCronJob6Hours}")
    public void batchScheduledNewsCronJob6Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            Long batchScheduledNewsCronJob6Hours = Long.parseLong(batchConfig.getBatchScheduledNewsCronJob6Hours());
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime beforeTime = currentTime.minus(Duration.ofMillis(batchScheduledNewsCronJob6Hours));

            // 프랑스
            newsService.processNewsApi(NewsReq.builder()
                    .country("fr")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 독일
            newsService.processNewsApi(NewsReq.builder()
                    .country("de")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 네덜란드
            newsService.processNewsApi(NewsReq.builder()
                    .country("NL")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 그리스
            newsService.processNewsApi(NewsReq.builder()
                    .country("gr")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 스위스
            newsService.processNewsApi(NewsReq.builder()
                    .country("ch")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 스페인
            newsService.processNewsApi(NewsReq.builder()
                    .country("es")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 이탈리아
            newsService.processNewsApi(NewsReq.builder()
                    .country("it")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 터키
            newsService.processNewsApi(NewsReq.builder()
                    .country("tr")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 우크라니아
            newsService.processNewsApi(NewsReq.builder()
                    .country("ua")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 포르투갈
            newsService.processNewsApi(NewsReq.builder()
                    .country("pt")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob6Hours] 6hours news batch scheduler done");
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob6Hours] 6hours news batch scheduler error =>", t);
        }
    }

    /**
     * 9 시간 기준 뉴스 데이터 작업 스케쥴링 시작
     * 국가별로 순차적으로 수행
     * ...
     */
    @Scheduled(fixedDelayString = "#{@batchConfig.batchScheduledNewsCronJob9Hours}")
    public void batchScheduledNewsCronJob9Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            Long batchScheduledNewsCronJob9Hours = Long.parseLong(batchConfig.getBatchScheduledNewsCronJob9Hours());
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime beforeTime = currentTime.minus(Duration.ofMillis(batchScheduledNewsCronJob9Hours));

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
    @Scheduled(fixedDelayString = "#{@batchConfig.batchScheduledNewsCronJob12Hours}")
    public void batchScheduledNewsCronJob12Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            Long batchScheduledNewsCronJob12Hours = Long.parseLong(batchConfig.getBatchScheduledNewsCronJob12Hours());
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime beforeTime = currentTime.minus(Duration.ofMillis(batchScheduledNewsCronJob12Hours));

            // 한국
            newsService.processNewsApi(NewsReq.builder()
                    .country("kr")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 필리핀
            newsService.processNewsApi(NewsReq.builder()
                    .country("ph")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 대만
            newsService.processNewsApi(NewsReq.builder()
                    .country("tw")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 홍콩
            newsService.processNewsApi(NewsReq.builder()
                    .country("hk")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 태국
            newsService.processNewsApi(NewsReq.builder()
                    .country("th")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
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
    @Scheduled(fixedDelayString = "#{@batchConfig.batchScheduledNewsCronJob15Hours}")
    public void batchScheduledNewsCronJob15Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            Long batchScheduledNewsCronJob15Hours = Long.parseLong(batchConfig.getBatchScheduledNewsCronJob15Hours());
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime beforeTime = currentTime.minus(Duration.ofMillis(batchScheduledNewsCronJob15Hours));

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
    @Scheduled(fixedDelayString = "#{@batchConfig.batchScheduledNewsCronJob18Hours}")
    public void batchScheduledNewsCronJob18Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            Long batchScheduledNewsCronJob18Hours = Long.parseLong(batchConfig.getBatchScheduledNewsCronJob18Hours());
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime beforeTime = currentTime.minus(Duration.ofMillis(batchScheduledNewsCronJob18Hours));

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
    @Scheduled(fixedDelayString = "#{@batchConfig.batchScheduledNewsCronJob21Hours}")
    public void batchScheduledNewsCronJob21Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            Long batchScheduledNewsCronJob21Hours = Long.parseLong(batchConfig.getBatchScheduledNewsCronJob21Hours());
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime beforeTime = currentTime.minus(Duration.ofMillis(batchScheduledNewsCronJob21Hours));

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
    @Scheduled(fixedDelayString = "#{@batchConfig.batchScheduledNewsCronJob24Hours}")
    public void batchScheduledNewsCronJob24Hours() {
        try {
            // 배치 작업 실행 시간을 LocalDateTime으로 가져오기
            Long batchScheduledNewsCronJob24Hours = Long.parseLong(batchConfig.getBatchScheduledNewsCronJob24Hours());
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime beforeTime = currentTime.minus(Duration.ofMillis(batchScheduledNewsCronJob24Hours));

            // 뉴질랜드
            newsService.processNewsApi(NewsReq.builder()
                    .country("nz")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 아르헨티나
            newsService.processNewsApi(NewsReq.builder()
                    .country("at")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 멕시코
            newsService.processNewsApi(NewsReq.builder()
                    .country("mx")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 이집트
            newsService.processNewsApi(NewsReq.builder()
                    .country("eg")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());

            // 사우디
            newsService.processNewsApi(NewsReq.builder()
                    .country("sa")
                    .fromDate(LocalDateTime.of(
                            beforeTime.getYear(),
                            beforeTime.getMonth(),
                            beforeTime.getDayOfMonth(),
                            beforeTime.getHour(),
                            beforeTime.getMinute(),
                            beforeTime.getSecond()))
                    .toDate(LocalDateTime.of(
                            currentTime.getYear(),
                            currentTime.getMonth(),
                            currentTime.getDayOfMonth(),
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond()))
                    .build());
            log.info("[NewsBatchScheduler:batchScheduledNewsCronJob24Hours] 24hours news batch scheduler done");
        } catch (Throwable t) {
            log.error("[NewsBatchScheduler:batchScheduledNewsCronJob24Hours] 24hours news batch scheduler error =>", t);
        }
    }

    // 10초마다 실행되는 스케줄러 (테스트용)
    // @Scheduled(cron = "*/10 * * * * *")
    public void test() {
        System.out.println("hello world");
    }
}
