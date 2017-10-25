package de.neusta.tdd.mocks;

public class CustomerValidator {

    public boolean validate(Customer customer) {

	if (isEmptyOrNull(customer.getFirstname()) || isEmptyOrNull(customer.getLastname())) {
	    return false;
	}

	return true;
    }

    private boolean isEmptyOrNull(String string) {
	return string == null || string.isEmpty();
    }

}
