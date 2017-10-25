package de.neusta.tdd.mocks;

import java.time.LocalDate;

public class Customer {

    private final String firstname;
    private final String lastname;
    private final LocalDate birthday;

    public Customer(String firstname, String lastname, LocalDate birthday) {
	this.firstname = firstname;
	this.lastname = lastname;
	this.birthday = birthday;
    }

    public String getFirstname() {
	return firstname;
    }

    public String getLastname() {
	return lastname;
    }

    public LocalDate getBirthday() {
	return birthday;
    }
}
