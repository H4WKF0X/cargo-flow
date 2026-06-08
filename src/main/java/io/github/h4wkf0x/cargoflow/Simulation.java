package io.github.h4wkf0x.cargoflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Simulation {
    private Queue<Order> orderBook = new PriorityQueue<>(
            Comparator.comparingLong(Order::pricePerUnit).reversed()
                    .thenComparingLong(Order::sequence)
    );

    private List<Producer> producers;
    private List<Consumer> consumers;
    private final int throughputPT;

    public Simulation(int supplyPT, int demandPT, int throughputPT) {
        this.throughputPT = throughputPT;
    }

    public void tick() {
        orderBook.removeIf(order -> order.pricePerUnit() > order.consumer().pricePerUnit());

        for (Consumer consumer : consumers) {
            orderBook.add(consumer.order());
        }

        // arbitrary rather than falsely principled
        Collections.shuffle(producers);

        List<Order> unfilled = new ArrayList<>();

        while (!orderBook.isEmpty()) {
            Order order = orderBook.poll();
            long remaining = order.amount();

            for (Producer producer : producers) {
                if (remaining == 0) {
                    break;
                }
                remaining -= producer.fill(order.pricePerUnit(), remaining);
            }

            if (remaining > 0) {
                unfilled.add(new Order(order.consumer(), order.pos(), order.pricePerUnit(), remaining, order.sequence()));
            }
        }

        orderBook.addAll(unfilled);

        System.out.println("unresolved orders: " + unfilled.size() + "\n");
    }
}
