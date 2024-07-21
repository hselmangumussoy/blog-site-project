package com.hsgumussoy.blogsiteproject.domain.auth.user.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;

public class UserMapper {
    public static User toEntity(User user, UserDto dto) {
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }

    public static UserDto toDto(User user) {
        return  UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .userName(user.getUserName())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .created(user.getCreated())
                .modified(user.getModified())
                .build();
    }
}
