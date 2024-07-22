package com.hsgumussoy.blogsiteproject.domain.platform.like.web;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeRequest {
    private String userId;
    private String articleId;
}
