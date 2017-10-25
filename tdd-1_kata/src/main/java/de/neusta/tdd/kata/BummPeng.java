package de.neusta.tdd.kata;

public class BummPeng {

    private static final String PENG = "Peng";
    private static final String BUMM = "Bumm";

    public String say(int number) {

	if (number == 0) {
	    throw new IllegalArgumentException("number must be positive");
	}

	String result = "";

	if (isBumm(number)) {
	    result += BUMM;
	}

	if (isPeng(number)) {
	    result += PENG;
	}

	if (result.isEmpty()) {
	    result += String.valueOf(number);
	}

	return result;
    }

    private boolean isPeng(int number) {
	return number % 5 == 0;
    }

    private boolean isBumm(int number) {
	return number % 3 == 0;
    }

}
