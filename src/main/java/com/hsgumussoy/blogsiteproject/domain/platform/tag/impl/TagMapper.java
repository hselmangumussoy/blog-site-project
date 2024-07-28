package com.hsgumussoy.blogsiteproject.domain.platform.tag.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.tag.api.TagDto;

public class TagMapper {
    public static Tag toEntity(Tag tag, TagDto dto) {
        tag.setName(dto.getName());
        return tag;
    }

    public static TagDto toDto(Tag tag) {
        return TagDto.builder()
                .name(tag.getName())
                .id(tag.getId())
                .created(tag.getCreated())
                .modified(tag.getModified())
                .build();
    }
}
