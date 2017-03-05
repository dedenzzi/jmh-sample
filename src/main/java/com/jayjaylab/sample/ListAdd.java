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

@Fork(1) 
@Warmup(iterations=5) 
@Measurement(iterations=5) 
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
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
    
    @Benchmark
    public void testArrayListAdd(State state, Blackhole blackhole) {
        
        List<Integer> intList = new ArrayList<>();
        for(int i = state.startNumber; i < state.endNumber; i++) {
            intList.add(i);
        }
        blackhole.consume(intList);
    }
        
    @Benchmark
    public void testLinkedListAdd(State state, Blackhole blackhole) {
        
        List<Integer> intList = new LinkedList<>();
        for(int i = state.startNumber; i < state.endNumber; i++) {
            intList.add(i);
        }
        blackhole.consume(intList);
    }
    
    @Benchmark
    public void testVectorAdd(State state, Blackhole blackhole) {
        
        List<Integer> intList = new Vector<>();
        for(int i = state.startNumber; i < state.endNumber; i++) {
            intList.add(i);
        }
        blackhole.consume(intList);
    }
    
    
    @Benchmark
    public void testArrayListget(State state, Blackhole blackhole) {
        
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        for(int i = state.startNumber; i < state.endNumber; i++) {
            intList.get(0);
        }
        blackhole.consume(intList);
    }
    
    @Benchmark
    public void testLinkedListget(State state, Blackhole blackhole) {
        
        List<Integer> intList = new LinkedList<>();
         intList.add(1);
        for(int i = state.startNumber; i < state.endNumber; i++) {
            intList.get(0);
        }
        blackhole.consume(intList);
    }
    
    @Benchmark
    public void testVectorget(State state, Blackhole blackhole) {
        
        List<Integer> intList = new Vector<>();
        intList.add(1);
        for(int i = state.startNumber; i < state.endNumber; i++) {
            intList.get(0);
        }
        blackhole.consume(intList);
    }
    
        
    
    @Benchmark
    public void testArrayListremove(State state, Blackhole blackhole) {
        
        List<Integer> intList = new ArrayList<>();
        
        for(int i = state.startNumber; i < state.endNumber; i++) {
            intList.add(1);
            intList.remove(0);
        }
        blackhole.consume(intList);
    }
    @Benchmark
    public void testLinkedListremove(State state, Blackhole blackhole) {
        
        List<Integer> intList = new LinkedList<>();
        
        for(int i = state.startNumber; i < state.endNumber; i++) {
            intList.add(1);
            intList.remove(0);
        }
        blackhole.consume(intList);
    }
    
    @Benchmark
    public void testVectorremove(State state, Blackhole blackhole) {
        
        List<Integer> intList = new Vector<>();
        for(int i = state.startNumber; i < state.endNumber; i++) {
            intList.add(1);
            intList.remove(0);
        }
        blackhole.consume(intList);
    }
    
    
    @Benchmark
    public void testHashMapAdd(State state, Blackhole blackhole) {
        
        Map<String, Integer> map = new HashMap<>();
		
        for(int i = state.startNumber; i < state.endNumber; i++) {
            map.put("1"+i,1);
        }
        blackhole.consume(map);
    }
    
    
    @Benchmark
    public void testHashTableAdd(State state, Blackhole blackhole) {

		Map<String, Integer> map = new Hashtable<>();
        
        for(int i = state.startNumber; i < state.endNumber; i++) {
            map.put("1"+i,1);
        }
        blackhole.consume(map);
    }
    
    
    @Benchmark
    public void testTreeMapAdd(State state, Blackhole blackhole) {
        
		Map<String, Integer> map = new TreeMap<>();
        
        for(int i = state.startNumber; i < state.endNumber; i++) {
            map.put("1"+i,1);
        }
        blackhole.consume(map);
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
    public void testHashMapRemove(State state, Blackhole blackhole) {
        
        Map<String, Integer> map = new HashMap<>();
	
        for(int i = state.startNumber; i < state.endNumber; i++) {
         	map.put("1",1);	
            	map.remove("1");
        }
        blackhole.consume(map);
    }
    
    
    @Benchmark
    public void testHashTableRemove(State state, Blackhole blackhole) {

	Map<String, Integer> map = new Hashtable<>();
       
        for(int i = state.startNumber; i < state.endNumber; i++) {
         	map.put("1",1);	
            	map.remove("1");
        }
        blackhole.consume(map);
    }
    
    
    @Benchmark
    public void testTreeMapRemove(State state, Blackhole blackhole) {
        
	Map<String, Integer> map = new TreeMap<>();
	
        for(int i = state.startNumber; i < state.endNumber; i++) {
		map.put("1",1);	
            	map.remove("1");
        }
        blackhole.consume(map);
    }
}
