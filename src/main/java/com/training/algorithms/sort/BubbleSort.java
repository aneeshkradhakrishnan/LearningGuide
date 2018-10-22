package com.training.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String... args){
		int[] inputArr = { 45, 23, 11, 89, 77, 98, 4, 28, 65, 43 };
		BubbleSort bbls = new BubbleSort();
		bbls.sort(inputArr);
		System.out.println(Arrays.toString(inputArr));
	}
	
	public void sort(int[] array){
		int length = array.length;
		for(int i = 0; i < length; i++){
			boolean swapped = false;
			for(int j = 0; j < length-1 ; j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped){
				break;
			}
		}
	}

}
