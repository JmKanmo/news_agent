package com.service.news_agent.web.mapper;

import com.service.news_common.domain.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {
    void insertNewsList(List<News> newsList);
}
