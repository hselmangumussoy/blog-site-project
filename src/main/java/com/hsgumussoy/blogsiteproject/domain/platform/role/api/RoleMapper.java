package com.hsgumussoy.blogsiteproject.domain.platform.role.api;

import com.hsgumussoy.blogsiteproject.domain.platform.role.web.RoleRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.role.web.RoleResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class RoleMapper {
    public static RoleResponse toResponse(RoleDto dto) {
        return RoleResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .name(dto.getName())
                .build();
    }

    public static RoleDto toDto(RoleRequest request) {
        return RoleDto.builder().build();
                //.name(RoleName.ROLE_USER).build();
    }

    public static Page<RoleResponse> toPageResponse(Page<RoleDto> roleDtos) {
        return PageUtil.pageToDto(roleDtos, RoleMapper::toResponse);
    }
}
