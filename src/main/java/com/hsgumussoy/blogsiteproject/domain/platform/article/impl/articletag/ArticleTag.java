package com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articletag;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ArticleTag extends AbstractEntity {
    private String articleId;
    private String tagId;
}
