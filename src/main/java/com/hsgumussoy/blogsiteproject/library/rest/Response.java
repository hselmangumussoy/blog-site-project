package com.hsgumussoy.blogsiteproject.library.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    // Genel yanıt yapısını sağlar.
    private T data;
    private MetaResponse meta;

    public Response(MetaResponse meta){
        this.meta = meta;
    }
    public Response(T data){
        this.data = data;
        this.meta = MetaResponse.success();
    }
}

