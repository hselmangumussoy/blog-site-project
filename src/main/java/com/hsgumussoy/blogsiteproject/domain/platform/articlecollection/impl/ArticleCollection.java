package com.hsgumussoy.blogsiteproject.domain.platform.articlecollection.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ArticleCollection extends AbstractEntity {
    private  Long collection;
    private Long articleId;
}
