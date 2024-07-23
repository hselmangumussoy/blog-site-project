package com.hsgumussoy.blogsiteproject.domain.platform.permissionrole.api;

import com.hsgumussoy.blogsiteproject.domain.platform.permission.api.PermissionDto;
import com.hsgumussoy.blogsiteproject.domain.platform.role.api.RoleDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class PermissionRoleDto {private final String id;
    private final Date created;
    private final Date modified;
    private final PermissionDto permission;
    private final RoleDto role;
}
