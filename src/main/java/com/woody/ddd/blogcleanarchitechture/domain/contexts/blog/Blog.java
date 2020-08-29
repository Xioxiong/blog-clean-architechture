package com.woody.ddd.blogcleanarchitechture.domain.contexts.blog;

import com.woody.ddd.blogcleanarchitechture.domain.core.concepts.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Blog implements AggregateRoot {
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
