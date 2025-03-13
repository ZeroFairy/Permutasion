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
        Node a = new Node("L1", "Laki-Laki 1");
        Node b = new Node("L2", "Laki-Laki 2");
        Node c = new Node("L3", "Laki-Laki 3");
        Node d = new Node("P1", "Perempuan 1");
        Node e = new Node("P2", "Perempuan 2");

        LinkedList<Node> list = new LinkedList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);

        String soal = "SOAL_A";
        int nilaiR = 5;

        //Size = r pada permutasi
        ShowAllNode go = new ShowAllNode(list, nilaiR);
        go.start(soal);
    }
}