package com.hsgumussoy.blogsiteproject.domain.platform.tag.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.tag.api.TagDto;
import com.hsgumussoy.blogsiteproject.domain.platform.tag.api.TagService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository repository;
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public TagDto save(TagDto dto) {
        return TagMapper.toDto(repository.save(TagMapper.toEntity(new Tag(),dto)));
    }

    @Override
    public TagDto getById(String id) {
        return repository.findById(id).map(TagMapper::toDto).orElseThrow();
    }

    @Override
    public Page<TagDto> getAll(Pageable pageable) {
        return PageUtil.pageToDto(repository.findAll(pageable), TagMapper::toDto);
    }

    @Override
    public TagDto update(TagDto dto, String id) {
        return null;
    }
}
