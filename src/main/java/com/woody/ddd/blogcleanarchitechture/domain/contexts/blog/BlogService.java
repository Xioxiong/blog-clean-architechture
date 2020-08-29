package com.woody.ddd.blogcleanarchitechture.domain.contexts.blog;

import org.apache.ibatis.javassist.NotFoundException;

public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog findById(String id) {
        return blogRepository.findById(id).orElseThrow(() -> new BlogNotFoundException(""));
    }
}
