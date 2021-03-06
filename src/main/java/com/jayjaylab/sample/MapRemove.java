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
public class MapRemove {
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
	
    @Benchmark
    public void testLinkedHashMapRemove(State state, Blackhole blackhole) {
        
	Map<String, Integer> map = new LinkedHashMap<>();
	
        for(int i = state.startNumber; i < state.endNumber; i++) {
		map.put("1",1);	
            	map.remove("1");
        }
        blackhole.consume(map);
    }
    
    


}
