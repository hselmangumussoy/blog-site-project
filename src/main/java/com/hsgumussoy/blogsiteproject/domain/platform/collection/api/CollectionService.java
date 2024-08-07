package com.hsgumussoy.blogsiteproject.domain.platform.collection.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CollectionService {
    CollectionDto save(CollectionDto dto);

    CollectionDto getById(String id);

    void delete(String id);

    CollectionDto update(String id, CollectionDto dto);

    Page<CollectionDto> getAll(Pageable pageable);

    void addArticle(CollectionDto dto);
}
