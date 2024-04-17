package com.rayan.dev.loans.controller;

import com.rayan.dev.loans.domain.dto.CustomerLoanRequest;
import com.rayan.dev.loans.domain.dto.CustomerLoanResponse;
import com.rayan.dev.loans.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/customer-loans")
    public ResponseEntity<CustomerLoanResponse> getAvailableLoanTypes(@RequestBody @Valid CustomerLoanRequest loanRequest) {
        var loanResponse = loanService.checkLoanAvailability(loanRequest);
        return ResponseEntity.ok(loanResponse);
    }
}
