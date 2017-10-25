
package de.neusta.tdd.veryold;

import de.neusta.tdd.mocks.Customer;
import de.neusta.tdd.mocks.RegistrationState;

public class LegacyCustomerRegistration {

    public static RegistrationState register(Customer customer) {
	System.out.println("bla");
	return RegistrationState.REGISTERED;
    }

}
