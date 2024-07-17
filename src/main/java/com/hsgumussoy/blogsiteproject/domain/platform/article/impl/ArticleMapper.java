package com.hsgumussoy.blogsiteproject.domain.platform.article.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;

public class ArticleMapper {
    public static ArticleDto toDto(Article article, UserDto userDto, CategoryDto categoryDto) {
        return ArticleDto.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .id(article.getId())
                .modified(article.getModified())
                .created(article.getCreated())
                .user(userDto)
                .category(categoryDto)
                .build();
    }

    public static Article toEntity(Article article, ArticleDto dto) {
        article.setCategoryId(dto.getCategory().getId());
        article.setUserId(dto.getUser().getId());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        return article;
    }
}
