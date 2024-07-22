package com.hsgumussoy.blogsiteproject.domain.platform.comment.web;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class CommentRequest {
    private  String userId;
    private String articleId;
    private String content;
}
