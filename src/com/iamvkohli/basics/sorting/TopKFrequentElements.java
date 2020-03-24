package com.iamvkohli.basics.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i : nums) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}

		/*
		 * Declare a priority Queue Contructor : PriorityQueue(int initialCapacity,
		 * Comparator<? super E> comparator) Sort in decreasing order - i.e
		 * hm.get(num2)-hm.get(num2) if frequencies are equal - sort by smaller
		 * number/key - hm.get(num1).compareTo(hm.get(num2)
		 * 
		 */
//		PriorityQueue<Integer> pq = new PriorityQueue<>(
//				(num1, num2) -> hm.get(num1).equals(hm.get(num2)) ? hm.get(num1).compareTo(hm.get(num2))
//						: hm.get(num1) - hm.get(num2));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>( (num1, num2) -> hm.get(num1)-hm.get(num2) );

		for (Entry<Integer, Integer> entry : hm.entrySet()) {
			pq.offer(entry.getKey());
			if (pq.size() > k) {
				pq.poll();
			}
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (Integer i : pq) {
			result.add(i);
		}

		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3};
		int k = 2;
		
		TopKFrequentElements topK = new TopKFrequentElements();
		topK.topKFrequent(arr, k);
	}
}