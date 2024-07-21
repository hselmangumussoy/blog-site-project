package com.hsgumussoy.blogsiteproject.domain.platform.article.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleService;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

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
    public Page<ArticleDto> PageToDto(Page<Article> articles){
        List<String> categoryIds = articles.stream().map(Article::getCategoryId).toList();
        List<String> userIds = articles.stream().map(Article::getUserId).toList();

        List<CategoryDto> categoryDtoList = categoryService.getByIds(categoryIds);
        List<UserDto> userDtoList = userService.getByIds(userIds);

        return PageUtil.pageToDto(articles , (article)->{
            CategoryDto categoryDto = categoryDtoList.stream().filter(category -> category.getId().equals(article.getCategoryId())).findFirst().orElseThrow();
            UserDto userDto = userDtoList.stream().filter(user -> user.getId().equals(article.getUserId())).findFirst().orElseThrow();
            return ArticleMapper.toDto(article, userDto, categoryDto);
        });
    }
}
