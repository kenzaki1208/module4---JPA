package org.example.demo_jpa.exercise.ex1.repository;

import org.example.demo_jpa.exercise.ex1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
