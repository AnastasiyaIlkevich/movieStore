package com.movieStore.service;

import java.util.List;

public interface AbstractService<T, V, S> {

    List<T> getAll();

    T find(S string);

    void save(T model);

    T update(T model);

    void delete(V value);
}
