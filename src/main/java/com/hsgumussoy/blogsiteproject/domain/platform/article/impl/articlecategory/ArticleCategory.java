package com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articlecategory;

import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.Article;
import com.hsgumussoy.blogsiteproject.domain.platform.category.impl.Category;
import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntityForIndexing;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ArticleCategory extends AbstractEntityForIndexing {
    private String articleId;
    private String categoryId;
}
