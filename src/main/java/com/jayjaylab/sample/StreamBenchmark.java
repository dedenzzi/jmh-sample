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
            System.out.println("setUp()");
            startNumber = 0;
            endNumber = 10000;
        }

        @TearDown(Level.Trial)
        public void tearDown() {
            System.out.println("tearDown()");
        }
    }
//JMH 를 사용하여 Java SE 에 있는 List 를 구현한 클래스들의 추가/조회/삭제 기능의 성능을 비교하시오.
//JMH 를 사용하여 Java SE 에 있는 Map을 구현한 클래스들의 추가/조회/삭제 기능의 성능을 비교하시오.
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void testSummingByForLoop(State state, Blackhole blackhole) {
        
        List<Integer> intList = new ArrayList<>();
        for(int i = state.startNumber; i < state.endNumber; i++) {
            intList.add(i);
        }
        blackhole.consume(intList);
    }
}
