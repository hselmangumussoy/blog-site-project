package com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articlecategory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleCategoryServiceImpl {
    private final ArticleCategoryRepository articleCategoryRepository;
    @Transactional
    public void saveAll(List<ArticleCategory> articleCategories) {
        articleCategoryRepository.saveAll(articleCategories);
    }

    public List<ArticleCategory> getByArticleId(String articleId) {
        return articleCategoryRepository.findByArticleId(articleId);
    }
}
