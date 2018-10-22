package com.training.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AudibleTestReorderLines {

    public static void main(String... args) {
        System.out.println("Begin test");
        System.out.println("123".compareTo("abc"));
        System.out.println("ace".compareTo("acd"));
        System.out.println("34".compareTo("54"));
        List<String> list = new ArrayList<>();

        list.add("mi2 jog mid pet");
        list.add("wz3 34 54 398");
        list.add("a1 alps cow bar");
        list.add("x4 45 21 7");
        System.out.println(new AudibleTestReorderLines().reorderLines(5, list));
    }

    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        Collections.sort(logLines, this::compareLines);
        return logLines;
    }

    public int compareLines(String first, String second) {
        String[] firstWords = first.trim().split(" ");
        String[] secondWords = second.trim().split(" ");
        if(firstWords.length == 0 || firstWords.length == 1) {
            return -1;
        }
        if(secondWords.length == 0 || secondWords.length == 1) {
            return 1;
        }

        for(int i=1; i<firstWords.length && i< secondWords.length; i++) {
            String firstWord = firstWords[i];
            String secondWord = secondWords[i];
            if(isWordInteger(firstWord) && isWordInteger(secondWord)) {
                int firstInt = Integer.parseInt(firstWord);
                int secondInt = Integer.parseInt(secondWord);
                if(firstInt != secondInt) {
                    return firstInt - secondInt;
                }
                continue;
            }

            if(isWordInteger(firstWord)) {
                return firstWord.compareTo(secondWord) * -1;
            }

            if(isWordInteger(secondWord)) {
                return firstWord.compareTo(secondWord) * -1;
            }

            if(firstWord.compareTo(secondWord) == 0) {
                continue;
            }

            return firstWord.compareTo(secondWord);

        }

        return 0;
    }

    private boolean isWordInteger(String word) {
        try {
            int value = Integer.parseInt(word);
            return true;
        } catch (Exception e) {

        }

        return false;
    }
}
