package com.hsgumussoy.blogsiteproject.domain.platform.permission.api;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class PermissionDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String name;
    private final String description;
    private final PermissionType permissionType;
}
