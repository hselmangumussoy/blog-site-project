package com.hsgumussoy.blogsiteproject.domain.auth.auth.web;

import com.hsgumussoy.blogsiteproject.domain.auth.auth.api.TokenDto;
import com.hsgumussoy.blogsiteproject.domain.auth.auth.impl.AuthMapper;
import com.hsgumussoy.blogsiteproject.domain.auth.auth.impl.AuthServiceImpl;
import com.hsgumussoy.blogsiteproject.domain.auth.user.impl.UserType;
import com.hsgumussoy.blogsiteproject.library.rest.BaseController;
import com.hsgumussoy.blogsiteproject.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auths")
@RequiredArgsConstructor
public class AuthController extends BaseController {
    private final AuthServiceImpl service;

    @PostMapping("register")
    public Response<TokenDto> register(@RequestBody RegisterRequest request){
        return respond(service.register(AuthMapper.toRegisterDto(request, UserType.USER)));
    }

    @PostMapping("login")
    public Response<TokenDto> login(@RequestBody LoginRequest request){
        return respond(service.login(AuthMapper.toLoginDto(request,UserType.USER)));
    }

    @PostMapping("admin-login")
    public Response<TokenDto> adminLogin(@RequestBody LoginRequest request){
        return respond(service.login(AuthMapper.toLoginDto(request,UserType.ADMIN)));
    }

}
