package com.hsgumussoy.blogsiteproject.domain.platform.category.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;

public class CategoryMapper {
    public CategoryMapper() {
    }

    public static Category toEntity(Category category, CategoryDto dto) {
        category.setName(dto.getName());
        return category;
    }

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .name(category.getName())
                .id(category.getId())
                .build();
    }
}
