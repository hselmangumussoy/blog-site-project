package com.hsgumussoy.blogsiteproject.domain.platform.userrole.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {
    UserRoleDto save(UserRoleDto dto);

    UserRoleDto getById(String id);

    void delete(String id);

    UserRoleDto update(String id, UserRoleDto dto);

    Page<UserRoleDto> getAll(Pageable pageable);
}
