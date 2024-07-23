package com.hsgumussoy.blogsiteproject.domain.auth.userrole.web;

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
