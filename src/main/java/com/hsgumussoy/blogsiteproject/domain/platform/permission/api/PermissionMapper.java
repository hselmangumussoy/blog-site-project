package com.hsgumussoy.blogsiteproject.domain.platform.permission.api;

import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupDto;
import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.group.web.GroupResponse;
import com.hsgumussoy.blogsiteproject.domain.platform.permission.web.PermissionRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.permission.web.PermissionResponse;
import com.hsgumussoy.blogsiteproject.library.rest.PageResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class PermissionMapper {
    public static PermissionDto toDto(PermissionRequest request){
        return PermissionDto.builder()
                .name(request.getName())
                .description(request.getDescription())
                .permissionType(request.getPermissionType())
                .build();
    }
    public static PermissionResponse toResponse(PermissionDto dto){
        return PermissionResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .description(dto.getDescription())
                .modified(dto.getModified())
                .name(dto.getName())
                .permissionType(dto.getPermissionType())
                .build();
    }

    public static Page<PermissionResponse> toPageResponse(Page<PermissionDto> permissionDtos) {
        return PageUtil.pageToDto(permissionDtos, PermissionMapper::toResponse);
    }
}
