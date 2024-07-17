package com.hsgumussoy.blogsiteproject.domain.platform.tag.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tag extends AbstractEntity {
    String name;
}
