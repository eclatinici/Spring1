package com.springpractice.demo.services;

import java.util.List;

public interface CrudService<T> {
    void save(T entity);

    List<T> getAll();

    T getById(Long id);

    void delete(Long id);
}
