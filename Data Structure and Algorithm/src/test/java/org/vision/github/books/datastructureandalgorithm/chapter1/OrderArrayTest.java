package org.vision.github.books.datastructureandalgorithm.chapter1;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderArrayTest {

    @Test public void test(){
        int maxSize = 100;
        OrderArray orderArray = new OrderArray(maxSize){{
            insert(77); insert(99); insert(44); insert(55); insert(22);
            insert(88); insert(11); insert(00); insert(66); insert(33);
        }};

        int searchKey = 55;
        System.out.println(orderArray.find(searchKey)!=orderArray.size()?"Found":"Can't find" + searchKey);

        orderArray.display();

        orderArray.delete(00); orderArray.delete(55); orderArray.delete(99);

        orderArray.display();
    }

    @Test public void testSwap(){
        int a = 100,b = 50;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a:"+a+",b:"+b);
    }

    @Test public void testSwapArray(){
        long[] array = new long[]{1,2};
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        array[0] = array[0]^array[1]; array[1] = array[0]^array[1]; array[0] = array[0]^array[1];
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
}