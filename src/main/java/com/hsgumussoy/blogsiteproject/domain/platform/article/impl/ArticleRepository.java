package com.hsgumussoy.blogsiteproject.domain.platform.article.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, String> {
}
