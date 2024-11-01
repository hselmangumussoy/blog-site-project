package com.hsgumussoy.blogsiteproject.domain.platform.article.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articlecategory.ArticleCategory;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;

import java.util.List;

public class ArticleMapper {
    public ArticleMapper() {
    }

    public static ArticleDto toDto(Article article, UserDto user , List<CategoryDto> categoryDtoList, List<ArticleCategory> articleCategoryList) {
        List<String> categoryIds = articleCategoryList.stream()
                .filter(articleCategory -> articleCategory.getArticleId().equals(article.getId()))
                .map(ArticleCategory::getCategoryId)
                .toList();

        List<CategoryDto> categoryDtos = categoryDtoList.stream()
                .filter(c -> categoryIds.contains(c.getId()))
                .toList();

        return ArticleDto.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .id(article.getId())
                .modified(article.getModified())
                .created(article.getCreated())
                .likeCount(article.getLikeCount())
                .user(user)
                .categories(categoryDtos)
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
