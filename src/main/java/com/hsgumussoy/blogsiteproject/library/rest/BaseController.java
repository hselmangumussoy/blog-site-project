package com.hsgumussoy.blogsiteproject.library.rest;

public class BaseController {
    public <T> Response<T> respond (T item){
        return ResponseBuilder.build(item);
    }
    public <T> Response<T> respond (T item){
        return ResponseBuilder.build(item);
    }
    protected Response<MetaResponse>respond(MetaResponse metaResponse){
        return ResponseBuilder.build(metaResponse);
    }
}
