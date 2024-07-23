package com.hsgumussoy.blogsiteproject.domain.platform.article.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto dto);

    ArticleDto getById(String id);

    void delete(String id);

    ArticleDto update(String id, ArticleDto dto);

    Page<ArticleDto> getAll(Pageable pageable);

    List<ArticleDto> getByIds(List<String> articleIds);
}
