package com.training.tests;

import java.util.*;
import java.util.Map.Entry;

public class AudibleTestCellState {
    public static void main(String... args) {
        System.out.println("Begin test");
        System.out.println(cellCompete(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 5));
    }

    public static List<Integer> cellCompete(int[] states, int days) {
        int[] newStates = new int[states.length];
        newStates[0] = 1;
        newStates[states.length - 1] = 1;
        for (int i = 1; i < states.length - 1; i++) {
            newStates[i] = states[i - 1] ^ states[i + 1];
        }
        System.out.println("Days " + days + " -> " + printArray(newStates));
        if (days > 1) {
            return cellCompete(newStates, days - 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : newStates) {
            list.add(i);
        }

        return list;
    }

    private static String printArray(int[] states) {
        String s = "";
        for (int i = 0; i < states.length; i++) {
            s = s + states[i] + " ";
        }
        return s;
    }
}
