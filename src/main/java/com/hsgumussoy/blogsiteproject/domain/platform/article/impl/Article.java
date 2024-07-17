package com.hsgumussoy.blogsiteproject.domain.platform.article.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Article extends AbstractEntity {
    private String title;
    private String content;

    private Long userId;
    private Long categoryId;

}
