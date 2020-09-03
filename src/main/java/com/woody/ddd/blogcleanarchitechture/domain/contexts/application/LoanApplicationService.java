package com.woody.ddd.blogcleanarchitechture.domain.contexts.application;

import com.woody.ddd.blogcleanarchitechture.domain.core.concepts.DomainService;

public class LoanApplicationService implements DomainService {
    private final LoanApplicationRepository repository;

    public LoanApplicationService(LoanApplicationRepository repository) {
        this.repository = repository;
    }

    public LoanApplication create(String applicationNumber, String applicant, Loan loan) {
        LoanApplication loanApplication = new LoanApplication(applicationNumber, applicant, loan);
        return repository.save(loanApplication);
    }
}
