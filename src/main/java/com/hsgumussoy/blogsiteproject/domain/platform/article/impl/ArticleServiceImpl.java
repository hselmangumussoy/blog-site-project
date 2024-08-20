package com.hsgumussoy.blogsiteproject.domain.platform.article.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articlecategory.ArticleCategoryRepository;
import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articleuser.ArticleUserRepository;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository repository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ArticleCategoryRepository articleCategoryRepository;
    private final ArticleUserRepository articleUserRepository;


    @Override
    @Transactional
    public ArticleDto save(ArticleDto dto) {
        return saveInitial(dto);
    }
    public ArticleDto saveInitial(ArticleDto dto) {
        //TODO save metodunun kayıt işlemleri nasıl yapılacağı araştırılıp yapılacak.

        return null;
    };


    @Override
    public ArticleDto getById(String id) {
        Article article = repository.findById(id).orElseThrow();
        return ArticleMapper.toDto(article);
    }

    @Override
    public void delete(String id) {
        var article = repository.findById(id).orElseThrow();

        repository.delete(article);
    }

    @Override
    public ArticleDto update(String id, ArticleDto dto) {
        return null;
    }

    @Override
    public Page<ArticleDto> getAll(Pageable pageable) {
        return PageUtil.pageToDto(repository.findAll(pageable), ArticleMapper::toDto);
    }

    @Override
    public List<ArticleDto> getByIds(List<String> ids) {
        return repository.findAllById(ids).stream().map(ArticleMapper::toDto).collect(Collectors.toList());
    }
}
