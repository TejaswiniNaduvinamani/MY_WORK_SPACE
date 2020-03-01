package com.org.arraydup;

import java.util.Arrays;
import java.util.Scanner;

public class CreatUniqueArrayWithIncrementingDuplicates {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of the array");
		int size = sc.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.println("enter the element of the array");
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {
				if (arr[i] == arr[j] && i != j) {
					arr[j] = arr[j] + 1;
				}

			}
		}
		for (int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(1 / 0.0);
	}

}
