package com.training.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IterationIn8 {
    public static void main(String... args) {
        HashMap<String, Integer> map = getMap();
        map.forEach((key, value) -> printMap(key, value));
        printLane();
        map.forEach(IterationIn8::printMap);
        printLane();

        List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
        list.forEach(System.out::print);
        printLane();

        //Prints everything except B
        list.stream()
                .filter(x -> !x.equals("B"))
                .forEach(System.out::print);
        printLane();

        //Filtering into list everything except G
        List<String> result = list.stream()
                                .filter(x -> !x.equals("G"))
                                .collect(Collectors.toList());
        result.forEach(System.out::print);
        printLane();

        //Find any else

        String find = list.stream()
                        .filter(x -> x.equals("C"))
                        .findAny()
                        .orElse("C not found");
        System.out.println("Find c is : " +find);

        find = list.stream()
                .filter(x -> x.equals("X"))
                .findAny()
                .orElse("X not found");
        System.out.println("Find x is : " +find);
        printLane();

        //map to some other Ojects

        List<String> mapped = list.stream()
                                .map(String::toLowerCase)
                                .collect(Collectors.toList());

        mapped.forEach(System.out::print);
        printLane();

        List<String> fromStream = Stream.of(" made", " from", " stream", " in", " java8").collect(Collectors.toList());
        fromStream.forEach(System.out::print);
        printLane();

        String[] array =  {" made", " from", " array", " to", " stream", " in", " java8"};
        List<String> arrayToStream = Arrays.stream(array).collect(Collectors.toList());
        arrayToStream.forEach(System.out::print);
        printLane();

    }

    private static void printMap(String key, Integer value) {
        System.out.println("Key : " + key + " Value : " + value);
    }

    private static HashMap<String, Integer> getMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);
        map.put("G", 7);
        map.put("H", 8);
        map.put("I", 9);
        map.put("J", 10);
        map.put("K", 11);
        map.put("L", 12);
        map.put("M", 13);
        map.put("N", 14);
        map.put("O", 15);
        map.put("P", 16);
        map.put("Q", 17);
        map.put("R", 18);
        map.put("S", 19);
        map.put("T", 20);
        map.put("U", 21);
        map.put("V", 22);
        map.put("W", 23);
        map.put("X", 24);
        map.put("Y", 25);
        map.put("Z", 26);
        return map;
    }

    private static void printLane() {
        System.out.println(" ");
        System.out.println("________________________________________________");
        System.out.println(" ");
    }
}
