package com.rayan.dev.loans.domain;

import com.rayan.dev.loans.domain.exceptions.LoanNotAvailableException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class LoanTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Loan loan;

    @Nested
    class isPersonalLoanAvailable {

        @Test
        public void shouldBeAvailableWhenIncomeIsEqualOrLess3K() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertTrue(loan.isPersonalLoanAvailable());
        }

        @Test
        public void shouldBeAvailableWhen_IncomeIsBetween3kAnd5k_AndAgeIsLessThan30_AndLocationIsSP() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
            doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isPersonalLoanAvailable());
        }
    }

    @Nested
    class isGuaranteedLoanAvailable {

        @Test
        public void shouldBeAvailableWhenIncomeIsEqualOrLess3K() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertTrue(loan.isGuaranteeLoanAvailable());
        }

        @Test
        public void shouldBeAvailableWhen_IncomeIsBetween3kAnd5k_AndAgeIsLessThan30_AndLocationIsSP() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
            doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isGuaranteeLoanAvailable());
        }
    }

    @Nested
    class isConsignmentLoanAvailable {

        @Test
        public void shouldBeAvailableWhenIncomeIsEqualOrGreater5K() {
            doReturn(true).when(customer).isIncomeEqualOrBiggerThan(5000.0);

            assertTrue(loan.isConsignmentLoanAvailable());
        }

        @Test
        public void shouldNotBeAvailableWhenIncomeIsLower4K() {
            doReturn(false).when(customer).isIncomeEqualOrBiggerThan(5000.0);

            assertFalse(loan.isConsignmentLoanAvailable());
        }
    }

    @Nested
    class getPersonalLoanInterestRate {

        @Test
        public void shouldTheInterestRateBe3() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertEquals(4.0, loan.getPersonalLoanInterestRate());
        }

        @Test
        public void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertThrows(LoanNotAvailableException.class, () -> loan.getPersonalLoanInterestRate());
        }

    }

    @Nested
    class getGuaranteedLoanInterestRate {

        @Test
        public void shouldTheInterestRateBe3() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertEquals(3.0, loan.getGuaranteeLoanInterestRate());
        }

        @Test
        public void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertThrows(LoanNotAvailableException.class, () -> loan.getGuaranteeLoanInterestRate());
        }
    }

    @Nested
    class getConsignmentLoanInterestRate {

        @Test
        public void shouldTheInterestRateBe3() {
            doReturn(true).when(customer).isIncomeEqualOrBiggerThan(5000.0);

            assertEquals(2.0, loan.getConsignmentLoanInterestRate());
        }

        @Test
        public void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrBiggerThan(5000.0);

            assertThrows(LoanNotAvailableException.class, () -> loan.getConsignmentLoanInterestRate());
        }
    }
}
