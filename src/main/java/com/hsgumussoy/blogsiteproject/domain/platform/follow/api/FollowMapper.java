package com.hsgumussoy.blogsiteproject.domain.platform.follow.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.follow.web.FollowRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.follow.web.FollowResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class FollowMapper {


    public static FollowDto toDto(FollowRequest request) {
        return FollowDto.builder()
                .followed(UserDto.builder().id(request.getFollowedId()).build())
                .follower(UserDto.builder().id(request.getFollowerId()).build())
                .build();
    }

    public static FollowResponse toResponse(FollowDto dto) {
        return FollowResponse.builder()
                .followed(dto.getFollowed())
                .follower(dto.getFollower())
                .count(dto.getCount())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .id(dto.getId())
                .build();
    }

    public static Page<FollowResponse> toPageResponse(Page<FollowDto> dtos) {
        return PageUtil.pageToDto(dtos, FollowMapper::toResponse);
    }
}
