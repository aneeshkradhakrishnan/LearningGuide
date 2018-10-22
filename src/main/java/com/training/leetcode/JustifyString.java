package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class JustifyString {

    public static void main(String[] args) {
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(fullJustify(words1, 16));

        String[] words2 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        System.out.println(fullJustify(words2, 20));

        String[] words3 = {"a"};
        System.out.println(fullJustify(words3, 1));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int spaces = maxWidth;
        List<String> list = new ArrayList<>();
        int start = 0, lastEnd = 0, count = 0;
        for (int i = 0; i < words.length; i++, count++) {
            if (spaces >= words[i].length() + count) {
                spaces -= words[i].length();
            } else {
                processWords(list, words, start, i - 1, spaces, false);
                lastEnd = i - 1;
                start = i;
                count = 0;
                spaces = maxWidth - words[i].length();
            }
        }

        if (lastEnd == 0 || lastEnd != words.length - 1) {
            processWords(list, words, start, words.length - 1, spaces, true);
        }

        return list;
    }

    public static void processWords(List<String> list, String[] words, int start, int end, int spaces, boolean isLast) {

        for (int i = start; i <= end && spaces > 0; ) {
            words[i] = words[i] + " ";
            spaces--;
            if (i == end - 1 || i == end) {
                if (!isLast) {
                    i = start;
                } else if (i == end - 1) {
                    i++;
                }
            } else {
                i++;
            }
        }

        String sentance = "";
        for (int i = start; i <= end; i++) {
            sentance = sentance + words[i];
        }
        list.add(sentance);
    }
}