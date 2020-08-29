package com.woody.ddd.blogcleanarchitechture.domain.contexts.blog;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Blog {
    private final String id;
    private String title;
    private String content;

    public Blog(String title, String content) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
    }

    public void saveDraft(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
