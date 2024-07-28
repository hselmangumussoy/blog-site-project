package com.hsgumussoy.blogsiteproject.domain.auth.usergroup.web;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGroupRequest {
    private String userId;
    private String groupId;
}
