package com.hsgumussoy.blogsiteproject.domain.platform.role.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.role.api.RoleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.role.api.RoleService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    @Override
    public RoleDto getById(String id) {
        return repository.findById(id).map(RoleMapper::toDto).orElseThrow();
    }

    @Override
    public List<RoleDto> getByIds(List<String> ids) {
        return repository.findAllById(ids).stream().map(RoleMapper::toDto).toList();
    }

    @Override
    public Page<RoleDto> getAll(Pageable pageable) {
        return PageUtil.pageToDto(repository.findAll(pageable), RoleMapper::toDto);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public RoleDto update(String id, RoleDto dto) {
        return null;
    }

    @Override
    public RoleDto save(RoleDto dto) {
        return RoleMapper.toDto(repository.save(RoleMapper.toEntity(new Role(), dto)));
    }
}
