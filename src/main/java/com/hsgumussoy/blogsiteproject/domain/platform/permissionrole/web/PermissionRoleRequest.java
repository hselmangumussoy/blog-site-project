package com.hsgumussoy.blogsiteproject.domain.platform.permissionrole.web;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PermissionRoleRequest {
    private String permissionId;
    private String roleId;
}
