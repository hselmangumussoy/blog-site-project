package com.hsgumussoy.blogsiteproject.domain.platform.permission.web;

import com.hsgumussoy.blogsiteproject.domain.platform.permission.api.PermissionType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PermissionRequest {
    private String name;
    private String description;
    private PermissionType permissionType;
}
