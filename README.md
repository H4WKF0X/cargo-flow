# supply-chain-sim

A tick-based logistics and supply chain simulation written in Java. Producers generate goods, consumers need them, and transport moves them around. The goal is to start simple and see what interesting dynamics emerge as complexity grows.

## Status

Early development. The foundation is being built — nothing runs yet.

## Building & Running

Requires Java 21. You don't need to install Gradle — the wrapper handles it.

```sh
./gradlew build   # compile and run tests
./gradlew run     # run the simulation
./gradlew test    # run tests only
```

On Windows, use `gradlew.bat` instead of `./gradlew`.

## License

MIT — see [LICENSE](LICENSE) for details.