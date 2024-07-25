package com.hsgumussoy.blogsiteproject.domain.platform.collection.web;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CollectionRequest {
    private String name;
    private String userId;
}
