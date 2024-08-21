package com.hsgumussoy.blogsiteproject.domain.platform.collection.web;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddArticleToCollectionRequest {
    private List<String> articleId;
    private String userId;
    private String collectionId;
}
