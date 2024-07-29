package com.hsgumussoy.blogsiteproject.domain.platform.tag.web;

import com.hsgumussoy.blogsiteproject.domain.platform.tag.api.TagMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.tag.api.TagService;
import com.hsgumussoy.blogsiteproject.library.rest.BaseController;
import com.hsgumussoy.blogsiteproject.library.rest.MetaResponse;
import com.hsgumussoy.blogsiteproject.library.rest.PageResponse;
import com.hsgumussoy.blogsiteproject.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("tags")
public class TagController extends BaseController {
    private final TagService service;

    @PostMapping
    private Response<TagResponse> save(@RequestBody TagRequest request){
        return respond(TagMapper.toResponse(service.save(TagMapper.toDto(request))));
    }
    @GetMapping("/{id}")
    private Response<TagResponse> get(@PathVariable String id ){
        return respond(TagMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<TagResponse>> getAll(Pageable pageable){
        return respond(TagMapper.toPageResponse(service.getAll((pageable))));
    }
    @PutMapping("/{id}")
    private Response<TagResponse> update(@RequestBody TagRequest request,@PathVariable String id ){
        return respond(TagMapper.toResponse(service.update(TagMapper.toDto(request),id)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
}
