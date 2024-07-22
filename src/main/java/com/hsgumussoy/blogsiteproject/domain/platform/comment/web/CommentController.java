package com.hsgumussoy.blogsiteproject.domain.platform.comment.web;

import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryService;
import com.hsgumussoy.blogsiteproject.domain.platform.category.web.CategoryRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.category.web.CategoryResponse;
import com.hsgumussoy.blogsiteproject.domain.platform.comment.api.CommentMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.comment.api.CommentService;
import com.hsgumussoy.blogsiteproject.library.rest.BaseController;
import com.hsgumussoy.blogsiteproject.library.rest.MetaResponse;
import com.hsgumussoy.blogsiteproject.library.rest.PageResponse;
import com.hsgumussoy.blogsiteproject.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("comments")
@RequiredArgsConstructor
public class CommentController extends BaseController {
    private final CommentService service;

    @PostMapping
    private Response<CommentResponse> save(@RequestBody CommentRequest request){
        return respond(CommentMapper.toResponse(service.save(CommentMapper.toDto(request))));
    }
    @GetMapping("{/id}")
    private Response<CommentResponse> get(@PathVariable String id){
        return respond(CommentMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<CommentResponse>> getAll(Pageable pageable){
        return respond(CommentMapper.toPageResponse(service.getAll(pageable)));
    }
    @DeleteMapping("{/id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
}
