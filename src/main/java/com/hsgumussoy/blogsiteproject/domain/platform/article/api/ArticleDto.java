package com.hsgumussoy.blogsiteproject.domain.platform.article.api;

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

    private final List<String> userId;
    private final List<String> categoryId;
}
