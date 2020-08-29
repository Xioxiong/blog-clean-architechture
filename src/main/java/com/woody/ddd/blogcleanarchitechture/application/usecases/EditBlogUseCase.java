package com.woody.ddd.blogcleanarchitechture.application.usecases;

import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.Blog;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.BlogRepository;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.BlogService;
import org.springframework.stereotype.Component;

@Component
public class EditBlogUseCase {
    private final BlogService blogService;

    public EditBlogUseCase(BlogRepository blogRepository) {
        this.blogService = new BlogService(blogRepository);
    }

    public Blog create(String title, String content) {
        return blogService.create(title, content);
    }
}
