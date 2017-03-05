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
}
