package com.training.algorithms.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortAsc(new int[]{84, 69, 94, 86, 76, 91})));
        System.out.println(Arrays.toString(sortDsc(new int[]{84, 69, 94, 86, 76, 91})));
    }

    public static int[] sortAsc(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static int[] sortDsc(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are less than key, to one position ahead of their current position */
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }


	//Insertion sort is based on the idea that one element from the input elements is consumed in each iteration
	// to find its correct position i.e, the position to which it belongs in a sorted array.
	public static int[] insertionSortDesc(int[] num) {
		int j; // the number of items sorted so far
		int key; // the item to be inserted
		int i;
		System.out.println(Arrays.toString(num));
		for (j = 1; j < num.length; j++) { // Start with 1 (not 0)
			key = num[j];
			for (i = j - 1; (i >= 0) && (num[i] < key); i--) { // Smaller values moving up
				num[i + 1] = num[i];
			}
			num[i + 1] = key; // Put the key in its proper location
			System.out.println("Desc - " +Arrays.toString(num));
		}

		return num;
	}
	
	public static int[] insertionSortAsc(int[] num) {
		int j; // the number of items sorted so far
		int key; // the item to be inserted
		int i;

		for (j = 1; j < num.length; j++) { // Start with 1 (not 0)
			key = num[j];
			for (i = j - 1; (i >= 0) && (num[i] > key); i--) { // Smaller values are moving up
				num[i + 1] = num[i];
			}
			num[i + 1] = key; // Put the key in its proper location
			System.out.println("Asc - " +Arrays.toString(num));
		}

		return num;
	}
}
