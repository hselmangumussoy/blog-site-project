package com.hsgumussoy.blogsiteproject.domain.platform.article.api.articletag;

import java.util.List;

public interface ArticleTagService {
    ArticleTagDto save(ArticleTagDto dto);
    void delete (String id);
    ArticleTagDto getById(String id);
    ArticleTagDto update(ArticleTagDto dto, String id);

}
