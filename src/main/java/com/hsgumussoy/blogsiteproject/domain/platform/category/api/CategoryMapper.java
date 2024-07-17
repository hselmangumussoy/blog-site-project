package com.hsgumussoy.blogsiteproject.domain.platform.category.api;

import com.hsgumussoy.blogsiteproject.domain.platform.category.web.CategoryRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.category.web.CategoryResponse;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public CategoryMapper() {
    }

    public static CategoryResponse toResponse(CategoryDto dto) {
        return CategoryResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    public static CategoryDto toDto(CategoryRequest request) {
        return CategoryDto.builder()
                .name(request.getName())
                .build();
    }

    public static List<CategoryResponse> toResponses(List<CategoryDto> categoryDtoList) {
        List<CategoryResponse> list = new ArrayList<>();
        for (CategoryDto categoryDto : categoryDtoList) {
            CategoryResponse response = toResponse(categoryDto);
            list.add(response);
        }
        return list;
    }

}
