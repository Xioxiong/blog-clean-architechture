package com.woody.ddd.blogcleanarchitechture.domain.contexts.blog;

import com.woody.ddd.blogcleanarchitechture.domain.core.concepts.ValueObject;
import lombok.Getter;

@Getter
public class BlogHistory implements ValueObject {
    private final String title;
    private final String content;

    public BlogHistory(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
