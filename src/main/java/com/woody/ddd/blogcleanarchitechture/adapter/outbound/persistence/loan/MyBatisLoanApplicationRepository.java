package com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence.loan;

import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanApplication;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanApplicationRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MyBatisLoanApplicationRepository implements LoanApplicationRepository {
    private final LoanApplicationMapper loanApplicationMapper;

    public MyBatisLoanApplicationRepository(LoanApplicationMapper loanApplicationMapper) {
        this.loanApplicationMapper = loanApplicationMapper;
    }

    @Override
    public LoanApplication save(LoanApplication loanApplication) {
        LoanApplicationPO po = LoanApplicationPO.of(loanApplication);

        Optional<LoanApplicationPO> existingLoanApplication = loanApplicationMapper.findById(po.getApplicationNumber());

        if (existingLoanApplication.isPresent()) {
            loanApplicationMapper.update(po);
        } else {
            loanApplicationMapper.insert(po);
        }

        return loanApplication;
    }

    @Override
    public Optional<LoanApplication> findByApplicationNumber(String applicationNumber) {
        return Optional.empty();
    }
}
