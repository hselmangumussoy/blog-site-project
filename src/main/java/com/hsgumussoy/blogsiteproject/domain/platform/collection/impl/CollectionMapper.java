package com.hsgumussoy.blogsiteproject.domain.platform.collection.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.api.CollectionDto;

public class CollectionMapper {
    public static CollectionDto toDto(Collection collection, UserDto userDto) {
        return CollectionDto.builder()
                .id(collection.getId())
                .user(userDto)
                .name(collection.getName())
                .created(collection.getCreated())
                .modified(collection.getModified())
                .build();
    }

    public static Collection toEntity(Collection collection, CollectionDto dto) {
        collection.setName(dto.getName());
        collection.setUserId(dto.getUser().getId());
        return collection;
    }
}
