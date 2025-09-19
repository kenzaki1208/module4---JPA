package org.example.demo_jpa.practice.p1.service;

import java.util.List;

public interface IGenerateService<T> {
    List<T> findAll();
    void save(T t);
    T findById(long id);
    void remove(long id);
}
