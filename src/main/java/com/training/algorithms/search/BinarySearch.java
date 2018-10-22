package com.training.algorithms.search;

import java.util.Comparator;

public class BinarySearch<T> {
	private int noOfIteration = 0;
	
	public int search(T[] array, T searchItem, Comparator<T> comparator) {
		return search(array, searchItem, 0, array.length-1, comparator);
	}
	
	public int search(T[] array, T searchItem, int first, int last, Comparator<T> comparator) { 
		System.out.println("Iteration : "+(++noOfIteration));
		if(array[first].equals(searchItem)) {
			return first;
		}
		
		if(array[last].equals(searchItem)) {
			return last;
		}
		
		int mid = (first + last)/2;
		
		if(mid == first || mid == last) {
			return -1;
		}
		
		if(array[mid].equals(searchItem)) {
			return mid;
		}
		
		int compare = comparator.compare(array[mid], searchItem);
		
		if(compare == -1) {
			return search(array, searchItem, mid, last, comparator);
		}
		
		if(compare == 1) {
			return search(array, searchItem, first, mid, comparator);
		}
		
		return -1;
	}

	public static void main(String... args) {
		String s = "chinnuparu";
		System.out.println(s.hashCode() + "  " +hash(s.hashCode()));
		System.out.println(s.hashCode() + " 20 " +(s.hashCode() & 20));
		Integer[] array = {2, 5, 6, 7, 8, 9, 11, 23, 44, 53, 57, 64, 73, 78, 80};
		Comparator<Integer> comparator = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2) {
					return -1;
				}
				if(o1 > o2) {
					return 1;
				}
				
				return 0;
			}
			
		};
		System.out.println(new BinarySearch<Integer>().search(array, 44, comparator));
		System.out.println(new BinarySearch<Integer>().search(array, 63, comparator));
	}
	
	static int hash(int h) {		
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}
}

