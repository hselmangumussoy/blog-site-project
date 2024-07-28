package com.hsgumussoy.blogsiteproject.domain.auth.user.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.api.CollectionDto;
import org.springframework.util.StringUtils;

import java.util.List;

public class UserMapper {
    public static User toEntity(User user, UserDto dto) {
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setUserType(dto.getUserType());
        user.setActive(dto.getActive());
        return user;
    }

    public static UserDto toDto(User user) {
        return  UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .userName(user.getUserName())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .userType(user.getUserType())
                .active(user.getActive())
                .created(user.getCreated())
                .modified(user.getModified())
                .active(user.getActive())
                .build();
    }
}
