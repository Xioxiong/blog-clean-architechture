package com.woody.ddd.blogcleanarchitechture.application.usecases;

import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanApplication;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanApplicationRepository;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanApplicationService;
import org.springframework.stereotype.Component;

@Component
public class LoanApplicationQueryUseCase implements UseCase {
    private final LoanApplicationService loanApplicationService;

    public LoanApplicationQueryUseCase(LoanApplicationRepository repository) {
        this.loanApplicationService = new LoanApplicationService(repository);
    }

    public LoanApplication findLoadApplication(String applicationNumber) {
        return loanApplicationService.findByApplicationNumber(applicationNumber);
    }
}
