package com.hsgumussoy.blogsiteproject.domain.platform.tag.web;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
public class TagResponse {
    private final String name;
    private final String id;
    private final Date created;
    private final Date modified;
}
