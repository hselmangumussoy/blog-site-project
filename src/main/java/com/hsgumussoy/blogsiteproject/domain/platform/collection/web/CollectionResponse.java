package com.hsgumussoy.blogsiteproject.domain.platform.collection.web;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Setter
@Getter
@Builder
public class CollectionResponse {
    private final String id;
    private final String name;
    private final Date created;
    private final Date modified;
    private final String userId;
}
