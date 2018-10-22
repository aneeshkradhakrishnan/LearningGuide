package com.training.algorithms.search;

public class LinearSearch<T> {
	
	public int search(T[] array, T searchItem) {
		for(int i = 0; i < array.length; i++) {
			if(array[i].equals(searchItem)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String... args) {
		Integer[] array = {2, 5, 6, 1, 8, 9};
		System.out.println(new LinearSearch<Integer>().search(array, 5));
	}
}
