package com.iamvkohli.basics.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
		
		//Creating and Populating the hashmap
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, 1 + map.getOrDefault(word, 0));
		}
		
		// Create a list
		ArrayList<String> result = new ArrayList<>(map.keySet());

		/*
		 * BUSINESS LOGIC - 
		 * Iterate over the entries of "result"
		 * SORT the result in decreasing order of map values
		 */
		Collections.sort(result,
				(s1, s2) -> map.get(s1).equals(map.get(s2)) ? s1.compareTo(s2) : map.get(s2) - map.get(s1));
		
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				int v1 = map.get(s1);
				int v2 = map.get(s2);
				
				if(v1==v2) {
					int res = s1.compareTo(s2);
				}
				
				return v2-v1;
			}

		};

		return result.subList(0, k);

	}

	public static void main(String[] args) {

	}
}
