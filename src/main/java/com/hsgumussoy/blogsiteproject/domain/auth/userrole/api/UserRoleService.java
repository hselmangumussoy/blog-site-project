package com.hsgumussoy.blogsiteproject.domain.auth.userrole.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface UserRoleService {
    UserRoleDto save(UserRoleDto dto);

    UserRoleDto getById(String id);

    void delete(String id);

    UserRoleDto update(String id, UserRoleDto dto);

    Page<UserRoleDto> getAll(Pageable pageable);
}
