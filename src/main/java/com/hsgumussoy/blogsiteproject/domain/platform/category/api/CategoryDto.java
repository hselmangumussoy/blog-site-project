package com.hsgumussoy.blogsiteproject.domain.platform.category.api;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class CategoryDto {
    private final String id;
}
