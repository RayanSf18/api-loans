package com.rayan.dev.loans.domain;

import com.rayan.dev.loans.factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {

    @Nested
    class isIncomeEqualOrLowerThan {

        @Test
        public void shouldBeTrueWhenIncomeIsEqual() {
            var customer = CustomerFactory.build(5000.0);
            assertTrue(customer.isIncomeEqualOrLowerThan(5000.0));
        }

        @Test
        public void shouldBeTrueWhenIncomeIsLowerThan() {
            var customer = CustomerFactory.build(5000.0);
            assertTrue(customer.isIncomeEqualOrLowerThan(9000.0));
        }

        @Test
        public void shouldBeFalseWhenIncomeIsGreaterThanValue() {
            var customer = CustomerFactory.build(5000.0);
            assertTrue(customer.isIncomeEqualOrLowerThan(8000.0));
        }

    }

    @Nested
    class isIncomeEqualOrBiggerThan {

        @Test
        public void shouldBeTrueWhenIncomeIsEqual() {
            var customer = CustomerFactory.build(5000.0);
            assertTrue(customer.isIncomeEqualOrBiggerThan(5000.0));
        }

        @Test
        public void shouldBeTrueWhenIncomeIsBiggerThan() {
            var customer = CustomerFactory.build(5000.0);
            assertTrue(customer.isIncomeEqualOrBiggerThan(3000.0));
        }

        @Test
        public void shouldBeFalseWhenIncomeIsLowerThanValue() {
            var customer = CustomerFactory.build(5000.0);
            assertFalse(customer.isIncomeEqualOrBiggerThan(8000.0));
        }

    }

    @Nested
    class isIncomeBetween {

        @Test
        public void shouldBeTrueWhenIncomeIsBetween() {
            var customer = CustomerFactory.build(5000.0);
            assertTrue(customer.isIncomeBetween(3000.0, 8000.0));
        }

        @Test
        public void shouldBeTrueWhenIncomeIsEqualToMin() {
            var customer = CustomerFactory.build(5000.0);
            assertTrue(customer.isIncomeBetween(5000.0, 8000.0));
        }

        @Test
        public void shouldBeTrueWhenIncomeIsEqualToMax() {
            var customer = CustomerFactory.build(5000.0);
            assertTrue(customer.isIncomeBetween(3000.0, 5000.0));
        }

        @Test
        public void shouldBeFalseWhenIncomeIsNotBetween() {
            var customer = CustomerFactory.build(5000.0);
            assertFalse(customer.isIncomeBetween(3000.0, 4500.0));
        }
    }

    @Nested
    class isAgeLowerThan {

        @Test
        public void shouldBeTrueWhenAgeIsLowerThan() {
            var customer = CustomerFactory.build(25);
            assertTrue(customer.isAgeLowerThan(30));
        }

        @Test
        public void shouldBeFalseWhenAgeIsNotLowerThan() {
            var customer = CustomerFactory.build(25);
            assertFalse(customer.isAgeLowerThan(22));
        }

        @Test
        public void shouldBeFalseWhenAgeIsEqualToValue() {
            var customer = CustomerFactory.build(25);
            assertFalse(customer.isAgeLowerThan(25));
        }
    }

    @Nested
    class isFromLocation {

        @Test
        public void shouldBeTrueWhenLocationIsTheSame() {
            var customer = CustomerFactory.build("SP");
            assertTrue(customer.isFromLocation("SP"));
        }

        @Test
        public void shouldBeFalseWhenLocationIsNotTheSame() {
            var customer = CustomerFactory.build("SP");
            assertFalse(customer.isFromLocation("RJ"));
        }
    }
}
