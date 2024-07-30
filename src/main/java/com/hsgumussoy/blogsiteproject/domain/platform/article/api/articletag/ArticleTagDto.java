package com.hsgumussoy.blogsiteproject.domain.platform.article.api.articletag;

import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.tag.api.TagDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class ArticleTagDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final TagDto tag;
    //private final ArticleDto articleDto;
}
