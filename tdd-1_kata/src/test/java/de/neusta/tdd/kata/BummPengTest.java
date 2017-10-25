package de.neusta.tdd.kata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.neusta.tdd.kata.BummPeng;

public class BummPengTest {

    private static final String BUMM = "Bumm";
    private static final String BUMM_PENG = "BummPeng";
    private static final String PENG = "Peng";
    private BummPeng bummPeng = new BummPeng();

    @Test
    public void testSayOne() throws Exception {
	assertEquals("1", bummPeng.say(1));
    }

    @Test
    public void testSayTwo() throws Exception {
	assertEquals("2", bummPeng.say(2));
    }

    @Test
    public void testSayFour() throws Exception {
	assertEquals("4", bummPeng.say(4));
    }

    @Test
    public void testSayBumm() throws Exception {
	assertEquals(BUMM, bummPeng.say(3));
	assertEquals(BUMM, bummPeng.say(6));
    }

    @Test
    public void testPeng() throws Exception {
	assertThat(bummPeng.say(5)).isEqualTo(PENG);
	assertThat(bummPeng.say(10)).isEqualTo(PENG);
    }

    @Test
    public void testSayBummPeng() throws Exception {
	assertThat(bummPeng.say(15)).isEqualTo(BUMM_PENG);
	assertThat(bummPeng.say(30)).isEqualTo(BUMM_PENG);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSayZeroWithJunit() throws Exception {
	bummPeng.say(0);
    }

    @Test
    public void testSayZeroWithTryCatch() throws Exception {
	try {
	    bummPeng.say(0);
	    fail("exception expected");
	} catch (Exception e) {
	    assertThat(e).isInstanceOf(IllegalArgumentException.class);
	    assertThat(e.getMessage()).isEqualTo("number must be positive");
	}
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testSayZeroWithJunitRule() throws Exception {
	expectedException.expect(IllegalArgumentException.class);
	expectedException.expectMessage("number must be positive");

	bummPeng.say(0);
    }

    @Test
    public void testSayZeroWithAssertJ() throws Exception {

	assertThatExceptionOfType(IllegalArgumentException.class)
		.isThrownBy(() -> bummPeng.say(0))
		.withMessage("number must be positive");

    }

}
