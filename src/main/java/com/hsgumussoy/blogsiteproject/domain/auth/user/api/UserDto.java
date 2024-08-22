package com.hsgumussoy.blogsiteproject.domain.auth.user.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.impl.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class UserDto {
    private final String id;
    private final String userName;
    private final Date created;
    private final Date modified;
    private final String email;
    private final String password;
    private final String phoneNumber;
    private final UserType userType;
}
