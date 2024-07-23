package com.hsgumussoy.blogsiteproject.domain.platform.follow.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Follow extends AbstractEntity {
    private String followerId; //relation to user
    private String userId; //relation to user
}
