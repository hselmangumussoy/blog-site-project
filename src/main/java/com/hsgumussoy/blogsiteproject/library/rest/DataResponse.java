package com.hsgumussoy.blogsiteproject.library.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse <T>{
    // Bir liste yanıtını sarmalar.
    private List<T> items = List.of();


}
