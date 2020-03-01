package com.org.forEachItr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalInterfaceExample {
	
	public static boolean isPrime(int number){
		return number>1 && IntStream.range(2, number).noneMatch(index -> number%index==0);
	}
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList<>();
		for(int i=0; i <8;i++)
			list.add(i);
		
		System.out.println(list.stream().map(i -> i<4).collect(Collectors.toList()));
		System.out.println(list.stream().filter(i -> i<4).collect(Collectors.toList()));
		
		System.out.println(FunctionalInterfaceExample.isPrime(999999998));
		System.out.println(findSquareOfMaxOddBetween3To11(list));
		
		System.out.println(Stream.of("one", "two", "three", "four")
        .filter(e -> e.length() > 3)
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList()));
	}
	
	public static int findSquareOfMaxOddBetween3To11(List<Integer> numbers) {
		return numbers.stream().filter(FunctionalInterfaceExample::isOdd)
				.filter(FunctionalInterfaceExample::isGreaterThan3)
				.filter(FunctionalInterfaceExample::isLessThan11)
				.max(Comparator.naturalOrder())
				.map(i->i*i)
				.get();
	}
	
	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}
	
	public static boolean isGreaterThan3(int i){
		return i > 3;
	}
	
	public static boolean isLessThan11(int i){
		return i < 11;
	}

}
