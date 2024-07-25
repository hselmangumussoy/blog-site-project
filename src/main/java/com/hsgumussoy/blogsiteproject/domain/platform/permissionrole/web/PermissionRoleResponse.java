package com.hsgumussoy.blogsiteproject.domain.platform.permissionrole.web;

import com.hsgumussoy.blogsiteproject.domain.platform.permission.api.PermissionDto;
import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class PermissionRoleResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final PermissionDto permission;
    private final GroupDto role;
}
