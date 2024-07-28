package com.hsgumussoy.blogsiteproject.domain.auth.user.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.Article;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.api.CollectionDto;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.impl.CollectionServiceImpl;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private  final UserRepository repository;
    private final CollectionServiceImpl collectionService;
    @Override
    public UserDto save(UserDto dto) {
        CollectionDto collectionDto = collectionService.getById(dto.getCollection().getId());
        return UserMapper.toDto(repository.save(UserMapper.toEntity(new User(), dto)), collectionDto);
    }
    @Override
    public UserDto getById(String id) {
        User user = repository.findById(id).orElseThrow();
        CollectionDto collectionDto = collectionService.getById(user.getCollectionId());

        return UserMapper.toDto(repository.findById(id).get(), collectionDto);
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return PageToDto(repository.findAll(pageable));
    }
    private Page<UserDto> PageToDto (Page<User> users){
        List<String> collectionIds = users.stream().map(User:: getCollectionId).toList();
        List<CollectionDto> collectionDtoList = collectionService.getByIds(collectionIds);

        return PageUtil.pageToDto(users, (user -> {
            CollectionDto collectionDto = collectionDtoList.stream().filter(collection -> collection.getId().equals(user.getCollectionId())).findFirst().orElseThrow();
            return UserMapper.toDto(user,collectionDto);
        }));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public UserDto update(String id, UserDto dto) {
        return null;
    }

    @Override
    public List<UserDto> getByIds(List<String> ids) {
        List<User> users = repository.findAllById(ids);
        List<CollectionDto>collectionDtoList = collectionService.getByIds(users.stream().map(User::getCollectionId).collect(Collectors.toList()));

        return repository.findAllById(ids).stream().map(user -> UserMapper.toDto(user, collectionDtoList)).toList();
    }
}
