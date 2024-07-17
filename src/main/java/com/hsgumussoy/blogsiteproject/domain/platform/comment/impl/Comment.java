package com.hsgumussoy.blogsiteproject.domain.platform.comment.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Comment extends AbstractEntity {
    private String content;

    private Long userId;
    private Long articleId;
}
