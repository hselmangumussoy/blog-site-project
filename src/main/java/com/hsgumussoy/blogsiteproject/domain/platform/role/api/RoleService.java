package com.hsgumussoy.blogsiteproject.domain.platform.role.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface RoleService {
    RoleDto getById(String roleId);

    List<RoleDto> getByIds(List<String> roleIds);

    Page<RoleDto> getAll(Pageable pageable);

    void delete(String id);

    RoleDto update(String id, RoleDto dto);

    RoleDto save(RoleDto dto);
}
