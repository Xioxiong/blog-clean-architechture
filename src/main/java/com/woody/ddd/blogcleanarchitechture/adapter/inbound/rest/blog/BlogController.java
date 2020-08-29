package com.woody.ddd.blogcleanarchitechture.adapter.inbound.rest.blog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @GetMapping("/{id}")
    public BlogResponse getBlog(@PathVariable String id) {
        return new BlogResponse(id, "title", "content");
    }
}
