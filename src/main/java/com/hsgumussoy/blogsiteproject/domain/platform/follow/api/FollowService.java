package com.hsgumussoy.blogsiteproject.domain.platform.follow.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FollowService {
    void delete(String id);

    Page<FollowDto> getAll(Pageable pageable);

    FollowDto getById(String id);

    FollowDto save(FollowDto dto);
}
