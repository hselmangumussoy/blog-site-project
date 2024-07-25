package com.hsgumussoy.blogsiteproject.domain.platform.group.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupDto;

public class GroupMapper {
    public static GroupDto toDto(Group role) {
        return GroupDto.builder()
                .id(role.getId())
                .name(role.getName())
                .created(role.getCreated())
                .modified(role.getModified())
                .build();
    }

    public static Group toEntity(Group role, GroupDto dto) {
        role.setName(dto.getName());
        return role;
    }
}
