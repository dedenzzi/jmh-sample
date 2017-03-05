package com.jayjaylab.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;

@Fork(1) 
@Warmup(iterations=5) 
@Measurement(iterations=5) 
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MapGet {
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
    
    
	
    @Benchmark
    public void testHashMapGet(State state, Blackhole blackhole) {
        
        Map<String, Integer> map = new HashMap<>();
	map.put("1",1);	
        for(int i = state.startNumber; i < state.endNumber; i++) {
            map.get("1");
        }
        blackhole.consume(map);
    }
    
    
    @Benchmark
    public void testHashTableGet(State state, Blackhole blackhole) {

	Map<String, Integer> map = new Hashtable<>();
        map.put("1",1);	
        for(int i = state.startNumber; i < state.endNumber; i++) {
            map.get("1");
        }
        blackhole.consume(map);
    }
    
    
    @Benchmark
    public void testTreeMapGet(State state, Blackhole blackhole) {
        
	Map<String, Integer> map = new TreeMap<>();
	map.put("1",1);	
        for(int i = state.startNumber; i < state.endNumber; i++) {
            map.get("1");
        }
        blackhole.consume(map);
    }
	
    @Benchmark
    public void testLinkedHashMapGet(State state, Blackhole blackhole) {
        
	Map<String, Integer> map = new LinkedHashMap<>();
	map.put("1",1);	
        for(int i = state.startNumber; i < state.endNumber; i++) {
            map.get("1");
        }
        blackhole.consume(map);
    }
	
    
    


}
