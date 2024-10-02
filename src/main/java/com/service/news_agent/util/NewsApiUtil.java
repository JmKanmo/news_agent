package com.service.news_agent.util;

import com.service.news_agent.config.app.NewsApiConfig;
import com.service.news_common.domain.News;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

@Component
@RequiredArgsConstructor
@Slf4j
public class NewsApiUtil {
    private final NewsApiConfig newsApiConfig;
    private final ConcurrentLinkedQueue<News> queue = new ConcurrentLinkedQueue<>();


    /**
     * 요청 인자 DTO 생성 (date, language, category, ... etc) - news-common
     * 응답 값 Jackson 이용해 변환 및 Domain 생성, DB 저장  - news-common
     * DB 저장 Domain 조회 및 변환 용도의 DTO 생성  - news-common
     */

    public String requestNewsApi() {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://newsomaticapi.p.rapidapi.com/top?from=2024-08-15&to=2024-08-16&language=kr&country=kr&sortBy=relevancy")
                    .get()
                    .addHeader("x-rapidapi-key", newsApiConfig.getApiKey())
                    .addHeader("x-rapidapi-host", newsApiConfig.getApiHost())
                    .build();
            Response response = client.newCall(request).execute();
            String bodyStr = response.body().string();

            // TODO
        } catch (Exception e) {
            log.error("[NewsApiUtil:requestNewsApi] error:", e);
        }
        return null;
    }
}
