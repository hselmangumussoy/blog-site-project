package com.hsgumussoy.blogsiteproject.domain.platform.articletag.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ArticleTag extends AbstractEntity {
    private Long articleId;
    private Long tagId;
}