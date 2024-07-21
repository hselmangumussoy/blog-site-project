package com.hsgumussoy.blogsiteproject.domain.auth.user.api;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto save(UserDto dto);
    UserDto getById(String id);

    List<UserDto> getAll();

    void delete(String id);
    UserDto update(String id, UserDto dto);
}
