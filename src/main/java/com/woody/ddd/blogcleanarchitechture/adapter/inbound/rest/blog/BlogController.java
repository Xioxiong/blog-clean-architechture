package com.woody.ddd.blogcleanarchitechture.adapter.inbound.rest.blog;

import com.woody.ddd.blogcleanarchitechture.application.usecases.BlogQueryUseCase;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.Blog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {
    private final BlogQueryUseCase blogQueryUseCase;

    public BlogController(BlogQueryUseCase blogQueryUseCase) {
        this.blogQueryUseCase = blogQueryUseCase;
    }

    @GetMapping("/{id}")
    public BlogResponse getBlog(@PathVariable String id) {
        Blog blog = blogQueryUseCase.getBLog(id);
        return BlogResponse.of(blog);
    }
}
