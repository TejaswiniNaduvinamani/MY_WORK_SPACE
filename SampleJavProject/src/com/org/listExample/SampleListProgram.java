package com.org.listExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SampleListProgram {

	public static void main(String[] args) {

		List<Integer> ints = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++)
			ints.add(random.nextInt(1000));

		// natural sorting using Collections class
		Collections.sort(ints);
		System.out.println("Natural Sorting: " + ints);

		// My custom sorting, reverse order
		ints.sort((o1, o2) -> {
			return (o2 - o1);
		});
		System.out.println("Reverse Sorting: " + ints);

		String[] vowel = { "a", "e", "i", "o", "u" };

		List<String> vowelsList = Arrays.asList(vowel);
		System.out.println(vowelsList);

		/**
		 * List is backed by array, we can't do structural modification Both of
		 * the below statements will throw
		 * java.lang.UnsupportedOperationException
		 */
		// vowelsList.remove("e");
		// vowelsList.clear();

		// subList example
		List<String> vowels = new ArrayList<String>();

		// add example
		vowels.add("A");
		vowels.add("I");
		vowels.clear();
		vowels.add("E");
		vowels.add("E");
		vowels.add("I");
		vowels.add("O");
		List<String> list = new ArrayList<String>();
		list = vowels.subList(0, 2);
		System.out.println("letters = " + vowels + ", list = " + list);
		vowels.set(0, "A");
		System.out.println("letters = " + vowels + ", list = " + list);
		list.add("U");
		System.out.println("letters = " + vowels + ", list = " + list);

		// throws ConcurrentModificationException
		// vowels.remove("U");
		// System.out.println("letters = " + vowels + ", list = " + list);

		// Type safe array list, stores only string
		List<String> l = new ArrayList<String>(5);
		l.add("Geeks");
		l.add("for");
		l.add("Geeks");

		// Using indexOf() and lastIndexOf()
		System.out.println("first index of Geeks:" + l.indexOf("Geeks"));
		System.out.println("last index of Geeks:" + l.lastIndexOf("Geeks"));

		// When no element present returns -1
		System.out.println("Index of element" + " not present : " + l.indexOf("Hello"));

		System.out.println("%");

	}

}
