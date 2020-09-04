package com.woody.ddd.blogcleanarchitechture.domain.contexts.application;

import com.woody.ddd.blogcleanarchitechture.domain.core.concepts.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class LoanApplication implements AggregateRoot {
    private final String applicationNumber;
    private final String applicantInformation;
    private final String supplementalInformation;
    private final LoanDetail loanDetail;
    private String status = "Submitted";

    public LoanApplication(String applicantInformation, String supplementalInformation, LoanDetail loanDetail) {
        this.applicationNumber = UUID.randomUUID().toString();
        this.applicantInformation = applicantInformation;
        this.supplementalInformation = supplementalInformation;
        this.loanDetail = loanDetail;
    }

    public void approve() {
        this.status = "Approved";
    }

    public void reject() {
        this.status = "Rejected";
    }
}
