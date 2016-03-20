package com.jayjaylab.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


public class StreamBenchmark {
    @org.openjdk.jmh.annotations.State(Scope.Thread)
    public static class State {
        int startNumber;
        int endNumber;

        @Setup(Level.Trial)
        public void setUp() {
            startNumber = 0;
            endNumber = 10000;
        }

        @TearDown(Level.Trial)
        public void tearDown() {
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void testSummingByForLoop(State state, Blackhole blackhole) {
        long sum = 0l;
        for(int i = state.startNumber; i < state.endNumber; i++) {
            sum += i;
        }
        blackhole.consume(sum);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void testSummingByStream(State state, Blackhole blackhole) {
        blackhole.consume(
                IntStream.range(state.startNumber, state.endNumber).sum());
    }
}
