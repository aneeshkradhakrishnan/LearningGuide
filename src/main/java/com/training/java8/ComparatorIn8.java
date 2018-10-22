package com.training.java8;

import java.util.*;

public class ComparatorIn8 {

    //Comparator object is capable of comparing two object of different classes.
    // returns a negative integer as the first argument is less than the second
    // returns zero as the first argument is equal to the second
    // returns a positive integer as first argument greater than the second.

    private static Comparator<Emp> annonymousStyle = new Comparator<Emp>() {
        public int compare(Emp a, Emp b) {
            return a.getName().compareTo(b.getName());
        }
    };

    private static Comparator<Emp> lambdaStyle = (a, b) -> a.getName().compareTo(b.getName());

    private static Comparator<Emp> lamdaComparingStyle = Comparator.comparing(Emp::getName);

    private static Comparator<Emp> methodReferenceStyle = ComparatorIn8::compareStrings;

    public static int compareStrings(Emp a, Emp b) {
        return a.getName().compareTo(b.getName());
    }

    public static void main(String... args) {
        List<Emp> annonymousStyleSorted = Arrays.asList(new Emp("John"), new Emp("Aneesh"), new Emp("Mohammed"), new Emp("Smith"), new Emp("Catherine"));
        Collections.sort(annonymousStyleSorted, annonymousStyle);
        System.out.println(annonymousStyleSorted);

        List<Emp> lambdaStyleSorted = Arrays.asList(new Emp("John"), new Emp("Aneesh"), new Emp("Mohammed"), new Emp("Smith"), new Emp("Catherine"));
        Collections.sort(lambdaStyleSorted, lambdaStyle);
        System.out.println(lambdaStyleSorted);

        List<Emp> methodReferenceStyleSorted = Arrays.asList(new Emp("John"), new Emp("Aneesh"), new Emp("Mohammed"), new Emp("Smith"), new Emp("Catherine"));
        Collections.sort(methodReferenceStyleSorted, methodReferenceStyle);
        System.out.println(methodReferenceStyleSorted);

        List<Emp> lamdaComparingStyleSorted = Arrays.asList(new Emp("John"), new Emp("Aneesh"), new Emp("Mohammed"), new Emp("Smith"), new Emp("Catherine"));
        Collections.sort(lamdaComparingStyleSorted, lamdaComparingStyle);
        System.out.println(lamdaComparingStyleSorted);
    }

    static class Emp {
        private String name;

        public Emp(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
