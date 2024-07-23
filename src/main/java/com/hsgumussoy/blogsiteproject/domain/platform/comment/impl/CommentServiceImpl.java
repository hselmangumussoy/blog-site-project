package com.hsgumussoy.blogsiteproject.domain.platform.comment.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleService;
import com.hsgumussoy.blogsiteproject.domain.platform.comment.api.CommentDto;
import com.hsgumussoy.blogsiteproject.domain.platform.comment.api.CommentService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;
    private final UserService userService;
    private final ArticleService articleService;

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Page<CommentDto> getAll(Pageable pageable) {
        return PageToDto(repository.findAll(pageable));
    }

    @Override
    public CommentDto getById(String id) {
        Comment comment = repository.findById(id).orElseThrow();
        UserDto userDto = userService.getById(comment.getArticleId());
        ArticleDto articleDto = articleService.getById(comment.getArticleId());

        return CommentMapper.toDto(comment, userDto, articleDto);
    }

    @Override
    public CommentDto save(CommentDto dto) {
        UserDto userDto = userService.getById(dto.getUser().getId());
        ArticleDto articleDto = articleService.getById(dto.getArticle().getId());

        return CommentMapper.toDto(repository.save(CommentMapper.toEntity(new Comment(), dto)), userDto, articleDto);
    }


    private Page<CommentDto> PageToDto(Page<Comment> comments) {
        List<String> userIds = comments.stream().map(Comment::getUserId).toList();
        List<String> articleIds = comments.stream().map(Comment::getArticleId).toList();

        List<UserDto> userDtoList = userService.getByIds(userIds);
        List<ArticleDto> articleDtoList = articleService.getByIds(articleIds);

        return PageUtil.pageToDto(comments, (comment -> {
            UserDto userDto = userDtoList.stream().filter(user -> user.getId().equals(comment.getUserId())).findFirst().orElseThrow();
            ArticleDto articleDto = articleDtoList.stream().filter(article -> article.getId().equals(comment.getArticleId())).findFirst().orElseThrow();
            return CommentMapper.toDto(comment, userDto, articleDto);
        }));
    }
}
