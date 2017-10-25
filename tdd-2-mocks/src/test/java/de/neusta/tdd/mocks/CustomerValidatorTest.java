package de.neusta.tdd.mocks;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Test;

public class CustomerValidatorTest {

    @Test
    public void testValidCustomer() throws Exception {

	Customer customer = new Customer("M", "S", LocalDate.now());
	assertThat(new CustomerValidator().validate(customer)).isTrue();

    }

    @Test
    public void testInvalidCustomerNoFirstName() throws Exception {

	assertThat(new CustomerValidator()
		.validate(new Customer("", "S", LocalDate.now()))).isFalse();
	assertThat(new CustomerValidator()
		.validate(new Customer(null, "S", LocalDate.now()))).isFalse();

    }

    @Test
    public void testInvalidCustomerNoLastName() throws Exception {

	assertThat(new CustomerValidator()
		.validate(new Customer("M", "", LocalDate.now()))).isFalse();
	assertThat(new CustomerValidator()
		.validate(new Customer("M", null, LocalDate.now()))).isFalse();

    }

}
