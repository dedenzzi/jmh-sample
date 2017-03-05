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
	private static int LOOP_COUNT=1000;
	
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
	public void addArrayList() {
		List<Integer> arrayList=new ArrayList<Integer>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			arrayList.add(loop);
		}
	}	

	@Benchmark
	public void addVector() {
		List<Integer> vector=new Vector<Integer>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			vector.add(loop);
		}
	}
	
	@Benchmark
	public void addLinkedList() {
		List<Integer> linkedList=new LinkedList<Integer>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			linkedList.add(loop);
		}
	}    

}
