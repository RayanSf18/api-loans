package com.rayan.dev.loans.domain.dto;

import java.util.List;

public record CustomerLoanResponse(

        String customer,
        List<LoanResponse> loans
) {
}
