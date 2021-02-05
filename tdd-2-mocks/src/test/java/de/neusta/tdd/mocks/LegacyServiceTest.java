package de.neusta.tdd.mocks;

import de.neusta.tdd.mocks.adapter.LegacyRegistrationAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LegacyServiceTest {

    @Mock
    private LegacyRegistrationAdapter adapter;

    @InjectMocks
    private LegacyService service;

    @Test
    void testName() {
        final Customer customer = mock(Customer.class);
        when(adapter.register(customer))
                .thenReturn(RegistrationState.REGISTERED);

        service.register(customer);

        verify(adapter).register(customer);
    }
}
