package com.hsgumussoy.blogsiteproject.domain.platform.userrole.api;

import com.hsgumussoy.blogsiteproject.domain.platform.userrole.web.UserRoleRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.userrole.web.UserRoleResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class UserRoleMapper {
    public static UserRoleDto toDto(UserRoleRequest request) {
        return UserRoleDto.builder()
                .userId(request.getUserId())
                .roleId(request.getRoleId())
                .build();
    }

    public static UserRoleResponse toResponse(UserRoleDto dto) {
        return UserRoleResponse.builder()
                .userId(dto.getUserId())
                .roleId(dto.getRoleId())
                .created(dto.getCreated())
                .id(dto.getId())
                .modified(dto.getModified())
                .build();
    }

    public static Page<UserRoleResponse> toPageResponse(Page<UserRoleDto> dtos) {
        return PageUtil.pageToDto(dtos, UserRoleMapper::toResponse);
    }
}
