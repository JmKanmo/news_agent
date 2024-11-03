package com.service.news_agent;

import com.service.news_common.dto.NewsReq;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class BatchTest {
    @Test
    public void batchTest() {
        Long hours = Long.parseLong("10800000");
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime beforeTime = currentTime.minus(Duration.ofMillis(hours));

        System.out.println(String.format("현재 시간: %s, 이전 시간: %s", currentTime, beforeTime));

        NewsReq newsReq = NewsReq.builder()
                .country("en")
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
                .build();
    }
}
