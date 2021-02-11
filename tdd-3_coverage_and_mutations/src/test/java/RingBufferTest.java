import de.neusta.tdd.RingBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://ccd-school.de/en/coding-dojo/classes-katas/circular-buffer/
 */
class RingBufferTest {

    @Test
    void size() {
        assertThat(new RingBuffer<String>(3).size()).isEqualTo(3);
    }

    @Test
    void anotherSize() {
        assertThat(new RingBuffer<String>(4).size()).isEqualTo(4);
    }

    @Test
    @DisplayName("empty buffer has count 0")
    void count() {
        final RingBuffer<String> ringBuffer = new RingBuffer<>(4);
        assertThat(ringBuffer.size()).isEqualTo(4);
        assertThat(ringBuffer.count()).isZero();
    }

    @Test
    @DisplayName("adding an element increases count by one")
    void countWithAdd() {
        final RingBuffer<String> ringBuffer = new RingBuffer<>(4);
        assertThat(ringBuffer.size()).isEqualTo(4);
        assertThat(ringBuffer.count()).isZero();
        ringBuffer.add("a");
        assertThat(ringBuffer.count()).isEqualTo(1);
    }

    @Test
    @DisplayName("adding an element allows taking it")
    void addAndTakeAnElementAdd() {
        final RingBuffer<String> ringBuffer = new RingBuffer<>(4);
        assertThat(ringBuffer.size()).isEqualTo(4);
        ringBuffer.add("a");
        assertThat(ringBuffer.take()).isEqualTo("a");
    }

    @Test
    @DisplayName("adding another element allows taking it")
    void addAndTakeAnotherElementAdd() {
        final RingBuffer<Integer> ringBuffer = new RingBuffer<>(4);
        assertThat(ringBuffer.size()).isEqualTo(4);
        ringBuffer.add(23);
        assertThat(ringBuffer.take()).isEqualTo(23);
    }

// TBC ...
}
