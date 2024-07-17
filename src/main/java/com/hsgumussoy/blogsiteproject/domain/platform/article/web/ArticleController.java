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

    @PostMapping
    private ArticleResponse save(@RequestBody ArticleRequest request){
        return ArticleMapper.toResponse(service.save(ArticleMapper.toDto(request)));
    }
    @GetMapping("{/id}")
    private ArticleResponse get(@PathVariable String id){
        return ArticleMapper.toResponse(service.getById(id));
    }
    @GetMapping
    private List<ArticleResponse> getAll(@RequestBody ArticleRequest request){
        return ArticleMapper.toResponses(service.getAll(ArticleMapper.toDto(request)));
    }
    @DeleteMapping("{/id}")
    private void delete(@PathVariable String id){
        service.delete(id);
    }
    @PutMapping("{/id}")
    private ArticleResponse update(@PathVariable String id , @RequestBody ArticleRequest request){
        return ArticleMapper.toResponse(service.update(id , ArticleMapper.toDto(request)));
    }

}
