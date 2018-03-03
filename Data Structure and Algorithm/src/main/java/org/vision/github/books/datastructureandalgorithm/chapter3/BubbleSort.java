package org.vision.github.books.datastructureandalgorithm.chapter3;

import java.util.Arrays;
import java.util.stream.Collectors;

/** @author ganminghui 冒泡排序(无序数组) */
public class BubbleSort {
    /** 申请一个数组 */
    private long[] array;

    /** 数组大小 */
    private int nElems;

    /** 初始化数组 */
    public BubbleSort(int max){ array = new long[max]; nElems = 0; }

    /** 新增元素 */
    public void insert(long value){ array[nElems] = value; nElems++; }

    /** 显示所有元素 */
    public void display(){ System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "))); }

    /** 冒泡排序 */
    public void bubbleSort(){
        /** 外层循环是越来越少，大的元素都移动到后面去了 */
        for (int out = nElems-1; out >=1 ; out--) {
            /** 里层的循环都是从头开始,到已排序的元素的位置为止 */
            for(int in=0; in<out; in++){
               if(array[in]>array[in+1]){
                   swap(in,in+1);
               }
            }
        }
    }

    /** 选择排序 */
    public void selectSort(){
        /** 外层从左边开始慢慢遍历 */
        for (int i=0; i<nElems-1; i++){
            /** 标记最小的索引是未排序的第一个元素索引 */
            int min=i;
            /** 里层比较从未排序的第二个元素索引开始  */
            for (int j=i+1; j<nElems;j++){
                /** 根据元素值大小判断修改标记索引 */
                min = array[min]>array[j]?j:min;
            }
            /** 比较完成,最小索引确定,开始交换(即使i和min一样也交换) */
            swap(i,min);
        }
    }

    /** 数组元素交换 */
    private void swap(int left,int right){
        array[left] = array[left]^array[right];
        array[right] = array[left]^array[right];
        array[left] = array[left]^array[right];
    }
}