package com.woody.ddd.blogcleanarchitechture.adapter.inbound.rest.blog;

import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.Blog;
import lombok.Data;

@Data
public class BlogResponse {
    private String id;
    private String title;
    private String content;

    public BlogResponse(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static BlogResponse of(Blog blog) {
        return new BlogResponse(blog.getId(), blog.getTitle(), blog.getContent());
    }
}
