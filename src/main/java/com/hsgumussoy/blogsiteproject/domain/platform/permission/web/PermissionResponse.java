package com.hsgumussoy.blogsiteproject.domain.platform.permission.web;

import com.hsgumussoy.blogsiteproject.domain.platform.permission.api.PermissionType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@RequiredArgsConstructor
@Builder
public class PermissionResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String name;
    private final String description;
    private final PermissionType permissionType;
}
