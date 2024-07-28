package com.hsgumussoy.blogsiteproject.domain.platform.group.api;

import com.hsgumussoy.blogsiteproject.domain.platform.group.web.GroupRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.group.web.GroupResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class GroupMapper {
    public static GroupResponse toResponse(GroupDto dto) {
        return GroupResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .name(dto.getName())
                .build();
    }

    public static GroupDto toDto(GroupRequest request) {
        return GroupDto.builder()
                .name(request.getName())
                .build();

    }

    public static Page<GroupResponse> toPageResponse(Page<GroupDto> groupDtos) {
        return PageUtil.pageToDto(groupDtos, GroupMapper::toResponse);
    }
}
