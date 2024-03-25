package com.example;

// NaturalComparatorInverse
// https://onlinegdb.com/epoy0h2H9

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SortedSet<String> sortedSet = new TreeSet<>(
                //new ReversingComparatorString());
                new NaturalComparatorInverse<String>());
        sortedSet.add("b");
        sortedSet.add("a");
        sortedSet.add("c");

        for (String string : sortedSet) {
            System.out.println(string);
        }

        // outputs: c,b,a
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
