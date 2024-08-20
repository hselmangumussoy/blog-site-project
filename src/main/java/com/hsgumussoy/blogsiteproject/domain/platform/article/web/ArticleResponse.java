package com.hsgumussoy.blogsiteproject.domain.platform.article.web;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class ArticleResponse {
    private final String id;
    private final String title;
    private final String content;
    private final Date created;
    private final Date modified;
    private final int likeCount;
}
