package com.hsgumussoy.blogsiteproject.domain.platform.permission.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.permission.api.PermissionDto;

public class PermissionMapper {
    public static Permission toEntity(Permission permission, PermissionDto dto) {
        permission.setName(dto.getName());
        permission.setDescription(dto.getDescription());
        permission.setPermissionType(dto.getPermissionType());
        return permission;
    }

    public static PermissionDto toDto(Permission permission) {
        return  PermissionDto.builder()
                .id(permission.getId())
                .name(permission.getName())
                .permissionType(permission.getPermissionType())
                .description(permission.getDescription())
                .created(permission.getCreated())
                .modified(permission.getModified())
                .build();
    }
}
