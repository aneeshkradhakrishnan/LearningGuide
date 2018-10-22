package com.training.algorithms.demo;

import com.training.algorithms.datastructure.LinkedList;

public class RunnerCircularLinkedList {

    public static void main(String... args){

        LinkedList<String> lklist = new LinkedList("1");
        lklist.add("2");
        lklist.add("3");
        lklist.add("4");
        lklist.add("5");
        LinkedList.Node<String> six = new LinkedList.Node("6");
        lklist.add(six);
        lklist.add("7");
        lklist.add("8");
        lklist.add("9");
        lklist.add("10");
        lklist.add("11");
        lklist.add("12");
        lklist.add("13");
        lklist.add("14");
        lklist.add("15");
        lklist.add("16");
        lklist.add("17");
        lklist.add("18");
        lklist.add("19");
        lklist.add(six);
        //lklist.add("11");
        System.out.println("has cycle  : " +lklist.hasCycle());
        System.out.println(lklist);

    }
}
