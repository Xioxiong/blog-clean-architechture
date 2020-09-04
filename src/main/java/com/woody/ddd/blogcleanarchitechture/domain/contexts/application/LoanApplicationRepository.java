package com.woody.ddd.blogcleanarchitechture.domain.contexts.application;

import java.util.Optional;

public interface LoanApplicationRepository {
    LoanApplication save(LoanApplication loanApplication);

    Optional<LoanApplication> findByApplicationNumber(String applicationNumber);
}
