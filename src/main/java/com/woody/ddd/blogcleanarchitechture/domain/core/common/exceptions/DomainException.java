package com.woody.ddd.blogcleanarchitechture.domain.core.common.exceptions;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
