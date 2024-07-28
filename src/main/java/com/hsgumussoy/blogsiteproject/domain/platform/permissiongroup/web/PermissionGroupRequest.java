package com.hsgumussoy.blogsiteproject.domain.platform.permissiongroup.web;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PermissionGroupRequest {
    private String permissionId;
    private String roleId;
}
