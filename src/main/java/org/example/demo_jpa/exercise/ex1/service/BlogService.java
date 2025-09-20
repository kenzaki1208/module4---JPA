package org.example.demo_jpa.exercise.ex1.service;

import org.example.demo_jpa.exercise.ex1.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAll();
    Optional<Blog> findById(long id);
    Blog save(Blog blog);
    void deleteById(long id);
}
