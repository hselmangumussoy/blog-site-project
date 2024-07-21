package com.hsgumussoy.blogsiteproject.domain.platform.article.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleService;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;


import java.awt.print.Pageable;

@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository repository;
    private final UserService userService;
    private final CategoryService categoryService;
    @Override
    public ArticleDto save(ArticleDto dto) {
        UserDto userDto = userService.getById(dto.getUser().getId());
        CategoryDto categoryDto = categoryService.getById(dto.getCategory().getId());

        return ArticleMapper.toDto(repository.save(ArticleMapper.toEntity(new Article(), dto)), userDto,categoryDto);
    }

    @Override
    public ArticleDto getById(String id) {
        Article article = repository.findById(id).orElseThrow();
        UserDto userDto = userService.getById(article.getUserId());
        CategoryDto categoryDto = categoryService.getById(article.getCategoryId());

        return ArticleMapper.toDto(article, userDto, categoryDto);
    }

    @Override
    public void delete(String id) {
        /*var  article = repository.findById(id).orElseThrow();
        repository.delete(article);*/
        repository.findById(id);
    }

    @Override
    public ArticleDto update(String id, ArticleDto dto) {
        return null;
    }

    @Override
    public Page<ArticleDto> getAll(Pageable pageable) {
        return PageToDto(repository.findAll(pageable));
    }
}
