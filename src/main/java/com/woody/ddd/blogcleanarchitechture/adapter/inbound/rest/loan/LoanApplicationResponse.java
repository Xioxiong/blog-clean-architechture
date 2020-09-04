package com.woody.ddd.blogcleanarchitechture.adapter.inbound.rest.loan;

import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanApplication;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanDetail;
import lombok.Data;

@Data
public class LoanApplicationResponse {
    private String applicationNumber;
    private String applicantInformation;
    private LoanDetail loanDetail;
    private String supplementalInformation;
    private String status;

    public LoanApplicationResponse(String applicationNumber,
                                   String applicantInformation,
                                   LoanDetail loanDetail,
                                   String supplementalInformation,
                                   String status) {
        this.applicationNumber = applicationNumber;
        this.applicantInformation = applicantInformation;
        this.loanDetail = loanDetail;
        this.supplementalInformation = supplementalInformation;
        this.status = status;
    }

    public static LoanApplicationResponse of(LoanApplication loadApplication) {
        return new LoanApplicationResponse(loadApplication.getApplicationNumber(),
            loadApplication.getApplicantInformation(),
            loadApplication.getLoanDetail(),
            loadApplication.getSupplementalInformation(),
            loadApplication.getStatus());
    }
}
