package com.training.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String a[]) {

		int[] array = { 45, 23, 11, 89, 77, 4, 98, 28, 65, 43 };
		System.out.println("init : " + Arrays.toString(array));
		MergeSort.sort(array);
	}

	public static void sort(int inputArr[]) {
		doMergeSort(inputArr, new int[inputArr.length], 0, inputArr.length - 1);
	}

	private static void doMergeSort(int[] array, int[] temp, int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(array, temp, lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(array, temp, middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(array, temp, lowerIndex, middle, higherIndex);
		}
	}

	private static void mergeParts(int[] array, int[] temp, int lowerIndex, int middle, int higherIndex) {
		for (int i = lowerIndex; i <= higherIndex; i++) {
			temp[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle+1;
		int k = lowerIndex;
		boolean swapped = false;
		while (i <= middle && j <= higherIndex) {
			if (temp[i] <= temp[j]) {
				array[k] = temp[i];
				i++;
			} else {
				array[k] = temp[j];
				j++;
			}
			k++;
			swapped = true;
		}
		while (i <= middle) {
			array[k] = temp[i];
			k++;
			i++;
		}
		while (j <= higherIndex) {
			array[k] = temp[j];
			k++;
			j++;
		}
		if(swapped) {
			System.out.println("swap : " + Arrays.toString(array));
		}
	}
}
