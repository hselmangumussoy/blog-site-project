package com.hsgumussoy.blogsiteproject.domain.platform.group.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupDto;
import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository repository;
    @Override
    public GroupDto getById(String id) {
        return repository.findById(id).map(GroupMapper::toDto).orElseThrow();
    }

    @Override
    public List<GroupDto> getByIds(List<String> ids) {
        return repository.findAllById(ids).stream().map(GroupMapper::toDto).toList();
    }

    @Override
    public Page<GroupDto> getAll(Pageable pageable) {
        return PageUtil.pageToDto(repository.findAll(pageable), GroupMapper::toDto);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public GroupDto update(String id, GroupDto dto) {
        return null;
    }

    @Override
    public GroupDto save(GroupDto dto) {
        return GroupMapper.toDto(repository.save(GroupMapper.toEntity(new Group(), dto)));
    }
}
