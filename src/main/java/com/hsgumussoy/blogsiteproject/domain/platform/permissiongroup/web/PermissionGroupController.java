package com.hsgumussoy.blogsiteproject.domain.platform.permissiongroup.web;

import com.hsgumussoy.blogsiteproject.domain.platform.permissiongroup.api.PermissionGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("permissionroles")
public class PermissionGroupController {
    private final PermissionGroupService service;
}
