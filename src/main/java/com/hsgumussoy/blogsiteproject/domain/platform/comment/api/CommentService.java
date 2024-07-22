package com.hsgumussoy.blogsiteproject.domain.platform.comment.api;

import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    void delete(String id);

    Page<CommentDto> getAll(Pageable pageable);

    CommentDto getById(String id);

    CommentDto save(CommentDto dto);
}
