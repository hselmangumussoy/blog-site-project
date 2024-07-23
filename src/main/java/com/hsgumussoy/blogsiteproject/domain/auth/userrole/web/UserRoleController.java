package com.hsgumussoy.blogsiteproject.domain.auth.userrole.web;

import com.hsgumussoy.blogsiteproject.domain.auth.userrole.api.UserRoleMapper;
import com.hsgumussoy.blogsiteproject.domain.auth.userrole.api.UserRoleService;
import com.hsgumussoy.blogsiteproject.library.rest.BaseController;
import com.hsgumussoy.blogsiteproject.library.rest.MetaResponse;
import com.hsgumussoy.blogsiteproject.library.rest.PageResponse;
import com.hsgumussoy.blogsiteproject.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userroles")
@RequiredArgsConstructor
public class UserRoleController extends BaseController {
    private final UserRoleService service;
    @PostMapping
    private Response<UserRoleResponse> save(@RequestBody UserRoleRequest request){
        return respond(UserRoleMapper.toResponse(service.save(UserRoleMapper.toDto(request))));
    }

    @GetMapping("{/id}")
    private Response<UserRoleResponse> get(@PathVariable String id){
        return respond(UserRoleMapper.toResponse(service.getById(id)));
    }

    @DeleteMapping("{/id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }

    @PutMapping
    private Response<UserRoleResponse> update(@PathVariable String id, @RequestBody UserRoleRequest request){
        return respond(UserRoleMapper.toResponse(service.update(id, UserRoleMapper.toDto(request))));
    }

    @GetMapping
    private Response<PageResponse<UserRoleResponse>> getAll(Pageable pageable){
        return respond(UserRoleMapper.toPageResponse(service.getAll(pageable)));
    }

}
