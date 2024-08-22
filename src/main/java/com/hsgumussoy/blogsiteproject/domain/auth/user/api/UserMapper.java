package com.hsgumussoy.blogsiteproject.domain.auth.user.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.web.UserRequest;
import com.hsgumussoy.blogsiteproject.domain.auth.user.web.UserResponse;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;


public class UserMapper {
    public UserMapper() {
    }

    public static UserDto toDto(UserRequest request) {
        return UserDto.builder()
                .userName(request.getUserName())
                .phoneNumber(request.getPhoneNumber())
                .password(request.getPassword())
                .email(request.getEmail())
                .userName(request.getUserName())
                .userType(request.getUserType())
                .build();

    }

    public static UserResponse toResponse(UserDto dto) {
        return UserResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .email(dto.getEmail())
                .userName(dto.getUserName())
                .modified(dto.getModified())
                .phoneNumber(dto.getPhoneNumber())
                .password(dto.getPassword())
                .userType(dto.getUserType())
                .build();
    }

    public static Page<UserResponse> toPageResponse(Page<UserDto> userDtos) {
        return PageUtil.pageToDto(userDtos, UserMapper::toResponse);
    }
}
