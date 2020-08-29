package com.woody.ddd.blogcleanarchitechture.adapter.inbound.rest.blog;

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
}
