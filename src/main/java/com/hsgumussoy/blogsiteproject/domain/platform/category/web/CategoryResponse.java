package com.hsgumussoy.blogsiteproject.domain.platform.category.web;

import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class CategoryResponse {
    private final String id;
    private final String name;
}
