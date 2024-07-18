package com.hsgumussoy.blogsiteproject.library.rest;

import javax.print.attribute.standard.PageRanges;
import java.util.List;

public class ResponseBuilder {
    //Yanıt nesnelerini oluşturmak için yardımcı metotlar sağlar.
    //Listeler, sayfalar, tekil nesneler ve meta bilgiler için statik build metotları içerir.
    public ResponseBuilder() {
    }

    public static <T> Response<DataResponse<T>> build(List<T> items){
        return new Response<>(new DataResponse<>(items));
    }
    public static <T> Response<PageResponse>> build(Page<T> items) {
        return new Response<>(new PageResponse<>(items));
    }

    public static <T> Response<T> build(T item){ return new Response<>(item);}
    public static Response<MetaResponse> build(MetaResponse metaResponse){
        return new Response<>(metaResponse);
    }
}
