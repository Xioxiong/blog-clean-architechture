package com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence.loan;

import com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence.PersistenceObject;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanApplication;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoanApplicationPO implements PersistenceObject<LoanApplication> {
    private final String applicationNumber;
    private final String applicantInformation;
    private final String supplementalInformation;
    private final String status;
    private final int totalAmount;
    private final double dailyRate;
    private final String type;
    private final int numberOfPeriods;

    public static LoanApplicationPO of(LoanApplication loanApplication) {
        return new LoanApplicationPO(loanApplication.getApplicationNumber(),
            loanApplication.getApplicantInformation(),
            loanApplication.getSupplementalInformation(),
            loanApplication.getStatus(),
            loanApplication.getLoanDetail().getTotalAmount(),
            loanApplication.getLoanDetail().getDailyRate(),
            loanApplication.getLoanDetail().getType(),
            loanApplication.getLoanDetail().getNumberOfPeriods());
    }

    @Override
    public LoanApplication toDomainModel() {
        return new LoanApplication(this.applicationNumber,
            this.applicantInformation,
            this.supplementalInformation,
            new LoanDetail(this.totalAmount, this.dailyRate, this.type, this.numberOfPeriods),
            this.status);
    }
}
