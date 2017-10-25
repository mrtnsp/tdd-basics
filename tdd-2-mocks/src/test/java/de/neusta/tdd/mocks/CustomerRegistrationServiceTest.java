package de.neusta.tdd.mocks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRegistrationServiceTest {

    @Mock
    private CustomerRegistration customerRegistration;

    @Mock
    private CustomerValidator customerValidator;

    @InjectMocks
    private CustomerRegistrationService service;

    @Test
    public void testRegisterInValidCustomer() throws Exception {

	Customer customer = mock(Customer.class);
	when(customerValidator.validate(customer)).thenReturn(false);

	assertThat(service.register(customer))
		.isEqualTo(RegistrationState.UNREGISTERED);

	verifyZeroInteractions(customerRegistration);

    }

    @Test
    public void testRegisterValidCustomer() throws Exception {

	Customer customer = mock(Customer.class);
	// when(customerValidator.validate(customer)).thenReturn(true);
	given(customerValidator.validate(customer)).willReturn(true);

	when(customerRegistration.register(customer))
		.thenReturn(RegistrationState.REGISTERED);

	assertThat(service.register(customer))
		.isEqualTo(RegistrationState.REGISTERED);

	verify(customerRegistration).register(customer);

	then(customerValidator).should().validate(customer);

    }

}
