package de.neusta.tdd.mocks.adapter;

import de.neusta.tdd.mocks.Customer;
import de.neusta.tdd.mocks.RegistrationState;
import de.neusta.tdd.veryold.LegacyCustomerRegistration;

public class LegacyRegistrationAdapter {

    public RegistrationState register(Customer customer) {
	return LegacyCustomerRegistration.register(customer);
    }
}
