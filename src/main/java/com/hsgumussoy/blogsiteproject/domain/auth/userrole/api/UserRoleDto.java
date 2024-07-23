package com.hsgumussoy.blogsiteproject.domain.auth.userrole.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.role.api.RoleDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class UserRoleDto {
    private final UserDto user;
    private final RoleDto role;
    private final Date created;
    private final Date modified;
    private final String id;
}