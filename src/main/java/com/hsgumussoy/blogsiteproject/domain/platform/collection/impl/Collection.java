package com.hsgumussoy.blogsiteproject.domain.platform.collection.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Collection extends AbstractEntity {
    private String name;

    private String userId;
}
