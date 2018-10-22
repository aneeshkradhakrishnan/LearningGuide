package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubStringWithoutRepeatingChars {

        public static void main(String... args) {
            System.out.println("Length of Longest Sub String 'abcdabcbb' : " + lengthOfLongestSubstring("abcdabcbb"));
        }

    public static int lengthOfLongestSubstring(String s) {
        List<Character> sub = new ArrayList();
        int max = 0;
        for(int i=0, j=0; j<s.length();) {
            if(!sub.contains(s.charAt(j))) {
                sub.add(s.charAt(j++));
                max = Math.max(max, sub.size());
            } else {
                sub.remove((Character)s.charAt(i++));
            }
        }
        return max;
    }
}
