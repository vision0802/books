package org.vision.github.books.datastructureandalgorithm.chapter1;

import java.util.Arrays;
import java.util.stream.Collectors;

/** @author ganminghui、有序数组 */
public class OrderArray {
    private long[] a;

    private int nElems;

    public OrderArray(int maxSize){ a = new long[maxSize]; nElems = 0; }

    public int size(){ return nElems; }

    /** 有序数组新增先查找到待插入的位置,然后将最后一个位置到插入位置的数据集体往后移 */
    public void insert(long value){
        int j ;
        for (j = 0; j < nElems; j++) { if(a[j] > value) { break; } }

        for(int k=nElems; k>j; k--){ a[k] = a[k-1]; }

        a[j] = value;

        nElems++;
    }

    /** 有序数组二分法查找 */
    public int find(long searchKey){
        int /** 低边界 */lowerBound = 0,
            /** 高边界 */upperBound = nElems -1,
            /** 当前索引 */curIndex;

        while (true){
            if(lowerBound > upperBound){ return nElems; }

            curIndex = (lowerBound + upperBound)/2;
            if(a[curIndex] == searchKey) { return curIndex; }
            /** 如果待查找的数据大于中间值,将低边界值设置为中间值索引的后面一个索引 */
            else if (a[curIndex] < searchKey){ lowerBound = curIndex + 1; }
            /** 如果待查找的数据小于中间值,将高边界值设置为中间值索引的前面一个索引 */
            else { upperBound = curIndex - 1; }
        }
    }

    /** 有序数组删除先找到元素,找到后将找到元素的索引的后一个到最后的元素往前覆盖 */
    public boolean delete(long value){
        int j = find(value);
        if(j == nElems) { return false; }

        for (int k = j; k < nElems; k++){ a[k] = a[k+1]; }
        nElems--;
        return true;
    }

    /** 有序数组显示元素 */
    public void display(){
        System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}