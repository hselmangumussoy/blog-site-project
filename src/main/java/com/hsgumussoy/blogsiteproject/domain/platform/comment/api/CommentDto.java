package com.hsgumussoy.blogsiteproject.domain.platform.comment.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import lombok.*;

import java.util.Date;
@RequiredArgsConstructor
@Builder
@Setter
@Getter
public class CommentDto {
    private final String id;
    private final Date modified;
    private final Date created;
    private  final UserDto user;
    private final ArticleDto article;
    private final String content;
}
