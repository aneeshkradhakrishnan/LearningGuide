package com.training.tests;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

    public static void main(String... args) {
        List<Character> list = Arrays.asList('a', 'b', 'c', 'd', 'a', 'e', 'f', 'g', 'h', 'i', 'j', 'e');
        System.out.println(lengthSubsequenceShoppers(list));
    }

    static List<Integer> lengthSubsequenceShoppers(List<Character> inputList) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        boolean allOnes = true;
        List<Integer> list = new ArrayList<Integer>();
        for (Character s : inputList) {
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
                allOnes = false;
            }
        }

        if (allOnes) {
            for (int i = 0; i < inputList.size(); i++) {
                list.add(1);
            }
            return list;
        }


        for (int i = 0; i < inputList.size(); i++) {
            int index = inputList.size();
            List<Character> it = new ArrayList();
            for (int j = inputList.size() - 1; j > i; j--) {
                if (inputList.get(i).equals(inputList.get(j))) {
                    index = (j + 1) - i;
                    break;
                }
            }
            for (int k = i; k < index; k++) {
                it.add(inputList.get(k));
            }

            for (int l = index; l < inputList.size(); l++) {
                if (it.contains(inputList.get(l))) {
                    index++;
                } else {
                    break;
                }
            }

            list.add(index);
            i += index - 1;
        }

        return list;

    }
    // METHOD SIGNATURE ENDS
}
