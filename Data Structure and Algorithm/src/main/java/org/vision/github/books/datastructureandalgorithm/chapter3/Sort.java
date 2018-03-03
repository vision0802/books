package org.vision.github.books.datastructureandalgorithm.chapter3;

import java.util.Arrays;
import java.util.stream.Collectors;

/** @author ganminghui 冒泡排序(无序数组) */
public class Sort {
    /** 申请一个数组 */
    private long[] array;

    /** 数组大小 */
    private int nElems;

    /** 初始化数组 */
    public Sort(int max){ array = new long[max]; nElems = 0; }

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

    /** 插入排序-二分查找 */
    public void insertSort(){
        for (int upperBound = 1; upperBound <= nElems-1 ; upperBound++) {
            long searchKey = array[upperBound];
            int insertIndex = getInsertIndex(searchKey,upperBound-1);
            movedOrderPartAndInsert(insertIndex,upperBound,searchKey);
        }
    }

    /** 局部有序队列中查找插入位置 */
    private int getInsertIndex(long searchKey,int upperBound){
        if(array[0]>=searchKey) {return 0;}
        if(array[upperBound]<=searchKey) {return upperBound + 1;}

        int /** 低边界 */lowerBound = 0,
                /** 高边界 upperBound = arrayOrder.length -1,*/
                /** 当前索引 */curIndex;
        while (true){
            if(lowerBound > upperBound){ return upperBound; }

            curIndex = (lowerBound + upperBound)/2;
            if(array[curIndex] == searchKey) { return curIndex; }

            else if(array[curIndex] < searchKey) {
                if(array[curIndex + 1] >= searchKey){ return curIndex + 1; }
                else { lowerBound = curIndex+1;}
            }
            else {
                if(array[curIndex - 1] <= searchKey) { return curIndex; }
                upperBound = curIndex - 1;
            }
        }
    }

    /** 局部有序队列移动并插入新值
     *  @param endIndex 待覆盖的索引位置(数组无序队列的头) endIndex一定大于insertIndex,否则局部有序数组有问题
     *  @param insertIndex 待插入的索引位置
     *  @param value 待插入的值
     * */
    private void movedOrderPartAndInsert(int insertIndex,int endIndex,long value){
        /** 覆盖 */
        for (int i = endIndex-1; i >=insertIndex ; i--) {
            array[i+1] = array[i];
        }
        array[insertIndex] = value;
    }
}