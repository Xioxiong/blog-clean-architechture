package com.woody.ddd.blogcleanarchitechture.domain.contexts.application;

import com.woody.ddd.blogcleanarchitechture.domain.core.common.exceptions.DomainException;

public class LoanApplicationNotFoundException extends DomainException {
    public LoanApplicationNotFoundException(String message) {
        super(message);
    }
}
