package com.hsgumussoy.blogsiteproject.domain.platform.follow.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.follow.api.FollowDto;

public class FollowMapper {
    public static FollowDto toDto(Follow follow, UserDto followerDto, UserDto followedDto) {
        return FollowDto.builder()
                .follower(followerDto)
                .followed(followedDto)
                .id(follow.getId())
                .count(follow.getCount())
                .created(follow.getCreated())
                .modified(follow.getModified())
                .build();
    }

    public static Follow toEntity(Follow follow, FollowDto dto) {
        follow.setFollowerId(dto.getFollower().getId());
        follow.setFollowedId(dto.getFollowed().getId());
        follow.setId(dto.getId());
        follow.setCount(dto.getCount());
        follow.setCreated(dto.getCreated());
        follow.setModified(dto.getModified());

        return follow;
    }
}
