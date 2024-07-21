package com.hsgumussoy.blogsiteproject.domain.auth.user.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto save(UserDto dto);
    UserDto getById(String id);

    Page<UserDto> getAll(Pageable pageable);

    void delete(String id);
    UserDto update(String id, UserDto dto);

    List<UserDto> getByIds(List<String> userIds);
}
