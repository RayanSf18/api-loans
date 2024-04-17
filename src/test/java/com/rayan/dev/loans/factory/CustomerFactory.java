package com.rayan.dev.loans.factory;

import com.rayan.dev.loans.domain.Customer;

public class CustomerFactory {

    public static Customer build() {
        return new Customer(25, "123.456.789-01", "Jose", 5000.0, "SP");
    }

    public static Customer build(Double income) {
        return new Customer(25, "123.456.789-01", "Jose", income, "SP");
    }

    public static Customer build(Integer age) {
        return new Customer(age, "123.456.789-01", "Jose", 5000.0, "SP");
    }

    public static Customer build(String location) {
        return new Customer(25, "123.456.789-01", "Jose", 5000.0, location);
    }
}
