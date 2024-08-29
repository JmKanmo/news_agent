package com.service.news_agent.web.service;

import com.service.news_agent.util.NewsApiUtil;
import com.service.news_agent.web.mapper.NewsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsApiUtil newsApiUtil;
    private final NewsMapper newsMapper;

    /**
     * 뉴스 데이터 저장 및 관리 용도 Queue (동시성) 필드 생성 및 관리
     *
     * Queue (동시성) 필드 데이터 DB 저장 메서드 추가
     */
}
