package com.hsgumussoy.blogsiteproject.domain.platform.collection.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.impl.UserServiceImpl;
import com.hsgumussoy.blogsiteproject.domain.platform.article.impl.articlecategory.ArticleCategoryRepository;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.api.CollectionDto;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.api.CollectionService;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.impl.articlecollection.ArticleCollectionRepository;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollectionServiceImpl implements CollectionService {
    private final CollectionRepository repository;
    private final UserServiceImpl userService;
    private final ArticleCollectionRepository articleCollectionRepository;

    @Override
    public CollectionDto save(CollectionDto dto) {
        UserDto userDto = userService.getById(dto.getUser().getId());
        return CollectionMapper.toDto(repository.save(CollectionMapper.toEntity(new Collection(), dto)), userDto);
    }

    @Override
    public CollectionDto getById(String id) {
        Collection collection = repository.findById(id).orElseThrow();
        UserDto userDto = userService.getById(collection.getUserId());

        return CollectionMapper.toDto(repository.findById(id).get(), userDto);
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
        return PageToDto(repository.findAll(pageable));
    }

    @Override
    public void addArticle(CollectionDto dto) {
        //collection varsa makale ekle , yoksa default olanı koy.
    }

    private Page<CollectionDto> PageToDto(Page<Collection> collections) {
        List<String> userIds = collections.stream().map(Collection::getUserId).collect(Collectors.toList());

        List<UserDto> userDtoList = userService.getByIds(userIds);

        return PageUtil.pageToDto(collections,
                    (collection -> {
                        UserDto userDto = userDtoList.stream()
                                .filter(user-> user.getId().equals(collection.getUserId()))
                                .findFirst()
                                .orElseThrow();

                        return CollectionMapper.toDto(collection, userDto);
                    }));
    }

    public List<CollectionDto> getByIds(List<String> ids){
        List<Collection> collections = repository.findAllById(ids);
        List<UserDto> userDtoList = userService.getByIds(collections.stream().map(Collection::getUserId).collect(Collectors.toList()));

        return repository.findAllById(ids).stream().map(collection-> CollectionMapper.toDto(collection, userDtoList)).toList();
    }


}
