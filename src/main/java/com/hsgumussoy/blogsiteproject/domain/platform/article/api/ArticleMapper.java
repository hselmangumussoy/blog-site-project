package com.hsgumussoy.blogsiteproject.domain.platform.article.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.web.ArticleRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.article.web.ArticleResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class ArticleMapper {
    private ArticleMapper() {
    }

    public static ArticleResponse toResponse(ArticleDto dto) {
        return ArticleResponse.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .modified(dto.getModified())
                .created(dto.getCreated())
                .id(dto.getId())
                .likeCount(dto.getLikeCount())
                .user(dto.getUser())
                .build();
    }

    public static ArticleDto toDto(ArticleRequest request) {
        return ArticleDto.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(UserDto.builder().id(request.getUserId()).build())
                .categoryId(request.getCategoryId())
                .build();
    }

    public static Page<ArticleResponse> toPageResponse(Page<ArticleDto> articleDtos) {
        return PageUtil.pageToDto(articleDtos, ArticleMapper::toResponse);
    }
}
