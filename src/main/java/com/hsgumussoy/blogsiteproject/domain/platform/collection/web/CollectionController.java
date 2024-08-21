package com.hsgumussoy.blogsiteproject.domain.platform.collection.web;

import com.hsgumussoy.blogsiteproject.domain.platform.collection.api.CollectionMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.collection.api.CollectionService;
import com.hsgumussoy.blogsiteproject.library.rest.BaseController;
import com.hsgumussoy.blogsiteproject.library.rest.MetaResponse;
import com.hsgumussoy.blogsiteproject.library.rest.PageResponse;
import com.hsgumussoy.blogsiteproject.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("collections")
@RequiredArgsConstructor
public class CollectionController extends BaseController {
    private final CollectionService service;

    @PostMapping("/save")
    private Response<CollectionResponse> save(@RequestBody CollectionRequest request){
        return respond(CollectionMapper.toResponse(service.save(CollectionMapper.toDto(request))));
    }
    @GetMapping("/{id}")
    private Response<CollectionResponse> get(@PathVariable String id){
        return respond(CollectionMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<CollectionResponse>> getAll(Pageable pageable){
        return respond(CollectionMapper.toPageResponse(service.getAll(pageable)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
    @PutMapping("/{id}")
    private Response<CollectionResponse> update(@PathVariable String id , @RequestBody CollectionRequest request){
        return respond(CollectionMapper.toResponse(service.update(id , CollectionMapper.toDto(request))));
    }

    @PostMapping("/add-article-to-collection")
    private Response<CollectionResponse> addArticle(@RequestBody AddArticleToCollectionRequest request){
        service.addArticle(CollectionMapper.toDto(request));
        return new Response<>(MetaResponse.success());
    }
}
