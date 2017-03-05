package com.jayjaylab.sample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.Warmup;


@Fork(1) 
@Warmup(iterations=5) 
@Measurement(iterations=5) 
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ListAdd {

	
	@org.openjdk.jmh.annotations.State(Scope.Thread)
	public static class State {
		List<String> arrayListForSearch = new ArrayList<>();
		List<String> LinkedListForSearch = new LinkedList<>();

		@Setup(Level.Trial)
		public void setUp() {

			for (int i = 0; i < 100; i++) {
				arrayListForSearch.add("Hello");
			}
			for (int i = 0; i < 100; i++) {
				LinkedListForSearch.add("Hello");
			}
		}
	}

    @Benchmark
    public void addIntoArrayList() {

    	List<String> arrayList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			arrayList.add("Hello");
		}
        		
    }
    
    @Benchmark
    public void addIntoLinkedList() {

		List<String> linkedList = new LinkedList<>();
		for (int i = 0; i < 100; i++) {
			linkedList.add("Hello");
		}
        		
    }
    
    
    
    @Benchmark
    public void searchArrayList(State state) {

    	List<String> arrayList = state.arrayListForSearch;
    	for (int i = 0; i < 100; i++) {
    		arrayList.get(i);
		}
        		
    }
    
    @Benchmark
    public void searchLinkedList(State state) {

		List<String> linkedList = state.LinkedListForSearch;
		
		for (int i = 0; i < 100; i++) {
			linkedList.get(i);
		}
	

        		
    }
    
    @Benchmark
    public void deleteFromArrayList() {

		List<String> arrayList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			arrayList.remove(((100-i)/2));
		}
        		
    }
    @Benchmark
    public void deleteFromLinkedList() {

		List<String> linkedList = new LinkedList<>();
		for (int i = 0; i < 100; i++) {
			linkedList.remove(0);
		}
        		
    }

    
    

}
