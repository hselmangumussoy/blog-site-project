package com.hsgumussoy.blogsiteproject.domain.platform.role.api;

import java.util.List;

public interface RoleService {
    RoleDto getById(String roleId);

    List<RoleDto> getByIds(List<String> roleIds);
}
