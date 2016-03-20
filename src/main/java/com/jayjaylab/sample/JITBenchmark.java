package com.jayjaylab.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by jjkim on 2016. 3. 20..
 */
public class JITBenchmark {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" + JITBenchmark.class.getSimpleName() + ".*")
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @org.openjdk.jmh.annotations.State(Scope.Benchmark)
    public static class State {
        int a, b, c, d, e;

        @Warmup
        public void warmUp() {
            System.out.println("warmUp()");
            a = 0; b = 1; c = 2; d = 3; e = 5;
        }

        @TearDown
        public void teardown() {
            System.out.println("teardown()");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testUnnecessaryCode(State state, Blackhole blackhole) {
        int a, b, c, d, e;
        a = b = c = d = e = 0;

        for(int i = 0; i < 1000 * 1000; i++) {
            a = state.a;
        }
        for(int i = 0; i < 1000 * 1000; i++) {
            b = state.b;
        }
        for(int i = 0; i < 1000 * 1000; i++) {
            c = state.c;
        }
        for(int i = 0; i < 1000 * 1000; i++) {
            d = state.d;
        }
        for(int i = 0; i < 1000 * 1000; i++) {
            e = state.e;
        }

        blackhole.consume(a);
        blackhole.consume(b);
        blackhole.consume(c);
        blackhole.consume(d);
        blackhole.consume(e);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testOptimizedCode(State state, Blackhole blackhole) {
        int a, b, c, d, e;
        a = b = c = d = e = 0;

        a = state.a;
        b = state.b;
        c = state.c;
        d = state.d;
        e = state.e;

        blackhole.consume(a);
        blackhole.consume(b);
        blackhole.consume(c);
        blackhole.consume(d);
        blackhole.consume(e);
    }
}
