package com.hsgumussoy.blogsiteproject.domain.platform.follow.web;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowRequest {
    private String followerId;
    private String followedId;
}
