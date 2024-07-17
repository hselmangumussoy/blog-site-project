package com.hsgumussoy.blogsiteproject.domain.auth.user.api;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class UserDto {
    private final String id;
}
