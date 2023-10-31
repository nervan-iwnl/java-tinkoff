package edu.hw3; // Task 8

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BackwardIterator<T> implements Iterator<T> {

    private final List<T> iterable;
    private int currIndex;

    public BackwardIterator(List<T> iterable) {
        this.iterable = iterable;
        this.currIndex = iterable.size();
    }

    @Override
    public boolean hasNext() {
        return currIndex > 0;
    }

    @Override
    public T next() {
        if (currIndex <= 0) {
            throw new NoSuchElementException("DOESN'T EXISTS NEXT ELEMENT");
        }
        return iterable.get(--currIndex);
    }
}
