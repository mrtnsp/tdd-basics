package de.neusta.tdd.mocks;

public class CustomerRegistrationService {

    // @Autowired || @Inject
    private CustomerRegistration customerRegistration;
    private CustomerValidator customerValidator;

    public RegistrationState register(Customer customer) {

	if (customerValidator.validate(customer)) {
	    return customerRegistration.register(customer);
	}
	return RegistrationState.UNREGISTERED;
    }

}
