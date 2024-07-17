package com.hsgumussoy.blogsiteproject.domain.platform.readinglist.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ReadingList extends AbstractEntity {
    private String name;

    private String userId;
}
