package com.hsgumussoy.blogsiteproject.library.rest;

import java.util.List;

public class ResponseBuilder {
    private ResponseBuilder() {
    }
    public static <T> Response<T> build(T item){
        return new Response<>(item);
    }

    public static <T> Response<DataResponse<T>> build(List<T> items){
        return new Response<>(new DataResponse<>(items));
    }
    private static <T> Response<MetaResponse> build(MetaResponse metaResponse){
        return new Response<>(metaResponse);
    }

}
