package com.training.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamsContinued {
    public static void main(String... args) {

        //Remove from collection
        List<String> list = Stream.of("A", "B", "C", "D").collect(Collectors.toList());
        list.removeIf(element -> element.equals("B"));
        list.forEach(Java8StreamsContinued::print);
        printLine();

        //Iterate
        Integer start = 1;
        List<Integer> iteratedList = Stream.iterate(start, seed -> seed + 2).limit(20).collect(Collectors.toList());
        iteratedList.forEach(Java8StreamsContinued::print);
        printLine();
    }

    private static void print(Object o) {
        System.out.print(o.toString() + " ");
    }

    private static void printLine() {
        System.out.println("");
        System.out.println("----------------------------------------------------------------------");
    }
}
