package com.hsgumussoy.blogsiteproject.domain.platform.collection.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.impl.UserMapper;
import com.hsgumussoy.blogsiteproject.domain.auth.user.impl.UserServiceImpl;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.api.CollectionDto;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.api.CollectionService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectionServiceImpl implements CollectionService {
    private final CollectionRepository repository;

    @Override
    public CollectionDto save(CollectionDto dto) {
        return CollectionMapper.toDto(repository.save(CollectionMapper.toEntity(new Collection(), dto)));
    }

    @Override
    public CollectionDto getById(String id) {
        return CollectionMapper.toDto(repository.findById(id).get());
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public CollectionDto update(String id, CollectionDto dto) {
        return null;
    }

    @Override
    public Page<CollectionDto> getAll(Pageable pageable) {
        return PageUtil.pageToDto(repository.findAll(pageable), CollectionMapper::toDto);
    }
    public List<CollectionDto> getByIds(List<String> ids){
        return repository.findAllById(ids).stream().map(CollectionMapper::toDto).toList();
    }


}
