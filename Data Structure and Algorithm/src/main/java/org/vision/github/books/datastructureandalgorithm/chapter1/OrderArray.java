package org.vision.github.books.datastructureandalgorithm.chapter1;

import java.util.Arrays;
import java.util.stream.Collectors;

/** @author ganminghui */

public class OrderArray {
    private long[] a;

    private int nElems;

    public OrderArray(int maxSize){ a = new long[maxSize]; nElems = 0; }

    public int size(){ return nElems; }

    public void insert(long value){
        int j ;
        for (j = 0; j < nElems; j++) { if(a[j] > value) { break; } }

        for(int k=nElems; k>j; k--){ a[k] = a[k-1]; }

        a[j] = value;

        nElems++;
    }

    public int find(long searchKey){
        int lowerBound = 0, upperBound = nElems -1, curIndex;

        while (true){
            if(lowerBound > upperBound){ return nElems; }

            curIndex = (lowerBound + upperBound)/2;
            if(a[curIndex] == searchKey) { return curIndex; }
            else if (a[curIndex] < searchKey){ lowerBound = curIndex + 1; }
            else { upperBound = curIndex - 1; }
        }
    }

    public boolean delete(long value){
        int j = find(value);
        if(j == nElems) { return false; }

        for (int k = j; k < nElems; k++){ a[k] = a[k+1]; }
        nElems--;
        return true;
    }

    public void display(){
        System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}