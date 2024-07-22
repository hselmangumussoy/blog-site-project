package com.hsgumussoy.blogsiteproject.domain.platform.like.web;

import com.hsgumussoy.blogsiteproject.domain.platform.like.api.LikeMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.like.api.LikeService;
import com.hsgumussoy.blogsiteproject.library.rest.BaseController;
import com.hsgumussoy.blogsiteproject.library.rest.MetaResponse;
import com.hsgumussoy.blogsiteproject.library.rest.PageResponse;
import com.hsgumussoy.blogsiteproject.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("likes")
@RequiredArgsConstructor
public class LikeController extends BaseController {
    private final LikeService service;

    @PostMapping
    private Response<LikeResponse> save(@RequestBody LikeRequest request){
        return respond(LikeMapper.toResponse(service.save(LikeMapper.toDto(request))));
    }
    @GetMapping("{/id}")
    private Response<LikeResponse> get(@PathVariable String id){
        return respond(LikeMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<LikeResponse>> getAll(Pageable pageable){
        return respond(LikeMapper.toPageResponse(service.getAll(pageable)));
    }
    @DeleteMapping("{/id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
}
