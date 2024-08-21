package com.hsgumussoy.blogsiteproject.domain.platform.article.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articlecategory.ArticleCategory;
import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articlecategory.ArticleCategoryRepository;
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
    private final ArticleCategoryRepository articleCategoryRepository;


    @Override
    @Transactional
    public ArticleDto save(ArticleDto dto) {
        UserDto userDto = userService.getById(dto.getUser().getId());

        Article article = ArticleMapper.toEntity(new Article(),dto);
        repository.save(article);

        List<ArticleCategory> articleCategories = dto.getCategoryId().stream()
                .map(categoryId -> {
                    ArticleCategory articleCategory = new ArticleCategory();
                    articleCategory.setArticleId(article.getId());
                    articleCategory.setCategoryId(categoryId);
                    return articleCategory;
                }).collect(Collectors.toList());

        articleCategoryRepository.saveAll(articleCategories);

        return ArticleMapper.toDto(article,userDto);
    }
    @Override
    public ArticleDto getById(String id) {
        Article article = repository.findById(id).orElseThrow();
        UserDto userDto = userService.getById(article.getUserId());
        return ArticleMapper.toDto(article,userDto);
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
        return PageToDto(repository.findAll(pageable));
    }

    @Override
    public List<ArticleDto> getByIds(List<String> ids) {
        // `findAllById` ile Article nesnelerini getiriyoruz
        List<Article> articles = repository.findAllById(ids);

        // Her bir Article için userId alınıyor ve ilgili UserDto nesnesi getiriliyor
        return articles.stream()
                .map(article -> {
                    UserDto userDto = userService.getById(article.getUserId());
                    return ArticleMapper.toDto(article, userDto);
                })
                .collect(Collectors.toList());
    }
    private Page<ArticleDto> PageToDto(Page<Article> articles) {
        List<String> userIds = articles.stream().map(Article::getUserId).toList();

        List<UserDto> userDtoList = userService.getByIds(userIds);

        return PageUtil.pageToDto(articles, (article -> {
            UserDto userDto = userDtoList.stream().filter((user -> user.getId().equals(article.getUserId()))).findFirst().orElseThrow();

            return ArticleMapper.toDto(article ,userDto);
        }));

    }
}
