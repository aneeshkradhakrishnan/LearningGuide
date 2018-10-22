package com.training.algorithms.demo;

import com.training.algorithms.datastructure.LinkedList;

public class RunnerLinkedList {
    public static void main(String... args){

        LinkedList.Node<String> first = new LinkedList.Node<>("1");
        LinkedList lklist = new LinkedList(first);
        lklist.add("2");
        lklist.add("3");
        lklist.add("4");
        lklist.add("5");
        lklist.add(first);

        System.out.println(lklist);
        System.out.println(lklist.copy());

    }
}
