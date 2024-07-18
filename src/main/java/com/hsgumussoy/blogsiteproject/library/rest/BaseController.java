package com.hsgumussoy.blogsiteproject.library.rest;

import org.apache.coyote.Response;



public class BaseController {
    // Controller sınıfları için temel yanıt işleme işlevlerini sağlar.
    /*Farklı türdeki yanıtlar (liste, sayfa veya tekil nesne) için respond metotları sunar.
Yanıt oluşturma işlemi için ResponseBuilder sınıfını kullanır.*/
    public <T> Response <DataResponse><T>> respond(List<T> items){
        ResponseBuilder.build(items);
    }
    public <T> Response<PageResponse>
}
