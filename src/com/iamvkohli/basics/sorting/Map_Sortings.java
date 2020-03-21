package com.iamvkohli.basics.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Map_Sortings {

	/*
	 * Custom Comparator 
	 * Order - Increasing 
	 * SortBy - Value
	 */
	public static Comparator<Map.Entry<String, Integer>> getIncComparatorByValue(){
		Comparator<Map.Entry<String, Integer>> myComparator = new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				Integer int1 = e1.getValue();
				Integer int2 = e2.getValue();
				return int1.compareTo(int2);
			}
		};
		return myComparator;
	}
	
	
	/*
	 * Custom Comparator 
	 * Order - Decreasing 
	 * SortBy - Value
	 */
	public static Comparator<Map.Entry<String, Integer>> getDecComparatorByValue(){
		Comparator<Map.Entry<String, Integer>> myComparator = new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {

				Integer int1 = e1.getValue();
				Integer int2 = e2.getValue();
				return int2.compareTo(int1);
			}
		};
		
		return myComparator;
	}
	
	
	/*
	 * Custom Comparator 
	 * Order - Increasing 
	 * SortBy - Key
	 */
	public static Comparator<Map.Entry<String, Integer>> getIncComparatorByKey(){
		Comparator<Map.Entry<String, Integer>> myComparator = new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				String int1 = e1.getKey();
				String int2 = e2.getKey();
				return int1.compareTo(int2);
			}
		};
		
		return myComparator;
	}
	
	/*
	 * Custom Comparator 
	 * Order - Decreasing 
	 * SortBy - Key
	 */
	public static Comparator<Map.Entry<String, Integer>> getDecComparatorByKey(){
		Comparator<Map.Entry<String, Integer>> myComparator = new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {

				String int1 = e1.getKey();
				String int2 = e2.getKey();
				return int2.compareTo(int1);
			}
		};
		
		return myComparator;
	}

	/*
	 * HashMap Ascending order sorting Using Comparator
	 */
	public static HashMap<String, Integer> increasingOrderByValue(HashMap<String, Integer> hm) {
		ArrayList<Map.Entry<String, Integer>> hm_List = new ArrayList<>();
		ArrayList<Map.Entry<String, Integer>> hm_ListTest = new ArrayList<>();

		// Iterative Addition
		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			hm_List.add(entry);
		}

		// Whole Addition
		hm_ListTest.addAll(hm.entrySet());

		//STEP-2 Sorting the list
		Collections.sort(hm_ListTest, getIncComparatorByValue());
		
		//printList
		hm_ListTest.stream().forEach(System.out::println);
		
		//STEP-3 Put everything in linkedHashmap
		HashMap<String, Integer> linkedHm = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> entry: hm_ListTest ) {
			linkedHm.put(entry.getKey(), entry.getValue());
		}

		return linkedHm;
	}

	/*
	 * 
	 */
	public static HashMap<String, Integer> decreasingOrderByValue(HashMap<String, Integer> hm) {
		
		ArrayList<Map.Entry<String, Integer>> arrList = new ArrayList<>();
		arrList.addAll(hm.entrySet());
		
		//Get Comparator for reverseOrder
		Collections.sort(arrList, getDecComparatorByValue() );
		
//		//Method -2 DID NOT WORK - Exception in thread "main" java.lang.ClassCastException: java.util.HashMap$Node cannot be cast to java.lang.Comparable
//		Collections.sort(arrList, getIncComparatorByValue());
//		Collections.sort(arrList, Collections.reverseOrder());
		
		HashMap<String, Integer> linkedHm = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> entry: arrList ) {
			linkedHm.put(entry.getKey(), entry.getValue());
		}

		return linkedHm;
	}

	/*
	 * HashMap Ascending order sorting Using Comparator
	 */
	public static HashMap<String, Integer> increasingOrderByKey(HashMap<String, Integer> hm) {
		ArrayList<Map.Entry<String, Integer>> arrList = new ArrayList<>();
		arrList.addAll(hm.entrySet());
		
		//Get Comparator for reverseOrder
		Collections.sort(arrList, getIncComparatorByKey() );
		
		HashMap<String, Integer> linkedHm = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> entry: arrList ) {
			linkedHm.put(entry.getKey(), entry.getValue());
		}
		
		return linkedHm;
	}

	/*
	 * HashMap Ascending order sorting Using Comparator
	 */
	public static HashMap<String, Integer> decreasingOrderByKey(HashMap<String, Integer> hm) {
		ArrayList<Map.Entry<String, Integer>> arrList = new ArrayList<>();
		arrList.addAll(hm.entrySet());
		
		//Get Comparator for reverseOrder
		Collections.sort(arrList, getDecComparatorByKey() );
		
		HashMap<String, Integer> linkedHm = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> entry: arrList ) {
			linkedHm.put(entry.getKey(), entry.getValue());
		}
		
		return linkedHm;
	}

	public static void main(String[] args) {
		HashMap<String, Integer> strIntMap = new HashMap<String, Integer>() {
			{
				put("One", 1);
				put("Five", 5);
				put("-Four", -4);
			}
		};

//		HashMap<String, Integer> incSortedByValue = increasingOrderByValue(strIntMap);
//		HashMap<String, Integer> decSortedByValue = decreasingOrderByValue(strIntMap);
		HashMap<String, Integer> incSortedByKey = decreasingOrderByKey(strIntMap);
	}
}
