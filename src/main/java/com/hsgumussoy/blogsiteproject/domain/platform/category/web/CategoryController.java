package com.hsgumussoy.blogsiteproject.domain.platform.category.web;

import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.article.web.ArticleRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.article.web.ArticleResponse;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.category.api.CategoryService;
import com.hsgumussoy.blogsiteproject.domain.platform.category.impl.Category;
import com.hsgumussoy.blogsiteproject.library.rest.BaseController;
import com.hsgumussoy.blogsiteproject.library.rest.MetaResponse;
import com.hsgumussoy.blogsiteproject.library.rest.PageResponse;
import com.hsgumussoy.blogsiteproject.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController extends BaseController {
    private final CategoryService service;

    @PostMapping
    private Response<CategoryResponse> save(@RequestBody CategoryRequest request){
        return respond(CategoryMapper.toResponse(service.save(CategoryMapper.toDto(request))));
    }
    @GetMapping("{/id}")
    private Response<CategoryResponse> get(@PathVariable String id){
        return respond(CategoryMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<CategoryResponse>> getAll(Pageable pageable){
        return respond(CategoryMapper.toPageResponse(service.getAll(pageable)));
    }
    @DeleteMapping("{/id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
    @PutMapping("{/id}")
    private Response<CategoryResponse> update(@PathVariable String id , @RequestBody CategoryRequest request){
        return respond(CategoryMapper.toResponse(service.update(id , CategoryMapper.toDto(request))));
    }
}
