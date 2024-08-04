package com.hsgumussoy.blogsiteproject.domain.platform.article.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.articletag.ArticleTagDto;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;
import com.hsgumussoy.blogsiteproject.domain.platform.tag.api.TagDto;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class ArticleDto {
    private final String id;
    private final String title;
    private final String content;
    private final Date created;
    private final Date modified;
    private final int likeCount;
    private final int status;

    private final UserDto user;
    private final CategoryDto category;

    private final String tagId;
}
