package com.springpractice.demo.transformers;

public interface Transformer<T1,T2> {
    T1 toModel (T2 object);
    T2 toDTO (T1 object);
}
