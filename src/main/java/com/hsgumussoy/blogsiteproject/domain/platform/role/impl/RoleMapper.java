package com.hsgumussoy.blogsiteproject.domain.platform.role.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.role.api.RoleDto;

public class RoleMapper {
    public static RoleDto toDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .created(role.getCreated())
                .modified(role.getModified())
                .build();
    }

    public static Role toEntity(Role role, RoleDto dto) {
        role.setName(dto.getName());
        return role;
    }
}
