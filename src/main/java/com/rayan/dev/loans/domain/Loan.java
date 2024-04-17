package com.rayan.dev.loans.domain;

import com.rayan.dev.loans.domain.exceptions.LoanNotAvailableException;

public class Loan {

    private final Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAvailable() {
        return basicLoanAvailable();
    }

    public boolean isConsignmentLoanAvailable() {
        return customer.isIncomeEqualOrBiggerThan(5000.0);
    }

    public boolean isGuaranteeLoanAvailable() {
        return basicLoanAvailable();
    }

    public double getPersonalLoanInterestRate() {
        if (isPersonalLoanAvailable()) {
            return 4.0;
        }

        throw new LoanNotAvailableException();
    }

    public double getConsignmentLoanInterestRate() {
        if (isConsignmentLoanAvailable()) {
            return 2.0;
        }

        throw new LoanNotAvailableException();
    }

    public double getGuaranteeLoanInterestRate() {
        if (isGuaranteeLoanAvailable()) {
            return 3.0;
        }

        throw new LoanNotAvailableException();
    }


    private boolean basicLoanAvailable() {

        if (customer.isIncomeEqualOrLowerThan(3000.0)) {
            return true;
        }

        return customer.isIncomeBetween(3000.0, 5000.0)
                && customer.isAgeLowerThan(30)
                && customer.isFromLocation("SP");
    }
}
