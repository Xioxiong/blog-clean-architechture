package com.woody.ddd.blogcleanarchitechture.application.usecases;

import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanApplication;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanApplicationRepository;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanApplicationService;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanDetail;
import org.springframework.stereotype.Component;

@Component
public class LoanApplicationApplyUseCase implements UseCase {
    private final LoanApplicationService loanApplicationService;

    public LoanApplicationApplyUseCase(LoanApplicationRepository repository) {
        this.loanApplicationService = new LoanApplicationService(repository);
    }

    public LoanApplication create(String applicantInformation, String supplementalInformation, LoanDetail loanDetail) {
        return loanApplicationService.apply(applicantInformation, supplementalInformation, loanDetail);
    }
}
