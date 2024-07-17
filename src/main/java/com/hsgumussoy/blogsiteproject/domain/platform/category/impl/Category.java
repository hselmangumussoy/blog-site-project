package com.hsgumussoy.blogsiteproject.domain.platform.category.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Category extends AbstractEntity {
    private String name;
}
