package de.neusta.tdd.mocks;

import de.neusta.tdd.mocks.adapter.LegacyRegistrationAdapter;

public class LegacyService {

    private LegacyRegistrationAdapter legacyRegistrationAdapter;

    public RegistrationState register(Customer customer) {

	return legacyRegistrationAdapter.register(customer);

    }
}
