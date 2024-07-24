package com.hsgumussoy.blogsiteproject.domain.platform.article.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Article extends AbstractEntity {
    private String title;
    private String content;
    private int likeCount;

    private String userId;
    private String categoryId;

}
