package com.woody.ddd.blogcleanarchitechture.domain.contexts.blog;

import com.woody.ddd.blogcleanarchitechture.domain.core.concepts.DomainService;

public class BlogService implements DomainService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog findById(String id) {
        return blogRepository.findById(id).orElseThrow(() -> new BlogNotFoundException(""));
    }

    public Blog create(String title, String content) {
        return blogRepository.save(new Blog(title, content));
    }
}
