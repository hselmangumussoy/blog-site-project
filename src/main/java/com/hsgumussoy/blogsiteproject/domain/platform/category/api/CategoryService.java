package com.hsgumussoy.blogsiteproject.domain.platform.category.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface CategoryService {
    CategoryDto getById(String id);
    CategoryDto save(CategoryDto dto);

    void delete(String id);

    Page<CategoryDto> getAll(Pageable pageable);

    CategoryDto update(String id, CategoryDto dto);

    List<CategoryDto> getByIds(List<String> categoryIds);
}
