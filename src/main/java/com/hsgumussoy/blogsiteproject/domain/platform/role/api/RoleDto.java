package com.hsgumussoy.blogsiteproject.domain.platform.role.api;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class RoleDto {
    private final String id;
    private final String name;
    private final Date modified;
    private final Date created;
}
