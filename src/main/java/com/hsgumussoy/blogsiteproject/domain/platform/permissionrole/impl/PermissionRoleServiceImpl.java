package com.hsgumussoy.blogsiteproject.domain.platform.permissionrole.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.permissionrole.api.PermissionRoleService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PermissionRoleServiceImpl implements PermissionRoleService {
    private final PermissionRoleRepository repository;
}
