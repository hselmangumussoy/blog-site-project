package com.hsgumussoy.blogsiteproject.domain.platform.permission.web;

import com.hsgumussoy.blogsiteproject.domain.platform.permission.api.PermissionMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.permission.api.PermissionService;
import com.hsgumussoy.blogsiteproject.library.rest.BaseController;
import com.hsgumussoy.blogsiteproject.library.rest.MetaResponse;
import com.hsgumussoy.blogsiteproject.library.rest.PageResponse;
import com.hsgumussoy.blogsiteproject.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("permissions")
@RequiredArgsConstructor
public class PermissionController extends BaseController {
    private final PermissionService service;

    @PostMapping
    private Response<PermissionResponse> save(@RequestBody PermissionRequest request){
        return respond(PermissionMapper.toResponse(service.save(PermissionMapper.toDto(request))));
    }
    @GetMapping("/{id}")
    private Response<PermissionResponse> get(@PathVariable String id ){
        return respond(PermissionMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<PermissionResponse>> getAll(Pageable pageable){
        return respond(PermissionMapper.toPageResponse(service.getAll((pageable))));
    }
    @PutMapping("/{id}")
    private Response<PermissionResponse> update(@RequestBody PermissionRequest request,@PathVariable String id ){
        return respond(PermissionMapper.toResponse(service.update(PermissionMapper.toDto(request),id)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }

}
