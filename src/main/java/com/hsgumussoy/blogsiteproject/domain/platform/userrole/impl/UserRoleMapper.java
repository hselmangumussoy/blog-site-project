package com.hsgumussoy.blogsiteproject.domain.platform.userrole.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.role.api.RoleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.userrole.api.UserRoleDto;

public class UserRoleMapper {
    public static UserRole toEntity(UserRole userRole, UserRoleDto dto) {
        userRole.setRoleId(dto.getUser().getId());
        userRole.setUserId(dto.getRole().getId());
        return userRole;
    }

    public static UserRoleDto toDto(UserRole userRole, UserDto userDto, RoleDto roleDto) {
        return UserRoleDto.builder()
                .role(roleDto)
                .user(userDto)
                .id(userRole.getRoleId())
                .created(userRole.getCreated())
                .modified(userRole.getModified())
                .build();
    }
}
