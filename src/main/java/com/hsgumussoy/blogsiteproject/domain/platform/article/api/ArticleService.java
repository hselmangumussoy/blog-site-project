package com.hsgumussoy.blogsiteproject.domain.platform.article.api;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    ArticleDto save(ArticleDto dto);

    ArticleDto getById(String id);

    void delete(String id);

    ArticleDto update(String id, ArticleDto dto);

    List<ArticleDto> getAll(ArticleDto dto);
}
