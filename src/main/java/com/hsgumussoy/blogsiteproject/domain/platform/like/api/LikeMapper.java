package com.hsgumussoy.blogsiteproject.domain.platform.like.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.like.web.LikeRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.like.web.LikeResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class LikeMapper {
    public static LikeDto toDto(LikeRequest request) {
        return LikeDto.builder()
                .article(ArticleDto.builder().id(request.getArticleId()).build())
                .user(UserDto.builder().id(request.getArticleId()).build())
                .build();
    }

    public static LikeResponse toResponse(LikeDto dto) {
        return LikeResponse.builder()
                .article(dto.getArticle())
                .user(dto.getUser())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .id(dto.getId())
                .count(dto.getCount())
                .build();
    }

    public static Page<LikeResponse> toPageResponse(Page<LikeDto> dtos) {
        return PageUtil.pageToDto(dtos, LikeMapper::toResponse);
    }
}
