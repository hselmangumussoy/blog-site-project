package com.hsgumussoy.blogsiteproject.domain.platform.articlereadinglist.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ArticleReadingList extends AbstractEntity {
    private  Long readingListId;
    private Long articleId;
}
