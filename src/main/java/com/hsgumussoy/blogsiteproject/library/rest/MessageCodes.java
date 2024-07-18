package com.hsgumussoy.blogsiteproject.library.rest;

import lombok.Getter;

@Getter
public enum MessageCodes {

    SUCCESS("200", "general.success");

    private final String code;
    private final String message;

    MessageCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
