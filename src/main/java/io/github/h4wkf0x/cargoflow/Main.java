package io.github.h4wkf0x.cargoflow;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(100, 120, 90);
        for (int i = 1; i <= 10; i++) {
            simulation.tick();
        }
    }
}
