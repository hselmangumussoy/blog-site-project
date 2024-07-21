package com.hsgumussoy.blogsiteproject.domain.platform.role.web;

import com.hsgumussoy.blogsiteproject.domain.platform.role.impl.RoleName;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class RoleResponse {
    private final String id;
    private final RoleName name;
    private final Date modified;
    private final Date created;
}
