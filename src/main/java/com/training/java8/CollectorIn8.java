package com.training.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorIn8 {

    public static void main(String... args) {
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
        Map<String, Long> finalResult = new HashMap<>();
                result.entrySet()
                .stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(stringLongEntry -> finalResult.put(stringLongEntry.getKey(),  stringLongEntry.getValue()));
        System.out.println(finalResult);

    }
}
