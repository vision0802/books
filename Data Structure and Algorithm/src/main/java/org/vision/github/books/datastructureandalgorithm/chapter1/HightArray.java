package org.vision.github.books.datastructureandalgorithm.chapter1;

import java.util.Arrays;
import java.util.stream.Collectors;

/** @author ganminghui */
public class HightArray {
    /** 声明一个数组 */
    private long[] a;

    /** 声明变量记录数据项个数 */
    private int nElemts;

    /** 构造方法用于初始化数组和数据项总数 */
    public HightArray(int max){ a = new long[max]; nElemts = 0; }

    /** 新增元素到数组 */
    public void insert(long value){ a[nElemts] = value; nElemts ++ ; }

    /** 查找元素 */
    public boolean find(long searchKey){
        int j;

        for (j=0;j<nElemts;j++){ if(a[j]==searchKey){ break; } }

        return j == nElemts;
    }

    /** 删除元素,先查找元素,查找到,将后面的元素往前移动一步覆盖 */
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

    /** 显示数组元素 */
    public void display(){
        System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}