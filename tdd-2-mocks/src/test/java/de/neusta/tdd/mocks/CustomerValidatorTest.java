package de.neusta.tdd.mocks;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerValidatorTest {

    @Test
    void testValidCustomer() {

        final Customer customer = new Customer("M", "S", LocalDate.now());
        assertThat(new CustomerValidator().validate(customer)).isTrue();

    }

    @Test
    void testInvalidCustomerNoFirstName() {

        assertThat(new CustomerValidator()
                .validate(new Customer("", "S", LocalDate.now()))).isFalse();
        assertThat(new CustomerValidator()
                .validate(new Customer(null, "S", LocalDate.now()))).isFalse();

    }

    @Test
    void testInvalidCustomerNoLastName() {

        assertThat(new CustomerValidator()
                .validate(new Customer("M", "", LocalDate.now()))).isFalse();
        assertThat(new CustomerValidator()
                .validate(new Customer("M", null, LocalDate.now()))).isFalse();

    }

}
