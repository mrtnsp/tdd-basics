# TDD 2 - Mocks #

Kundenticket: Als Veranstalter möchte ich, dass ein gültiger Kunde am CustomerRegistration angemeldet wird.

Ein Kunde gilt als gültig, wenn Vor- und Nachname gesetzt sind (Schritt2: ... und der volljährig ist)

* Anforderung:  Erstelle einen Service, der die CustomerRegistration aufruft
* Erstelle einen Validator, der das Format des Kunden überprüft  


## Zusatz ##

Gegeben sei ein LegacyService, der eine LegacyCustomerRegistration mittels einer statischen Methode aufruft.

### Idee ###

Kapsele den Inhaber der statischen Methode in einem Adapter und mocke den Adapter.
 
