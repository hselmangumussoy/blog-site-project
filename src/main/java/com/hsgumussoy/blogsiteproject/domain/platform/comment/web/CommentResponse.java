package com.hsgumussoy.blogsiteproject.domain.platform.comment.web;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Builder
@Setter
@Getter
@RequiredArgsConstructor
public class CommentResponse {
    private final String id;
    private final Date modified;
    private final Date created;
    private  final UserDto user;
    private final ArticleDto article;
    private final String content;
}
