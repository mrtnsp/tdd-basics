package de.neusta.tdd.mocks;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import de.neusta.tdd.mocks.adapter.LegacyRegistrationAdapter;

@RunWith(MockitoJUnitRunner.class)
public class LegacyServiceTest {

    @Mock
    private LegacyRegistrationAdapter adapter;

    @InjectMocks
    private LegacyService service;

    @Test
    public void testName() throws Exception {
	Customer customer = mock(Customer.class);
	when(adapter.register(customer))
		.thenReturn(RegistrationState.REGISTERED);

	service.register(customer);

	verify(adapter).register(customer);
    }
}
