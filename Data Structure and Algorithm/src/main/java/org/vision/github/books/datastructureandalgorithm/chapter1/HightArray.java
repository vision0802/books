package org.vision.github.books.datastructureandalgorithm.chapter1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** @author ganminghui */

public class HightArray {
    /** 声明一个数组 */ private long[] a;

    /** 声明变量记录数据项个数 */ private int nElemts;

    /** 构造方法用于初始化数组和数据项总数 */
    public HightArray(int max){ a = new long[max]; nElemts = 0; }

    public void insert(long value){ a[nElemts] = value; nElemts ++ ; }

    public boolean find(long searchKey){
        int j;

        for (j=0;j<nElemts;j++){ if(a[j]==searchKey){ break; } }

        return j == nElemts;
    }

    public boolean delete(long value){
        int j;

        for (j=0; j<nElemts; j++){ if(a[j]==value){ break; } }

        if(j == nElemts) { return false; }
        else {
            for (int k=j; k<nElemts; k++){ a[k] = a[k+1]; }
            nElemts--;

            return true;
        }

    }

    public void display(){
        System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}