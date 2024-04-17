package com.rayan.dev.loans.domain.dto;

import com.rayan.dev.loans.domain.enums.LoanType;

public record LoanResponse(

        LoanType type,
        Double interestRate

) {
}
