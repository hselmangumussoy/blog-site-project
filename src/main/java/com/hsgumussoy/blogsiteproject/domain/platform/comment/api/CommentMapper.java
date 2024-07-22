package com.hsgumussoy.blogsiteproject.domain.platform.comment.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.comment.web.CommentRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.comment.web.CommentResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class CommentMapper {
    public CommentMapper() {
    }

    public static CommentResponse toResponse(CommentDto dto) {
        return CommentResponse.builder()
                .id(dto.getId())
                .article(dto.getArticle())
                .user(dto.getUser())
                .content(dto.getContent())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .build();
    }
    public static CommentDto toDto(CommentRequest request) {
        return CommentDto.builder()
                .article(ArticleDto.builder().id(request.getArticleId()).build())
                .user(UserDto.builder().id(request.getArticleId()).build())
                .content(request.getContent())
                .build();
    }

    public static Page<CommentResponse> toPageResponse(Page<CommentDto> dtos) {
        return PageUtil.pageToDto(dtos, CommentMapper::toResponse);
    }
}
