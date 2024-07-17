package com.hsgumussoy.blogsiteproject.domain.platform.article.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.web.ArticleRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.article.web.ArticleResponse;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleMapper {
    public ArticleResponse toResponse(ArticleDto dto) {
        return ArticleResponse.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .modified(dto.getModified())
                .created(dto.getCreated())
                .id(dto.getId())
                .category(dto.getCategory())
                .user(dto.getUser())
                .build();
    }

    public ArticleDto toDto(ArticleRequest request) {
        return ArticleDto.builder()
                .category(CategoryDto.builder().id((request.getCategoryId())).build())
                .title(request.getTitle())
                .content(request.getContent())
                .user(UserDto.builder().id(request.getUserId()).build())
                .build();
    }

    public List<ArticleResponse> toResponses(List<ArticleDto> articleDtoList) {
        return articleDtoList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
