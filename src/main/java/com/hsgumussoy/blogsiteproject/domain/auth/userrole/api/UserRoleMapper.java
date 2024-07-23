package com.hsgumussoy.blogsiteproject.domain.auth.userrole.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.userrole.web.UserRoleRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.role.api.RoleDto;
import com.hsgumussoy.blogsiteproject.domain.auth.userrole.web.UserRoleResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class UserRoleMapper {
    public static UserRoleDto toDto(UserRoleRequest request) {
        return UserRoleDto.builder()
                .user(UserDto.builder().id(request.getUserId()).build())
                .role(RoleDto.builder().id(request.getRoleId()).build())
                .build();
    }

    public static UserRoleResponse toResponse(UserRoleDto dto) {
        return UserRoleResponse.builder()
                .user(dto.getUser())
                .role(dto.getRole())
                .created(dto.getCreated())
                .id(dto.getId())
                .modified(dto.getModified())
                .build();
    }

    public static Page<UserRoleResponse> toPageResponse(Page<UserRoleDto> dtos) {
        return PageUtil.pageToDto(dtos, UserRoleMapper::toResponse);
    }
}
