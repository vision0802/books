package org.vision.github.books.datastructureandalgorithm.chapter1;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HightArrayTest {

    @Test public void test(){
        int maxSize = 100;

        HightArray hightArray = new HightArray(maxSize){{
            insert(77); insert(99); insert(44); insert(55); insert(66);
            insert(22); insert(88); insert(11); insert(00); insert(33);
        }};

        hightArray.display();

        int searchKey = 35;
        System.out.println(hightArray.find(searchKey)?"Found ":"Can't find " + searchKey);

        hightArray.delete(00); hightArray.delete(55); hightArray.delete(99);

        hightArray.display();

    }

    @Test public void test1(){
        int[] a = new int[]{10,5};

        a[0] = a[0]^a[0+1];
        a[0+1] = a[0]^a[0+1];
        a[0] = a[0]^a[0+1];
        System.out.println("a[0]: "+a[0]+", a[1]: "+a[1]);
    }

    @Test public void inserSortTest(){
        System.out.println("动作之前:"+Arrays.stream(arrayOrder).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        for (int upperBound = 1; upperBound <= arrayOrder.length-1 ; upperBound++) {
            int searchKey = arrayOrder[upperBound];
            int insertIndex = getInsertIndex(searchKey,upperBound-1);
            System.out.println("searchKey:"+searchKey+"应该插入在索引:"+insertIndex+"的位置上....");
            movedOrderPartAndInsert(insertIndex,upperBound,searchKey);
        }
        System.out.println("动作之后:"+Arrays.stream(arrayOrder).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    int[] arrayOrder = new int[]{1,0,3,5,7,9,1,5,7,8,9,3,4};

    /** 局部有序队列中查找插入位置 */
    public int getInsertIndex(int searchKey,int upperBound){
        if(arrayOrder[0]>=searchKey) return 0;
        if(arrayOrder[upperBound]<=searchKey) return upperBound + 1;

        int /** 低边界 */lowerBound = 0,
            /** 高边界 upperBound = arrayOrder.length -1,*/
            /** 当前索引 */curIndex;
        while (true){
            if(lowerBound > upperBound){ return upperBound; }

            curIndex = (lowerBound + upperBound)/2;
            if(arrayOrder[curIndex] == searchKey) { return curIndex; }

            else if(arrayOrder[curIndex] < searchKey) {
                if(arrayOrder[curIndex + 1] >= searchKey){ return curIndex + 1; }
                else { lowerBound = curIndex+1;}
            }
            else {
                if(arrayOrder[curIndex - 1] <= searchKey) { return curIndex; }
                upperBound = curIndex - 1;
            }
        }
    }

    /** 局部有序队列移动并插入新值
     *  @param endIndex 待覆盖的索引位置(数组无序队列的头) endIndex一定大于insertIndex,否则局部有序数组有问题
     *  @param insertIndex 待插入的索引位置
     *  @param value 待插入的值
     * */
    public void movedOrderPartAndInsert(int insertIndex,int endIndex,int value){
        /** 覆盖 */
        for (int i = endIndex-1; i >=insertIndex ; i--) {
            arrayOrder[i+1] = arrayOrder[i];
        }
        arrayOrder[insertIndex] = value;
    }
}