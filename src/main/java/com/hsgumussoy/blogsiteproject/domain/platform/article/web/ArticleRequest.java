package com.hsgumussoy.blogsiteproject.domain.platform.article.web;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequest {
    private String title;
    private String content;

    private String userId;
    private List<String> categoryId;

}
