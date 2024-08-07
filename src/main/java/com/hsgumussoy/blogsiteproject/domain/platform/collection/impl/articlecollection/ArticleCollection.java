package com.hsgumussoy.blogsiteproject.domain.platform.collection.impl.articlecollection;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntityForIndexing;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ArticleCollection extends AbstractEntityForIndexing {
    private String collectionId;
    private String articleId;
}
