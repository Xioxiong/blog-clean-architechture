package com.woody.ddd.blogcleanarchitechture.domain.contexts.application;

import com.woody.ddd.blogcleanarchitechture.domain.core.concepts.DomainService;

public class LoanApplicationService implements DomainService {
    private final LoanApplicationRepository repository;

    public LoanApplicationService(LoanApplicationRepository repository) {
        this.repository = repository;
    }

    public LoanApplication apply(String applicantInformation, String supplementalInformation, LoanDetail loanDetail) {
        LoanApplication loanApplication = new LoanApplication(applicantInformation, supplementalInformation, loanDetail);
        return repository.save(loanApplication);
    }

    public LoanApplication findByApplicationNumber(String applicationNumber) {
        return repository.findByApplicationNumber(applicationNumber)
            .orElseThrow(() -> new LoanApplicationNotFoundException("Application Number Not Found."));
    }

    public LoanApplication edit(String applicationNumber, String status) {
        LoanApplication loanApplication = repository.findByApplicationNumber(applicationNumber)
            .orElseThrow(() -> new LoanApplicationNotFoundException("Application Number Not Found."));
        if ("Approved".equals(status)) {
            loanApplication.approve();
        } else if ("Rejected".equals(status)) {
            loanApplication.reject();
        }
        return repository.save(loanApplication);
    }
}
