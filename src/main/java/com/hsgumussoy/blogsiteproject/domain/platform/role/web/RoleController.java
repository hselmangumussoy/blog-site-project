package com.hsgumussoy.blogsiteproject.domain.platform.role.web;


import com.hsgumussoy.blogsiteproject.domain.platform.article.api.ArticleMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.article.web.ArticleRequest;
import com.hsgumussoy.blogsiteproject.domain.platform.article.web.ArticleResponse;
import com.hsgumussoy.blogsiteproject.domain.platform.role.api.RoleMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.role.api.RoleService;
import com.hsgumussoy.blogsiteproject.library.rest.BaseController;
import com.hsgumussoy.blogsiteproject.library.rest.MetaResponse;
import com.hsgumussoy.blogsiteproject.library.rest.PageResponse;
import com.hsgumussoy.blogsiteproject.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("roles")
@RequiredArgsConstructor
public class RoleController extends BaseController {
    private final RoleService service;
    @PostMapping
    private Response<RoleResponse> save(@RequestBody RoleRequest request){
        return respond(RoleMapper.toResponse(service.save(RoleMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    private Response<RoleResponse> get(@PathVariable String id){
        return respond(RoleMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<RoleResponse>> getAll(Pageable pageable){
        return respond(RoleMapper.toPageResponse(service.getAll(pageable)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
    @PutMapping("/{id}")
    private Response<RoleResponse> update(@PathVariable String id , @RequestBody RoleRequest request){
        return respond(RoleMapper.toResponse(service.update(id , RoleMapper.toDto(request))));
    }

}
