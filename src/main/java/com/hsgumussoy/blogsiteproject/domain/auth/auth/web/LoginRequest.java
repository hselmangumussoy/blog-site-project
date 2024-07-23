package com.hsgumussoy.blogsiteproject.domain.auth.auth.web;

public record LoginRequest (
        String email,
        String password
) {
}
