package com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence.loan;

import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface LoanApplicationMapper {
    Optional<LoanApplicationPO> findById(String applicationNumber);

    void update(LoanApplicationPO loanApplicationPO);

    void insert(LoanApplicationPO loanApplicationPO);
}
