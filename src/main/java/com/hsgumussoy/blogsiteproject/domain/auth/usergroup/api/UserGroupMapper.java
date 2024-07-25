package com.hsgumussoy.blogsiteproject.domain.auth.usergroup.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.usergroup.web.UserGroupRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupDto;
import com.hsgumussoy.blogsiteproject.domain.auth.usergroup.web.UserGroupResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class UserGroupMapper {
    public static UserGroupDto toDto(UserGroupRequest request) {
        return UserGroupDto.builder()
                .user(UserDto.builder().id(request.getUserId()).build())
                .role(GroupDto.builder().id(request.getRoleId()).build())
                .build();
    }

    public static UserGroupResponse toResponse(UserGroupDto dto) {
        return UserGroupResponse.builder()
                .user(dto.getUser())
                .role(dto.getRole())
                .created(dto.getCreated())
                .id(dto.getId())
                .modified(dto.getModified())
                .build();
    }

    public static Page<UserGroupResponse> toPageResponse(Page<UserGroupDto> dtos) {
        return PageUtil.pageToDto(dtos, UserGroupMapper::toResponse);
    }
}
