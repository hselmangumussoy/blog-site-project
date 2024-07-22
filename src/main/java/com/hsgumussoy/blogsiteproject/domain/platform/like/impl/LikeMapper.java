package com.hsgumussoy.blogsiteproject.domain.platform.like.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.like.api.LikeDto;

public class LikeMapper {
    public static LikeDto toDto(Like like, UserDto userDto, ArticleDto articleDto) {
        return LikeDto.builder()
                .id(like.getId())
                .user(userDto)
                .article(articleDto)
                .created(like.getCreated())
                .modified(like.getModified())

                .build();
    }

    public static Like toEntity(Like like, LikeDto dto) {
        like.setCount(dto.getCount());
        like.setArticleId(dto.getArticle().getId());
        like.setUserId(dto.getUser().getId());
        return like;
    }
}
