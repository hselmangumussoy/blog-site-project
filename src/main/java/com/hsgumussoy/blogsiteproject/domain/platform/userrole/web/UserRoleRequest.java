package com.hsgumussoy.blogsiteproject.domain.platform.userrole.web;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRoleRequest {
    private String userId;
    private String roleId;
}
