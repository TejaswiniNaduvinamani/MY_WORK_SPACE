package com.org.forEachItr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DifferentWayToCreateStream {
	
	public static void main(String[] args){
		Stream<Integer> stream = Stream.of(1,2,3,4,5);
		stream.forEach(System.out::println);
		// can't use the same stream for below code
		//stream.forEach(i -> System.out.println("Using predicate: " + i));
		
		Stream<Integer> stream1 = Stream.of(new Integer[]{1,2,3,4,5});
		stream1.forEach(i -> System.out.println("Using predicate: " + i));
		
		List<Integer> list = (Arrays.asList(5,6,7,8));
		list.stream().forEach(i -> System.out.println("Using List: "+ i));
		
		// Infinite stream will be created, stream will never be closed causes program to run unconditionally
//		Stream stream4 = Stream.generate(() -> {return new Date();});
//		stream4.forEach(System.out::println); 
		
		IntStream stream5 = "ABCD 12345_abcdefg".chars();
        stream5.forEach(p -> System.out.println("ASCII value using char: "+p));
        
        Stream<String> stream6 = Stream.of("A$B$C".split("\\$"));
        stream6.forEach(p -> System.out.println("Using String token:" +p));
        
        Stream<String> stream7 = Stream.generate(() -> {return "abc";}).limit(5);
        stream7.forEach(i -> System.out.println("Using generate :" + i));
        Stream<String> stream8 = Stream.iterate("abc", (i) -> i).limit(4);
        stream8.forEach(i -> System.out.println("Using iterate :" + i));
         
	}
	
	public <T,R> boolean dummy(Function<? super T, R> t){
		return true;
	}

}
