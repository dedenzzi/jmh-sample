package com.perf.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@BenchmarkMode({ Mode.AverageTime })
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ListAdd  {
	int LOOP_COUNT=1000;
	List<Integer> arrayList;
	List<Integer> vector;
	List<Integer> linkedList;
	
	@GenerateMicroBenchmark
	public void addArrayList() {
		arrayList=new ArrayList<Integer>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			arrayList.add(loop);
		}
	}
	
	@GenerateMicroBenchmark
	public void addArrayListWithInitialSize() {
		arrayList=new ArrayList<Integer>(LOOP_COUNT);
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			arrayList.add(loop);
		}
	}
	
	@GenerateMicroBenchmark
	public void addVector() {
		vector=new Vector<Integer>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			vector.add(loop);
		}
	}
	
	@GenerateMicroBenchmark
	public void addLinkedList() {
		linkedList=new LinkedList<Integer>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			linkedList.add(loop);
		}
	}
	
}
