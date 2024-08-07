package com.hsgumussoy.blogsiteproject.domain.platform.collection.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@RequiredArgsConstructor
@Setter
@Getter
@Builder
public class CollectionDto {
    private final String id;
    private final String name;
    private final Date created;
    private final Date modified;
    private final UserDto user;

    private final ArticleDto article;// collection controller için
}
