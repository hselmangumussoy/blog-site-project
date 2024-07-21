package com.hsgumussoy.blogsiteproject.library.rest;

public class Response<T> {
    private T data;
    private MetaResponse meta;

    public Response(T data) {
        this.data = data;
    }

    public Response(T data, MetaResponse meta) {
        this.data = data;
        this.meta = meta;
    }
}
