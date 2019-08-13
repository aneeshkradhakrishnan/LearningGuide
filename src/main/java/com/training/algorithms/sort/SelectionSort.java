package com.training.algorithms.sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(selectionSortAsc(new int[] { 84, 69, 76, 86, 94, 91 })));
		System.out.println(Arrays.toString(selectionSortDesc(new int[] { 84, 69, 76, 86, 94, 91 })));

	}

	//The Selection sort algorithm is based on the idea of finding the minimum or maximum element in an unsorted array
	// and then putting it in its correct position in a sorted array.

	public static int[] selectionSortAsc(int[] num) {
		int i, j, first, temp;
		System.out.println(Arrays.toString(num));
		for (i = num.length - 1; i > 0; i--) {
			first = 0; // initialize to subscript of first element
			for (j = 1; j <= i; j++) { // locate smallest element between positions 1 and i.
				if (num[j] > num[first]){
					first = j;
				}
			}
			temp = num[first]; // swap smallest found with element in position
								// i.
			num[first] = num[i];
			num[i] = temp;
			System.out.println(Arrays.toString(num));
		}

		return num;
	}
	
	public static int[] selectionSortDesc(int[] num) {
		int i, j, first, temp;
		for (i = num.length - 1; i > 0; i--) {
			first = 0; // initialize to subscript of first element
			for (j = 1; j <= i; j++) { // locate smallest element between positions 1 and i.
				if (num[j] < num[first]){
					first = j;
				}
			}
			temp = num[first]; // swap smallest found with element in position
								// i.
			num[first] = num[i];
			num[i] = temp;
		}

		return num;
	}

}
