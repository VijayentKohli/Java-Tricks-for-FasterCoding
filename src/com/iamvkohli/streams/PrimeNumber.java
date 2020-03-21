package com.iamvkohli.streams;

import java.util.stream.IntStream;

public class PrimeNumber {
	private static boolean isPrime(int number) {
		return number > 1 && IntStream.range(2, number)
				.noneMatch(index -> number % index == 0);
	}

	public static void main(String[] args) {
		int a1 = 11;
		int a2 = 12;

		System.out.println(isPrime(a1));
		System.out.println(isPrime(a2));

	}
}
