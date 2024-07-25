package com.hsgumussoy.blogsiteproject.domain.auth.usergroup.web;

import com.hsgumussoy.blogsiteproject.domain.auth.usergroup.api.UserGroupMapper;
import com.hsgumussoy.blogsiteproject.domain.auth.usergroup.api.UserGroupService;
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
public class UserGroupController extends BaseController {
    private final UserGroupService service;
    @PostMapping
    private Response<UserGroupResponse> save(@RequestBody UserGroupRequest request){
        return respond(UserGroupMapper.toResponse(service.save(UserGroupMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    private Response<UserGroupResponse> get(@PathVariable String id){
        return respond(UserGroupMapper.toResponse(service.getById(id)));
    }

    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }

    @PutMapping
    private Response<UserGroupResponse> update(@PathVariable String id, @RequestBody UserGroupRequest request){
        return respond(UserGroupMapper.toResponse(service.update(id, UserGroupMapper.toDto(request))));
    }

    @GetMapping
    private Response<PageResponse<UserGroupResponse>> getAll(Pageable pageable){
        return respond(UserGroupMapper.toPageResponse(service.getAll(pageable)));
    }

}
