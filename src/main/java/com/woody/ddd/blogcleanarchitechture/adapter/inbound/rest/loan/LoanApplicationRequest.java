package com.woody.ddd.blogcleanarchitechture.adapter.inbound.rest.loan;

import lombok.Data;

@Data
public class LoanApplicationRequest {
    private String applicantInformation;
    private String supplementalInformation;
    private int totalAmount;
    private double dailyRate;
    private String type;
    private int numberOfPeriods;
}
