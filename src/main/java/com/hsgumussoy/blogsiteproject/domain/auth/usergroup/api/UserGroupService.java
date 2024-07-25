package com.hsgumussoy.blogsiteproject.domain.auth.usergroup.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface UserGroupService {
    UserGroupDto save(UserGroupDto dto);

    UserGroupDto getById(String id);

    void delete(String id);

    UserGroupDto update(String id, UserGroupDto dto);

    Page<UserGroupDto> getAll(Pageable pageable);
}
