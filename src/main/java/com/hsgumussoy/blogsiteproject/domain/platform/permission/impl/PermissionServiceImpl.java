package com.hsgumussoy.blogsiteproject.domain.platform.permission.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.permission.api.PermissionDto;
import com.hsgumussoy.blogsiteproject.domain.platform.permission.api.PermissionService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository repository;
    @Override
    public PermissionDto save(PermissionDto dto) {
        return PermissionMapper.toDto(repository.save(PermissionMapper.toEntity(new Permission(), dto)));
    }

    @Override
    public PermissionDto getById(String permissionId) {
        //repository.findById(permissionId).map(PermissionMapper::toDto);
        return PermissionMapper.toDto(repository.findById(permissionId).orElseThrow());

    }

    @Override
    public Page<PermissionDto> getAll(Pageable pageable) {
        return PageUtil.pageToDto(repository.findAll(pageable), PermissionMapper::toDto);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public PermissionDto update(PermissionDto dto, String id) {
        return null;
    }
}
