package com.iamvkohli.basics.sorting;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Map_SortingUsingStreams {

	public static HashMap<String, Integer> getSortedByValue(HashMap<String, Integer> i_map){
		
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		
//		hMap = i_map.entrySet().stream()
//		.sorted(Map.Entry.<String, Integer> comparingByValue())
//		.collect(
//				Collectors.toMap( Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new );
//				);
		
		hMap = i_map
	            .entrySet()
	            .stream()
	            .sorted(Map.Entry.<String, Integer> comparingByValue())
	            .collect(
	                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
	                    LinkedHashMap::new));
		
		 Map<String, Integer> sortedByValueDesc = i_map
			        .entrySet()
			        .stream()
			        .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
			        .collect(
			            Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
			                LinkedHashMap::new));
		 
		 LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();
		 i_map.entrySet()
		 .stream()
		 .sorted( Map.Entry.comparingByValue() )
		 .forEachOrdered( x -> sorted.put(x.getKey(), x.getValue()));
		 
		 
		 
		 LinkedHashMap<String, Integer> reverseSorted = new LinkedHashMap<>();
		 i_map.entrySet()
		 .stream()
		 .sorted( Map.Entry.comparingByValue(Collections.reverseOrder()) )
		 .forEachOrdered( x -> sorted.put(x.getKey(), x.getValue()));
		
		return null;
	}

	public static void main(String[] args) {
		HashMap<String, Integer> strIntMap = new HashMap<String, Integer>() {
			{
				put("One", 1);
				put("Five", 5);
				put("-Four", -4);
			}
		};
		
		getSortedByValue(strIntMap);

	}
}
