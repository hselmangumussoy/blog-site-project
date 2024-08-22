package com.hsgumussoy.blogsiteproject.domain.platform.collection.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
@Builder
public class CollectionDto {
    private final String id;
    private final String name;
    private final Date created;
    private final Date modified;
    private final UserDto user;

    private final List<String> articleId;// collection controller için
}
