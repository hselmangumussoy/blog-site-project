package com.hsgumussoy.blogsiteproject.domain.auth.usergroup.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.usergroup.api.UserGroupDto;
import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupDto;

public class UserGroupMapper {
    public static UserGroup toEntity(UserGroup userGroup, UserGroupDto dto) {
        userGroup.setGroupId(dto.getGroup().getId());
        userGroup.setUserId(dto.getUser().getId());
        return userGroup;
    }

    public static UserGroupDto toDto(UserGroup userGroup, UserDto userDto, GroupDto groupDto) {
        return UserGroupDto.builder()
                .group(groupDto)
                .user(userDto)
                .id(userGroup.getGroupId())
                .created(userGroup.getCreated())
                .modified(userGroup.getModified())
                .build();
    }
}
