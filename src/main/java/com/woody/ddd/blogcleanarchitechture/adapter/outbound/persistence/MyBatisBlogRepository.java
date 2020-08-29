package com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence;

import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.Blog;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.BlogRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MyBatisBlogRepository implements BlogRepository {
    @Override
    public Optional<Blog> findById(String id) {
        return Optional.of(new Blog("title", "content"));
    }

    @Override
    public Blog save(Blog blog) {
        return new Blog("title", "content");
    }
}
