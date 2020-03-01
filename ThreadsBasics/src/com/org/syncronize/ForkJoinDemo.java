package com.org.syncronize;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class Fibonacci extends RecursiveTask<List<Integer> > {
	final int n;
	List<Integer> resList;

	Fibonacci(int n, List<Integer> resList) {
		this.n = n;
		this.resList = resList;
	}

	protected List<Integer> compute() {
		List<Fibonacci> tasks = new ArrayList<>();
		if (n <= 1){
			 resList.add(n);
			 return resList;
		}
		Fibonacci f1 = new Fibonacci(n - 1,resList);
		f1.fork();
		tasks.add(f1);
		Fibonacci f2 = new Fibonacci(n - 2, resList);
		tasks.add(f2);
		addToList(f2.compute().get(0) + f1.join().get(0), tasks);
		return resList;
	}
	
	void addToList(Integer res, List<Fibonacci> task){
		resList.add(res);
	}

}

public class ForkJoinDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		List<Integer> resList = new ArrayList<Integer>();
		Fibonacci fib = new Fibonacci(6, resList);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ForkJoinTask<List<Integer>> res = forkJoinPool.submit(fib);
//		System.out.println(res.get().toString());
		System.out.println(fib.join());
	}

}
