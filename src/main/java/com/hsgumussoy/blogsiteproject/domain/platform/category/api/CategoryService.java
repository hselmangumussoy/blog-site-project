package com.hsgumussoy.blogsiteproject.domain.platform.category.api;

import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryDto getById(String id);
    CategoryDto save(CategoryDto dto);

    void delete(String id);

    List<CategoryDto> getAll();

    CategoryDto update(String id, CategoryDto dto);

    List<CategoryDto> getByIds(List<String> categoryIds);
}
