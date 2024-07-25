package com.hsgumussoy.blogsiteproject.domain.auth.usergroup.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.usergroup.api.UserGroupDto;
import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupDto;

public class UserGroupMapper {
    public static UserGroup toEntity(UserGroup userRole, UserGroupDto dto) {
        userRole.setRoleId(dto.getUser().getId());
        userRole.setUserId(dto.getRole().getId());
        return userRole;
    }

    public static UserGroupDto toDto(UserGroup userRole, UserDto userDto, GroupDto roleDto) {
        return UserGroupDto.builder()
                .role(roleDto)
                .user(userDto)
                .id(userRole.getRoleId())
                .created(userRole.getCreated())
                .modified(userRole.getModified())
                .build();
    }
}
