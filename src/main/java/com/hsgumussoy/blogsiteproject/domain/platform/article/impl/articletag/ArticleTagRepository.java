package com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articletag;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleTagRepository extends JpaRepository<ArticleTag,String> {
    List<ArticleTag> findByArticleId(String articleId);
    List<ArticleTag> findByTagIdIn(List<String> tagIds);
}
