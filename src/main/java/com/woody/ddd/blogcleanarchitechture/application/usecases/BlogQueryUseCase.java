package com.woody.ddd.blogcleanarchitechture.application.usecases;

import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.Blog;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.BlogRepository;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.BlogService;
import org.springframework.stereotype.Component;

@Component
public class BlogQueryUseCase implements UseCase {
    private final BlogService blogService;

    public BlogQueryUseCase(BlogRepository blogRepository) {
        this.blogService = new BlogService(blogRepository);
    }

    public Blog getBLog(String id) {
        return blogService.findById(id);
    }
}
