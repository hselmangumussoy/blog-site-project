package com.hsgumussoy.blogsiteproject.domain.platform.like.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface LikeService {

    LikeDto save(LikeDto dto);

    LikeDto getById(String id);

    Page<LikeDto> getAll(Pageable pageable);

    void delete(String id);
}
