package com.hsgumussoy.blogsiteproject.domain.platform.like.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleService;
import com.hsgumussoy.blogsiteproject.domain.platform.like.api.LikeDto;
import com.hsgumussoy.blogsiteproject.domain.platform.like.api.LikeService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository repository;
    private final UserService userService;
    private final ArticleService articleService;

    @Override
    public LikeDto save(LikeDto dto) {
        UserDto userDtoList = userService.getById(dto.getUser().getId());
        ArticleDto articleDtoList = articleService.getById(dto.getArticle().getId());

        return LikeMapper.toDto(repository.save(LikeMapper.toEntity(new Like(),dto)),userDtoList, articleDtoList);
    }

    @Override
    public LikeDto getById(String id) {
        Like like = repository.findById(id).orElseThrow();
        UserDto userDtoList = userService.getById(like.getUserId());
        ArticleDto articleDtoList = articleService.getById(like.getArticleId());

        return LikeMapper.toDto(like,userDtoList,articleDtoList);
    }

    @Override
    public Page<LikeDto> getAll(Pageable pageable) {
        return PageToDto(repository.findAll(pageable));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    private Page<LikeDto> PageToDto(Page<Like> likes) {
        List<String> userIds = likes.stream().map(Like::getUserId).toList();
        List<String> articleIds = likes.stream().map(Like::getArticleId).toList();

        List<UserDto> userDtoList = userService.getByIds(userIds);
        List<ArticleDto> articleDtoList = articleService.getByIds(articleIds);

        return PageUtil.pageToDto(likes, (like) ->{
            UserDto userDto = userDtoList.stream().filter((user -> user.getId().equals(like.getUserId()))).findFirst().orElseThrow();
            ArticleDto articleDto = articleDtoList.stream().filter((article -> article.getId().equals(like.getArticleId()))).findFirst().orElseThrow();

            return LikeMapper.toDto(like, userDto,articleDto);
        } );
    }
}
