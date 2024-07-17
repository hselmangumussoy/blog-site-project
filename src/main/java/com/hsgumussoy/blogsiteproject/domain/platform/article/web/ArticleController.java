package com.hsgumussoy.blogsiteproject.domain.platform.article.web;

import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService service;
    private final ArticleMapper articleMapper;

    @PostMapping
    private ArticleResponse save(@RequestBody ArticleRequest request){
        return articleMapper.toResponse(service.save(articleMapper.toDto(request)));
    }
    @GetMapping
    private ArticleResponse get(@PathVariable String id){
        return articleMapper.toResponse(service.getById(id));
    }
    @PostMapping
    private List<ArticleResponse> getAll(@RequestBody ArticleRequest request){
        return articleMapper.toResponses(service.getAll(articleMapper.toDto(request)));
    }
    @PostMapping
    private void delete(@PathVariable String id){
        service.delete(id);
    }
    @PostMapping
    private ArticleResponse update(@PathVariable String id ,@RequestBody ArticleRequest request){
        return articleMapper.toResponse(service.update(id , articleMapper.toDto(request)));
    }

}
