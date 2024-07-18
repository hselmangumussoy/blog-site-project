package com.hsgumussoy.blogsiteproject.library.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MetaResponse {
    //Yanıtın meta bilgilerini içerir.
    private String code;
    private String description;

    public static MetaResponse of(String code , String description){
        return new MetaResponse(code, description);
    }

    public static MetaResponse success(){
        return new MetaResponse(MessageCodes.SUCCESS.getCode() , "Success");
    }
}
