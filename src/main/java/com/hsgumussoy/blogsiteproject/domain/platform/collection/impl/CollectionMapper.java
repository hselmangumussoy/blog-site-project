package com.hsgumussoy.blogsiteproject.domain.platform.collection.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.api.CollectionDto;

public class CollectionMapper {
    public static CollectionDto toDto(Collection collection) {
        return CollectionDto.builder()
                .id(collection.getId())
                .name(collection.getName())
                .created(collection.getCreated())
                .modified(collection.getModified())
                .build();
    }

    public static Collection toEntity(Collection collection, CollectionDto dto) {
        collection.setName(dto.getName());
        return collection;
    }
}
