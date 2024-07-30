package com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articletag;

import com.hsgumussoy.blogsiteproject.domain.platform.article.api.articletag.ArticleTagDto;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.articletag.ArticleTagService;
import com.hsgumussoy.blogsiteproject.domain.platform.tag.api.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleTagServiceImpl implements ArticleTagService {
    private final ArticleTagRepository repository;
    private final TagService tagService;


    @Override
    public ArticleTagDto save(ArticleTagDto dto) {
        return ArticleTagMapper.toDto(repository.save(ArticleTagMapper.toEntity(new ArticleTag(), dto)), tagService);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public ArticleTagDto getById(String id) {
        return ArticleTagMapper.toDto(repository.findById(id).orElseThrow(), tagService);
    }

    @Override
    public ArticleTagDto update(ArticleTagDto dto, String id) {
        return null;
    }

}
