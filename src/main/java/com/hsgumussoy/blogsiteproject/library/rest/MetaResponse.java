package com.hsgumussoy.blogsiteproject.library.rest;

import com.hsgumussoy.blogsiteproject.library.enums.MessageCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MetaResponse {
    private String code;
    private String description;

    public static MetaResponse of(String code, String description){
        return new MetaResponse(code,description);
    }
    public static MetaResponse success(){
        return new MetaResponse(MessageCodes.SUCCESS.getCode(), "Success");
    }
}
