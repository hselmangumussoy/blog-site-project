package com.hsgumussoy.blogsiteproject.domain.platform.follow.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class FollowDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final UserDto follower;
    private final UserDto followed;
    private final int count;
}
