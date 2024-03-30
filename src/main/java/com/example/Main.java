package com.example;

// NaturalComparatorInverse
// https://onlinegdb.com/epoy0h2H9

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SortedSet<String> sortedSet = new TreeSet<>(
                // new ReversingComparatorString());
                new NaturalComparatorInverse<String>());
        sortedSet.add("b");
        sortedSet.add("a");
        sortedSet.add("c");

        for (String string : sortedSet) {
            System.out.println(string);
        }

        // outputs: c,b,a

        // ----------------------------
        IteratorDemo.demo1();

    }
}

class ReversingComparatorString implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return -s1.compareTo(s2);
    }
}

// https://stackoverflow.com/questions/15189949/making-a-generic-comparator-class
class NaturalComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T a, T b) {
        return a.compareTo(b);
    }
}

class NaturalComparatorInverse<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T a, T b) {
        return -a.compareTo(b);
    }
}

class IteratorDemo {

    public static void demo1() {

        System.out.println("\n list iterations \n");
        // https://www.geeksforgeeks.org/listiterator-in-java/

        List<String> list = new LinkedList<>(Arrays.asList("aaa", "bbb", "ccc"));

        // Getting ListIterator
        ListIterator<String> iterator = list.listIterator();

        // Traversing elements using next() method
        while (iterator.hasNext()) {

            String string = iterator.next();
            iterator.set("#" + string);

            int ni1 = iterator.nextIndex();

            if (string.equals("bbb"))
                iterator.remove();

            int ni2 = iterator.nextIndex();

            if (ni1 != ni2)
                System.out.println("!!! ni1 != ni2 " + "was (" + string + ") removed?");
        }

        System.out.println("\n for (String s : list) // list iteration \n");

        // for-each loop creates Internal Iterator here.
        for (String s : list)
            System.out.println(s);
    }
}