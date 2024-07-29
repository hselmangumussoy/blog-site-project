package com.hsgumussoy.blogsiteproject.domain.platform.tag.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    void delete(String id);

    TagDto save(TagDto dto);

    TagDto getById(String id);

    Page<TagDto> getAll(Pageable pageable);

    TagDto update(TagDto dto, String id);
    List<TagDto> getByIds(List<String> tagIds);
}
