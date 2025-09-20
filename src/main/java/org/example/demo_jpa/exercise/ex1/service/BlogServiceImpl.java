package org.example.demo_jpa.exercise.ex1.service;

import jakarta.transaction.Transactional;
import org.example.demo_jpa.exercise.ex1.model.Blog;
import org.example.demo_jpa.exercise.ex1.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{
    private final BlogRepository repo;

    public BlogServiceImpl(BlogRepository repo) {
        this.repo = repo;
    }


    @Override
    public List<Blog> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Blog> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return repo.save(blog);
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }
}
