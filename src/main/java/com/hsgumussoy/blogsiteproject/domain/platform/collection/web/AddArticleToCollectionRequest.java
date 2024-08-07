package com.hsgumussoy.blogsiteproject.domain.platform.collection.web;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddArticleToCollectionRequest {
    private String articleId;
    private String userId;
    private String collectionId;
}
