package com.hsgumussoy.blogsiteproject.domain.platform.comment.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    void delete(String id);

    Page<CommentDto> getAll(Pageable pageable);

    CommentDto getById(String id);

    CommentDto save(CommentDto dto);
}
