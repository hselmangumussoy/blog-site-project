package com.hsgumussoy.blogsiteproject.domain.platform.article.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articlecategory.ArticleCategory;
import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articlecategory.ArticleCategoryServiceImpl;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;
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
    private final ArticleCategoryServiceImpl articleCategoryService;

    @Override
    @Transactional
    public ArticleDto save(ArticleDto dto) {
        // Kullanıcı ve kategori bilgilerini al
        UserDto userDto = userService.getById(dto.getUser().getId());
        List<CategoryDto> categoryDtoList = dto.getCategories().stream()
                .map(category -> categoryService.getById(category.getId()))
                .collect(Collectors.toList());

        // Article nesnesini oluştur ve kaydet
        Article article = ArticleMapper.toEntity(new Article(), dto);
        repository.save(article);

        // ArticleCategory nesnelerini oluştur
        List<ArticleCategory> articleCategories = dto.getCategories().stream()
                .map(categoryDto -> {
                    ArticleCategory articleCategory = new ArticleCategory();
                    articleCategory.setArticleId(article.getId());
                    articleCategory.setCategoryId(categoryDto.getId());
                    return articleCategory;
                }).collect(Collectors.toList());

        // ArticleCategory nesnelerini kaydet
        articleCategoryService.saveAll(articleCategories);

        // ArticleDto nesnesini döndür
        return ArticleMapper.toDto(article, userDto, categoryDtoList, articleCategories);
    }

    @Override
    public ArticleDto getById(String id) {
        Article article = repository.findById(id).orElseThrow();
        UserDto userDto = userService.getById(article.getUserId());

        // İlgili kategoriler ve ArticleCategory bilgilerini al
        List<ArticleCategory> articleCategories = articleCategoryService.getByArticleId(id);
        List<String> categoryIds = articleCategories.stream().map(ArticleCategory::getCategoryId).collect(Collectors.toList());
        List<CategoryDto> categoryDtoList = categoryService.getByIds(categoryIds);

        return ArticleMapper.toDto(article, userDto, categoryDtoList, articleCategories);
    }

    @Override
    public void delete(String id) {
        Article article = repository.findById(id).orElseThrow();
        repository.delete(article);
    }

    @Override
    public ArticleDto update(String id, ArticleDto dto) {
        Article article = repository.findById(id).orElseThrow();
        ArticleMapper.toEntity(article, dto);
        repository.save(article);

        UserDto userDto = userService.getById(article.getUserId());
        List<ArticleCategory> articleCategories = articleCategoryService.getByArticleId(article.getId());
        List<String> categoryIds = articleCategories.stream().map(ArticleCategory::getCategoryId).collect(Collectors.toList());
        List<CategoryDto> categoryDtoList = categoryService.getByIds(categoryIds);

        return ArticleMapper.toDto(article, userDto, categoryDtoList, articleCategories);
    }

    @Override
    public Page<ArticleDto> getAll(Pageable pageable) {
        return PageToDto(repository.findAll(pageable));
    }

    @Override
    public List<ArticleDto> getByIds(List<String> ids) {
        List<Article> articles = repository.findAllById(ids);

        return articles.stream()
                .map(article -> {
                    UserDto userDto = userService.getById(article.getUserId());
                    List<ArticleCategory> articleCategories = articleCategoryService.getByArticleId(article.getId());
                    List<String> categoryIds = articleCategories.stream().map(ArticleCategory::getCategoryId).collect(Collectors.toList());
                    List<CategoryDto> categoryDtoList = categoryService.getByIds(categoryIds);

                    return ArticleMapper.toDto(article, userDto, categoryDtoList, articleCategories);
                })
                .collect(Collectors.toList());
    }

    private Page<ArticleDto> PageToDto(Page<Article> articles) {
        List<String> userIds = articles.stream().map(Article::getUserId).toList();
        List<UserDto> userDtoList = userService.getByIds(userIds);

        return PageUtil.pageToDto(articles, article -> {
            UserDto userDto = userDtoList.stream()
                    .filter(user -> user.getId().equals(article.getUserId()))
                    .findFirst()
                    .orElseThrow();

            List<ArticleCategory> articleCategories = articleCategoryService.getByArticleId(article.getId());
            List<String> categoryIds = articleCategories.stream().map(ArticleCategory::getCategoryId).collect(Collectors.toList());
            List<CategoryDto> categoryDtoList = categoryService.getByIds(categoryIds);

            return ArticleMapper.toDto(article, userDto, categoryDtoList, articleCategories);
        });
    }
}
