package com.hsgumussoy.blogsiteproject.library.utils;
@FunctionalInterface
public interface Callable<T,R> {
    T call(R r);
}
