package com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence;

import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.Blog;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.BlogRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MyBatisBlogRepository implements BlogRepository {
    private final BlogMapper BlogMapper;

    public MyBatisBlogRepository(com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence.BlogMapper blogMapper) {
        this.BlogMapper = blogMapper;
    }

    @Override
    public Optional<Blog> findById(String id) {
        return BlogMapper.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return new Blog("title", "content");
    }
}
