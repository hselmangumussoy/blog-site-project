package com.hsgumussoy.blogsiteproject.domain.platform.article.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;

public class ArticleMapper {
    public ArticleMapper() {
    }

    public static ArticleDto toDto(Article article, UserDto user) {
        return ArticleDto.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .id(article.getId())
                .modified(article.getModified())
                .created(article.getCreated())
                .likeCount(article.getLikeCount())
                .user(user)
                .build();
    }

    /*public  static ArticleDto toDto(Article article, List<UserDto> userDtoList, List<CategoryDto> categoryDtoList){
        UserDto user = StringUtils.hasLength(article.getUserId()) ?
                userDtoList.stream()
                        .filter(c -> c.getId().equals(article.getUserId()))
                        .findFirst()
                        .orElseThrow()
                : null;

        CategoryDto category =  StringUtils.hasLength(article.getCategoryId()) ?
                categoryDtoList.stream()
                        .filter(c-> c.getId().equals(article.getCategoryId()))
                        .findFirst()
                        .orElseThrow()
                :null;

        return ArticleDto.builder()
                .id(article.getId())
                .likeCount(article.getLikeCount())
                .category(category)
                .content(article.getContent())
                .created(article.getCreated())
                .modified(article.getModified())
                .title(article.getTitle())
                .user(user)
                .build();
    }*/
    public static Article toEntity(Article article, ArticleDto dto) {
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setLikeCount(dto.getLikeCount());
        article.setUserId(dto.getUser().getId());
        article.setStatus((dto.getStatus()));
        return article;
    }
}
