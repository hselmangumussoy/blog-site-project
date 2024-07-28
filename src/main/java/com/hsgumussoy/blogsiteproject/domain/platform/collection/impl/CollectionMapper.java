package com.hsgumussoy.blogsiteproject.domain.platform.collection.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.api.CollectionDto;
import org.springframework.util.StringUtils;

import java.util.List;

public class CollectionMapper {
    public static CollectionDto toDto(Collection collection, UserDto userDto) {
        return CollectionDto.builder()
                .id(collection.getId())
                .name(collection.getName())
                .created(collection.getCreated())
                .modified(collection.getModified())
                .user(userDto)
                .build();
    }
    public static CollectionDto toDto(Collection collection, List<UserDto> userDtoList) {
        UserDto user = StringUtils.hasLength(collection.getUserId()) ?
                userDtoList.stream()
                        .filter(c-> c.getId().equals(collection.getUserId()))
                        .findFirst()
                        .orElseThrow()
                :null;


        return CollectionDto.builder()
                .id(collection.getId())
                .name(collection.getName())
                .created(collection.getCreated())
                .modified(collection.getModified())
                .user(user)
                .build();
    }

    public static Collection toEntity(Collection collection, CollectionDto dto) {
        collection.setName(dto.getName());
        collection.setUserId(dto.getUser().getId());
        return collection;
    }
}
