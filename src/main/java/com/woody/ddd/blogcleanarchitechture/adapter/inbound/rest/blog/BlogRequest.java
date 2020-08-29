package com.woody.ddd.blogcleanarchitechture.adapter.inbound.rest.blog;

import lombok.Data;

@Data
public class BlogRequest {
    private String title;
    private String content;
}
