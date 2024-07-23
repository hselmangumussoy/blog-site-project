package com.hsgumussoy.blogsiteproject.domain.platform.permissionrole.web;

import com.hsgumussoy.blogsiteproject.domain.platform.permission.api.PermissionService;
import com.hsgumussoy.blogsiteproject.domain.platform.permissionrole.api.PermissionRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("permissionroles")
public class PermissionRoleController {
    private final PermissionRoleService service;
}
