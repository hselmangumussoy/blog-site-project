package com.hsgumussoy.blogsiteproject.domain.platform.permissiongroup.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.permissiongroup.api.PermissionGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PermissionGroupServiceImpl implements PermissionGroupService {
    private final PermissionGroupRepository repository;
}
