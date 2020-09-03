package com.woody.ddd.blogcleanarchitechture.domain.contexts.application;

import com.woody.ddd.blogcleanarchitechture.domain.core.concepts.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Loan implements ValueObject {
    private final int totalAmount;
    private final double dailyRate;
    private final String type;
    private final int numberOfPeriods;
}
