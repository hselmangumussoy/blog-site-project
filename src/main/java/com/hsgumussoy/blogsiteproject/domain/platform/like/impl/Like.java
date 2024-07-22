package com.hsgumussoy.blogsiteproject.domain.platform.like.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Like extends AbstractEntity {
    private String userId;
    private String articleId;
    private int count;
}
