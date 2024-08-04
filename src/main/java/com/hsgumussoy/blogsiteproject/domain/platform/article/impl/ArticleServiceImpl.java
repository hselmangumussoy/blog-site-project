package com.hsgumussoy.blogsiteproject.domain.platform.article.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articletag.ArticleTag;
import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articletag.ArticleTagRepository;
import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articletag.ArticleTagServiceImpl;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryService;
import com.hsgumussoy.blogsiteproject.domain.platform.tag.api.TagDto;
import com.hsgumussoy.blogsiteproject.domain.platform.tag.impl.Tag;
import com.hsgumussoy.blogsiteproject.domain.platform.tag.impl.TagServiceImpl;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository repository;
    private final ArticleTagRepository articleTagRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final TagServiceImpl tagService;
    private final ArticleTagServiceImpl articleTagService;
    public final int ARTICLE_STATUS_NONE = 0;
    public final int ARTICLE_STATUS_DRAFT= 1;


    @Override
    @Transactional
    public ArticleDto save(ArticleDto dto) {
     return null;
    }

    private ArticleDto articleIsAbsent(ArticleDto dto) {
        return null;
    }

    private ArticleDto articleIsExist(Optional<Article> article, ArticleDto articleDto, TagDto tagDto) {
        return null;
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
        var article = repository.findById(id).orElseThrow();
        List<ArticleTag> articleTags = articleTagRepository.findByArticleId(id);
        articleTagRepository.deleteAll(articleTags);
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
        List<Article> articles = repository.findAllById(ids);
        List<CategoryDto> categoryDtoList = categoryService.getByIds(articles.stream().map(Article::getCategoryId).collect(Collectors.toList()));
        List<UserDto> userDtoList = userService.getByIds(articles.stream().map(Article::getUserId).collect(Collectors.toList()));

        return repository.findAllById(ids).stream().map(article ->ArticleMapper.toDto(article, userDtoList,categoryDtoList)).toList();
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
