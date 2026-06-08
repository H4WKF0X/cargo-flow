package io.github.h4wkf0x.cargoflow;

public class Consumer {
    private final Position position;

    private long pricePerUnit;
    private final long incomePerTick;

    private long balance;

    public Consumer(Position pos, long incomePerTick) {
        this.position = pos;
        this.pricePerUnit = 10L;
        this.incomePerTick = incomePerTick;
    }

    public Order order() {
        balance += incomePerTick;
        long amount = balance / pricePerUnit;
        balance -= amount * pricePerUnit;

        return new Order(this, this.position, this.pricePerUnit, amount);
    }

    public Position position() {
        return position;
    }

    public long pricePerUnit() {
        return pricePerUnit;
    }
}
