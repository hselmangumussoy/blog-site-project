package com.hsgumussoy.blogsiteproject.domain.platform.like.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class LikeDto {
    private  final String id;
    private  final Date modified;
    private final int count;
    private  final Date created;
    private  final UserDto user;
    private  final ArticleDto article;
}
