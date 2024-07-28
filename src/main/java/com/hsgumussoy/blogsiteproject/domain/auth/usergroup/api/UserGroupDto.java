package com.hsgumussoy.blogsiteproject.domain.auth.usergroup.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class UserGroupDto {
    private final UserDto user;
    private final GroupDto group;
    private final Date created;
    private final Date modified;
    private final String id;
}
