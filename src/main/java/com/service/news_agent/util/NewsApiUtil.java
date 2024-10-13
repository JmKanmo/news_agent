package com.service.news_agent.util;

import com.service.news_agent.config.app.NewsApiConfig;
import com.service.news_agent.config.http.HttpConfig;
import com.service.news_common.domain.News;
import com.service.news_common.dto.NewsReq;
import com.service.news_common.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class NewsApiUtil {
    private final NewsApiConfig newsApiConfig;
    private final HttpConfig httpConfig;

    public List<News> requestNewsApi(NewsReq newsReq) {
        try {
            // HTTP 로그를 출력하는 인터셉터 추가
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .connectTimeout(httpConfig.getConnectTimeOut(), TimeUnit.SECONDS)
                    .readTimeout(httpConfig.getReadTimeOut(), TimeUnit.SECONDS)
                    .writeTimeout(httpConfig.getWriteTimeOut(), TimeUnit.SECONDS)
                    .build();

            Request request = new Request.Builder()
                    .url(newsApiConfig.getApiUrl() + newsReq.queryString())
                    .get()
                    .addHeader("x-rapidapi-key", newsApiConfig.getApiKey())
                    .addHeader("x-rapidapi-host", newsApiConfig.getApiHost())
                    .build();
            Response response = client.newCall(request).execute();
            String bodyStr = response.body().string();

            Map<String, Object> map = JsonUtil.readClzValue(bodyStr, Map.class);

            if (map != null) {
                Object articles = map.get("articles");

                if (articles != null && articles instanceof List<?>) {
                    List<Object> articleList = (List<Object>) articles;

                    if (articleList != null && articleList.isEmpty() == false) {
                        String articleListJsonStr = JsonUtil.writeValueAsString(articleList);
                        List<News> newsList = JsonUtil.readListValue(articleListJsonStr, News.class);
                        return newsList;
                    }
                }
            }
        } catch (Exception e) {
            log.error("[NewsApiUtil:requestNewsApi] error:", e);
        }
        return null;
    }
}
