package com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articletag;

import com.hsgumussoy.blogsiteproject.domain.platform.article.api.articletag.ArticleTagDto;
import com.hsgumussoy.blogsiteproject.domain.platform.tag.api.TagDto;
import com.hsgumussoy.blogsiteproject.domain.platform.tag.impl.TagServiceImpl;

public class ArticleTagMapper {
    public static ArticleTagDto toDto(ArticleTag articleTag, TagServiceImpl tagService) {
        TagDto tag = tagService.getById(articleTag.getTagId());

        return ArticleTagDto.builder()
                .id(articleTag.getId())
                .created(articleTag.getCreated())
                .modified(articleTag.getModified())
                .tag(tag)
                .build();
    }

    public static ArticleTag toEntity(ArticleTag articleTag, ArticleTagDto dto) {
        articleTag.setTagId(dto.getTag().getId());
        articleTag.setId(dto.getId());

        return articleTag;
    }
}
