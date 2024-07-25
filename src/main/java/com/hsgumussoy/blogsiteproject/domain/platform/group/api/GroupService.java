package com.hsgumussoy.blogsiteproject.domain.platform.group.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface GroupService {
    GroupDto getById(String roleId);

    List<GroupDto> getByIds(List<String> roleIds);

    Page<GroupDto> getAll(Pageable pageable);

    void delete(String id);

    GroupDto update(String id, GroupDto dto);

    GroupDto save(GroupDto dto);
}
