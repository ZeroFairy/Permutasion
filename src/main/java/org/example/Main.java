package org.example;

import permutation.Node;
import permutation.ShowAllNode;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Node a = new Node("Laki 1", "a");
        Node b = new Node("Laki 2", "b");
        Node c = new Node("Laki 3", "a");
        Node d = new Node("Perempuan 1", "a");
        Node e = new Node("Perempuan 2", "a");


        LinkedList<Node> list = new LinkedList<>();

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);

        ShowAllNode go = new ShowAllNode(list, 5);
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