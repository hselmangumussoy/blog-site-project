package com.hsgumussoy.blogsiteproject.domain.platform.category.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryService;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    @Override
    public CategoryDto getById(String id) {
        return repository.findById(id).map(CategoryMapper::toDto).orElseThrow();
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        return CategoryMapper.toDto(repository.save(CategoryMapper.toEntity(new Category() , dto)));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<CategoryDto> getAll() {
        return repository.findAll().stream().map(CategoryMapper::toDto).toList();
    }

    @Override
    public CategoryDto update(String id, CategoryDto dto) {
        return null;
    }
}
