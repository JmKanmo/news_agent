package com.service.news_agent.web.service;

import com.service.news_agent.util.NewsApiUtil;
import com.service.news_agent.web.mapper.NewsMapper;
import com.service.news_common.domain.News;
import com.service.news_common.dto.NewsReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsService {
    private final NewsApiUtil newsApiUtil;
    private final NewsMapper newsMapper;

    public void processNewsApi(NewsReq newsReq) {
        try {
            List<News> totalNewsList = new ArrayList<>();
            List<News> newsList = newsApiUtil.requestNewsApi(newsReq);

            if (newsList != null && newsList.isEmpty() == false) {
                totalNewsList.addAll(newsList);

                // 최대 갯수(100)가 넘어갈 경우, page 를 +1 증가 시키고 API 추가 호출
                while (newsList.size() >= 100) {
                    try {
                        Integer increasedPage = Integer.parseInt(newsReq.getPage()) + 1;
                        newsReq.setPage(String.valueOf(increasedPage));
                        newsList = newsApiUtil.requestNewsApi(newsReq);

                        if (newsList != null && newsList.isEmpty() == false) {
                            totalNewsList.addAll(newsList);
                        }
                    } catch (Exception e) {
                        log.error("[NewsService:processNewsApi] error", e);
                    }
                }
                saveNewsData(totalNewsList);
            }
        } catch (Exception e) {
            log.error("[NewsService:processNewsApi] error:", e);
        }
    }

    @Transactional
    public void saveNewsData(List<News> newsList) {
        try {
            if (newsList != null && newsList.isEmpty() == false) {
                newsMapper.insertNewsList(newsList);
            }
        } catch (Exception e) {
            log.error("[NewsService:saveNewsData] error: ", e);
        }
    }
}
