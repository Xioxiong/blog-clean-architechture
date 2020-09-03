package com.woody.ddd.blogcleanarchitechture.domain.contexts.application;

import com.woody.ddd.blogcleanarchitechture.domain.core.concepts.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoanApplication implements AggregateRoot {
    private final String applicationNumber;
    private final String applicant;
    private final Loan loan;
}
