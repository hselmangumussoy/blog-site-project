package com.hsgumussoy.blogsiteproject.domain.platform.article.web;

import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleService;
import com.hsgumussoy.blogsiteproject.library.rest.BaseController;
import com.hsgumussoy.blogsiteproject.library.rest.MetaResponse;
import com.hsgumussoy.blogsiteproject.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("articles")
@RequiredArgsConstructor
public class ArticleController extends BaseController {
    private final ArticleService service;

    @PostMapping
    private Response<ArticleResponse> save(@RequestBody ArticleRequest request){
        return respond(ArticleMapper.toResponse(service.save(ArticleMapper.toDto(request))));
    }

    @GetMapping("{/id}")
    private Response<ArticleResponse> get(@PathVariable String id){
        return respond(ArticleMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private List<ArticleResponse> getAll(@RequestBody ArticleRequest request){
        return ArticleMapper.toResponses(service.getAll(ArticleMapper.toDto(request)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
    @PutMapping("{/id}")
    private Response<ArticleResponse> update(@PathVariable String id , @RequestBody ArticleRequest request){
        return respond(ArticleMapper.toResponse(service.update(id , ArticleMapper.toDto(request))));
    }

}
