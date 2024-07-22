package com.hsgumussoy.blogsiteproject.domain.platform.comment.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Comment extends AbstractEntity {
    @Lob
    @Column(length = 10000)
    private String content;

    private String userId;
    private String articleId;
}
