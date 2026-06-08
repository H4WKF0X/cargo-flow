package io.github.h4wkf0x.cargoflow;

public record Order(Consumer consumer, Position pos, long pricePerUnit, long amount, long sequence) {
    private static long nextSequence = 0;

    public Order(Consumer consumer, Position pos, long pricePerUnit, long amount) {
        this(consumer, pos, pricePerUnit, amount, nextSequence++);
    }
}
