package com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articleuser;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntityForIndexing;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ArticleUser extends AbstractEntityForIndexing {
    private String articleId;
    private String userId;
}
