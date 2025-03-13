/**
 * Author by Jordan Vincent
 * Universitas Sanata Dharma
 */
package org.example;

import permutation.Node;
import permutation.ShowAllNode;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Node a = new Node("L1", "Laki 1");
        Node b = new Node("L2", "Laki 2");
        Node c = new Node("L3", "Laki 3");
        Node d = new Node("P1", "Perempuan 1");
        Node e = new Node("P2", "Perempuan 2");


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