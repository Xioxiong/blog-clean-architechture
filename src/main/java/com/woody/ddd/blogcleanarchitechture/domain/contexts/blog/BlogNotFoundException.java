package com.woody.ddd.blogcleanarchitechture.domain.contexts.blog;

import com.woody.ddd.blogcleanarchitechture.domain.core.common.exceptions.DomainException;

public class BlogNotFoundException extends DomainException {
    public BlogNotFoundException(String message) {
        super(message);
    }
}
