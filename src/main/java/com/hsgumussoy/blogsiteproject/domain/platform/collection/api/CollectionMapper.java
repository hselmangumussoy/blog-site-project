package com.hsgumussoy.blogsiteproject.domain.platform.collection.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.web.CollectionRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.web.CollectionResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class CollectionMapper {
    public static CollectionDto toDto(CollectionRequest request) {
        return CollectionDto.builder()
                .name(request.getName())
                .user(UserDto.builder().id(request.getUserId()).build())
                .build();
    }

    public static CollectionResponse toResponse(CollectionDto dto) {
        return CollectionResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .user(dto.getUser())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .build();
    }

    public static Page<CollectionResponse> toPageResponse(Page<CollectionDto> dtos) {
        return PageUtil.pageToDto(dtos, CollectionMapper::toResponse);
    }
}
