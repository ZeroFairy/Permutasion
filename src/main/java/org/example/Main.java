package org.example;

import permutation.ShowAllNode;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        LinkedList<Character> list = new LinkedList<>();

        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');

        ShowAllNode go = new ShowAllNode(list, 3);
        go.startRec();
    }
}

//        Set<LinkedList<Character>> have = new HashSet<LinkedList<Character>>();
//
//        have.add(list);
//
//        System.out.println(have.contains(list));
//
//        list.clear();
//
//        list.add('a');
//        list.add('b');
//        list.add('c');
//        list.add('e');
//        list.add('d');
//
//        System.out.println(have.contains(list));