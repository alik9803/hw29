package org.example;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new ArrayListImpl();

        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        System.out.println("Size: " + stringList.size());
        System.out.println("Contains Banana: " + stringList.contains("Banana"));

        stringList.remove("Banana");

        System.out.println("Size after removal: " + stringList.size());
        System.out.println("Contains Banana after removal: " + stringList.contains("Banana"));
    }
}