package com.hsgumussoy.blogsiteproject.domain.platform.tag.api;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
public class TagDto {
    private final String name;
    private final String id;
    private final Date created;
    private final Date modified;
}
