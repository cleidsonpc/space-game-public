package org.cleidson.service;

public interface ServiceInterface<T> {
    T get();

    T create(T entity);

    T update(T entity);
}
