package com.example.testtask.repository;

import com.example.testtask.entity.NewsItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<NewsItem, Long> {
    List<NewsItem> findAllByOrderByIdAsc();

    NewsItem findByLinkNews(String linkNews);

    List<NewsItem> findByHeaderNewsContaining(String aWord);
}
