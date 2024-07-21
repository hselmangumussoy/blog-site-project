package com.hsgumussoy.blogsiteproject.library.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private T data;
    private MetaResponse meta;

    public Response(T data) {
        this.data = data;
    }

    public Response(T data, MetaResponse meta) {
        this.data = data;
        this.meta = MetaResponse.success();
    }
}
