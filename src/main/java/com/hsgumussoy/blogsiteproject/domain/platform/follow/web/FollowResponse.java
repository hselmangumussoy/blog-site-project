package com.hsgumussoy.blogsiteproject.domain.platform.follow.web;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.impl.User;
import com.hsgumussoy.blogsiteproject.domain.platform.follow.api.FollowDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class FollowResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final UserDto follower;
    private final UserDto followed;
    private final int count;

}
