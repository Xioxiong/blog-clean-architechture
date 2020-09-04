package com.woody.ddd.blogcleanarchitechture.adapter.inbound.rest.loan;

import com.woody.ddd.blogcleanarchitechture.application.usecases.LoanApplicationApplyUseCase;
import com.woody.ddd.blogcleanarchitechture.application.usecases.LoanApplicationQueryUseCase;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanApplication;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.application.LoanDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan/application")
public class LoanApplicationController {
    private final LoanApplicationQueryUseCase queryUseCase;
    private final LoanApplicationApplyUseCase applyUseCase;

    public LoanApplicationController(LoanApplicationQueryUseCase queryUseCase, LoanApplicationApplyUseCase applyUseCase) {
        this.queryUseCase = queryUseCase;
        this.applyUseCase = applyUseCase;
    }

    @GetMapping("/{id}")
    public LoanApplicationResponse get(@PathVariable String id) {
        LoanApplication loadApplication = queryUseCase.findLoadApplication(id);
        return LoanApplicationResponse.of(loadApplication);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public LoanApplicationResponse create(@RequestBody LoanApplicationRequest request) {
        LoanDetail loanDetail = new LoanDetail(request.getTotalAmount(), request.getDailyRate(), request.getType(), request.getNumberOfPeriods());
        LoanApplication loanApplication = applyUseCase.create(request.getApplicantInformation(), request.getSupplementalInformation(), loanDetail);
        return LoanApplicationResponse.of(loanApplication);
    }
}
