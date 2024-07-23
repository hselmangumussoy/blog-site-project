package com.hsgumussoy.blogsiteproject.domain.auth.user.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private  final UserRepository repository;
    @Override
    public UserDto save(UserDto dto) {
        return UserMapper.toDto(repository.save(UserMapper.toEntity(new User(), dto)));
    }
    @Override
    public UserDto getById(String id) {
        return UserMapper.toDto(repository.findById(id).get());
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return PageUtil.pageToDto(repository.findAll(pageable), UserMapper::toDto);
    }
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public UserDto update(String id, UserDto dto) {
        return null;
    }

    @Override
    public List<UserDto> getByIds(List<String> ids) {
        return repository.findAllById(ids).stream().map(UserMapper::toDto).toList();
    }
}
