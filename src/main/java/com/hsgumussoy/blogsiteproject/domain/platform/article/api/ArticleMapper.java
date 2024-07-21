package com.hsgumussoy.blogsiteproject.domain.platform.article.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.web.ArticleRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.article.web.ArticleResponse;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;
import com.hsgumussoy.blogsiteproject.library.rest.MetaResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

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
                .category(dto.getCategory())
                .user(dto.getUser())
                .build();
    }

    public static ArticleDto toDto(ArticleRequest request) {
        return ArticleDto.builder()
                .category(CategoryDto.builder().id((request.getCategoryId())).build())
                .title(request.getTitle())
                .content(request.getContent())
                .user(UserDto.builder().id(request.getUserId()).build())
                .build();
    }

    public static List<ArticleResponse> toResponses(List<ArticleDto> articleDtoList) {
        List<ArticleResponse> list = new ArrayList<>();
        for (ArticleDto articleDto : articleDtoList) {
            ArticleResponse response = toResponse(articleDto);
            list.add(response);
        }
        return list;
    }


    public static Page<ArticleResponse> toPageResponse(Page<ArticleDto> articleDtos) {
        return PageUtil.pageToDto(articleDtos, ArticleMapper::toResponse);
    }
}
