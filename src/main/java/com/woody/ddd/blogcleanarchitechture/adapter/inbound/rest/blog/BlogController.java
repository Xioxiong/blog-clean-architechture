package com.woody.ddd.blogcleanarchitechture.adapter.inbound.rest.blog;

import com.woody.ddd.blogcleanarchitechture.application.usecases.BlogQueryUseCase;
import com.woody.ddd.blogcleanarchitechture.application.usecases.EditBlogUseCase;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.Blog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {
    private final BlogQueryUseCase blogQueryUseCase;
    private final EditBlogUseCase editBlogUseCase;

    public BlogController(BlogQueryUseCase blogQueryUseCase, EditBlogUseCase editBlogUseCase) {
        this.blogQueryUseCase = blogQueryUseCase;
        this.editBlogUseCase = editBlogUseCase;
    }

    @GetMapping("/{id}")
    public BlogResponse getBlog(@PathVariable String id) {
        Blog blog = blogQueryUseCase.getBLog(id);
        return BlogResponse.of(blog);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public BlogResponse createBlog(@RequestBody BlogRequest blogRequest) {
        Blog blog = editBlogUseCase.create(blogRequest.getTitle(), blogRequest.getContent());
        return BlogResponse.of(blog);
    }
}
