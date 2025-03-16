/**
 * Author by Jordan Vincent
 * Universitas Sanata Dharma
 */
package org.example;

import permutation.Node;
import permutation.ShowAllNode;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Node a = new Node("L1", "Laki-Laki 1");
        Node b = new Node("L2", "Laki-Laki 2");
        Node c = new Node("L3", "Laki-Laki 3");
        Node d = new Node("P1", "Perempuan 1");
        Node e = new Node("P2", "Perempuan 2");
        Node f = new Node("W1", "Waria 1");

        LinkedList<Node> list = new LinkedList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);

        String soal = "SOAL_D";
        start(soal, list);
    }

    public static void start(String start, LinkedList<Node> list) {
        ShowAllNode go = new ShowAllNode(list);

        switch (start.toUpperCase()) {
            case "SOAL_A":
                go.startARec();
                break;
//            case "SOAL_B":
//                startBRec();
//            case "SOAL_C":
//                startCRec();
            case "SOAL_D":
                Iterator<Node> iter = list.iterator();
                Map<String, Integer> feature = new HashMap<>();
                int counter = 0;
                Node node = iter.next();
                while (iter.hasNext()) {
                    int input;
                    Node prev = node;
                    node = iter.next();
                    if (iter.hasNext()) {
                        if (String.valueOf(prev.getLabel().charAt(0)).equals(String.valueOf(node.getLabel().charAt(0)))) {
                            counter++;
                        } else {
                            counter++;
                            do {
                                System.out.println("Nilai R untuk Label " + prev.getLabel().charAt(0) + " : ");
                                input = scanner.nextInt();
                            } while (input > counter);

                            feature.put(String.valueOf(prev.getLabel().charAt(0)), counter);
                            counter = 0;
                        }
                    } else {
                        System.out.println("TERAKHIR");
                        counter++;
                        do {
                            System.out.println("Nilai R untuk Label " + prev.getLabel().charAt(0) + " : ");
                            input = scanner.nextInt();
                        } while (input > counter);

                        feature.put(String.valueOf(prev.getLabel().charAt(0)), counter);
                        counter = 0;

                        counter++;
                        do {
                            System.out.println("Nilai R untuk Label " + node.getLabel().charAt(0) + " : ");
                            input = scanner.nextInt();
                        } while (input > counter);

                        feature.put(String.valueOf(node.getLabel().charAt(0)), counter);
                        counter = 0;
                    }
                }

                go.startDRec(feature);
                break;
            default:
                System.out.println("Sorry, tidak ada pilihan ini");
        }
    }
}