package de.neusta.tdd.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BummPengTest {

    private static final String BUMM = "Bumm";
    private static final String BUMM_PENG = "BummPeng";
    private static final String PENG = "Peng";
    private BummPeng bummPeng = new BummPeng();

    @Test
    public void testSayOne() {
        assertThat(bummPeng.say(1)).isEqualTo("1");
    }

    @Test
    public void testSayTwo() {
        assertThat(bummPeng.say(2)).isEqualTo("2");
    }

    @Test
    public void testSayFour() {
        assertThat(bummPeng.say(4)).isEqualTo("4");
    }

    @Test
    public void testSayBumm() {
        assertThat(bummPeng.say(3)).isEqualTo(BUMM);
        assertThat(bummPeng.say(6)).isEqualTo(BUMM);
    }

    @Test
    public void testPeng() {
        assertThat(bummPeng.say(5)).isEqualTo(PENG);
        assertThat(bummPeng.say(10)).isEqualTo(PENG);
    }

    @Test
    public void testSayBummPeng() {
        assertThat(bummPeng.say(15)).isEqualTo(BUMM_PENG);
        assertThat(bummPeng.say(30)).isEqualTo(BUMM_PENG);
    }

    @Test
    public void testSayZeroWithJunitAssert() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> bummPeng.say(0));
    }

    @Test
    public void testSayZeroWithTryCatch() {
        try {
            bummPeng.say(0);
            fail("exception expected");
        } catch (final Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e.getMessage()).isEqualTo("number must be positive");
        }
    }

    @Test
    public void testSayZeroWithAssertJ() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> bummPeng.say(0))
                .withMessage("number must be positive");
    }

}
