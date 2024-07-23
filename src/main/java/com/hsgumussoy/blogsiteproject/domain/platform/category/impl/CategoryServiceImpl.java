package com.hsgumussoy.blogsiteproject.domain.platform.category.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
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
    public Page<CategoryDto> getAll(Pageable pageable) {
        return PageUtil.pageToDto(repository.findAll(pageable), CategoryMapper::toDto );
    }

    @Override
    public CategoryDto update(String id, CategoryDto dto) {
        return null;
    }

    @Override
    public List<CategoryDto> getByIds(List<String> ids) {
        return repository.findAllById(ids).stream().map(CategoryMapper::toDto).toList();
    }

}
