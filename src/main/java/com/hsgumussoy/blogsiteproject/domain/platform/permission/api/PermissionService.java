package com.hsgumussoy.blogsiteproject.domain.platform.permission.api;

import com.hsgumussoy.blogsiteproject.domain.platform.permission.web.PermissionRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PermissionService {
    PermissionDto save(PermissionDto dto);
    PermissionDto getById(String permissionId);
    Page<PermissionDto> getAll(Pageable pageable);
    void delete(String id);
    PermissionDto update(PermissionDto dto, String id);


}
