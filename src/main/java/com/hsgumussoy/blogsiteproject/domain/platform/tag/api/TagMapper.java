package com.hsgumussoy.blogsiteproject.domain.platform.tag.api;

import com.hsgumussoy.blogsiteproject.domain.platform.tag.web.TagRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.tag.web.TagResponse;
import com.hsgumussoy.blogsiteproject.library.rest.PageResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class TagMapper {
    public static TagDto toDto(TagRequest request) {
        return TagDto.builder()
                .name(request.getName()).build();
    }

    public static TagResponse toResponse(TagDto dto) {
        return TagResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .name(dto.getName())
                .build();
    }

    public static Page<TagResponse> toPageResponse(Page<TagDto> dtos) {
        return PageUtil.pageToDto(dtos, TagMapper::toResponse);
    }
}
