package org.example;

import org.apache.commons.compress.harmony.pack200.IntList;

import java.util.Arrays;

public class IntegerList extends IntList {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] elements;
    private int size;

    public IntegerList() {
        this.elements = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public IntegerList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        }
        this.elements = new int[initialCapacity];
        this.size = 0;
    }

    @Override
    public IntegerList clone() {
        try {
            IntegerList cloneList = (IntegerList) super.clone();
            cloneList.elements = Arrays.copyOf(this.elements, this.size);
            return cloneList;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}