package de.neusta.tdd;

public class RingBuffer<T> {
    private final int size;
    private int count;
    private T element;

    public RingBuffer(final int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }

    public int count() {
        return count;
    }

    public void add(final T element) {
        count++;
        this.element = element;
    }

    public T take() {
        return element;
    }
}
