package de.neusta.tdd.mocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerRegistrationServiceTest {

    @Mock
    private CustomerRegistration customerRegistration;

    @Mock
    private CustomerValidator customerValidator;

    @InjectMocks
    private CustomerRegistrationService service;

    @Test
    void testRegisterInValidCustomer() {

        final Customer customer = mock(Customer.class);
        when(customerValidator.validate(customer)).thenReturn(false);

        assertThat(service.register(customer))
                .isEqualTo(RegistrationState.UNREGISTERED);

        verifyNoInteractions(customerRegistration);
    }

    @Test
    void testRegisterValidCustomer() {

        final Customer customer = mock(Customer.class);
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
