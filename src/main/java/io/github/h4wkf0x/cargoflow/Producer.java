package io.github.h4wkf0x.cargoflow;

public class Producer {
    private final Position position;
    private long productionPerTick;

    private long operatingCostPerTick;
    private long costPerUnit;

    private long balance;
    private long stockpile;

    private long floor;

    public Producer(Position pos, int productionPerTick) {
        this.position = pos;
        this.productionPerTick = productionPerTick;
    }

    public long fill(long price, long amount) {
        if (price < floor) {
            return 0;
        }

        long filled = Math.min(amount, stockpile);
        stockpile -= filled;
        balance += filled * price;

        return filled;
    }

    public long floor() {
        return floor;
    }

    public Position position() {
        return position;
    }
}
