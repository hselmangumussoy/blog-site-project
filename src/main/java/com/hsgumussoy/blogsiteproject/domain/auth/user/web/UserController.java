package com.hsgumussoy.blogsiteproject.domain.auth.user.web;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserMapper;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.library.rest.BaseController;
import com.hsgumussoy.blogsiteproject.library.rest.MetaResponse;
import com.hsgumussoy.blogsiteproject.library.rest.PageResponse;
import com.hsgumussoy.blogsiteproject.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService service;

    @PostMapping
    private Response<UserResponse> save(@RequestBody UserRequest request){
        return respond(UserMapper.toResponse(service.save(UserMapper.toDto(request))));
    }
    @GetMapping("/{id}")
    private Response<UserResponse> get(@PathVariable String id){
        return respond(UserMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<UserResponse>> getAll(Pageable pageable){
        return respond(UserMapper.toPageResponse(service.getAll(pageable)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
    @PutMapping("/{id}")
    private Response<UserResponse> update(@PathVariable String id , @RequestBody UserRequest request){
        return respond(UserMapper.toResponse(service.update(id , UserMapper.toDto(request))));
    }
}
