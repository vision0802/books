package org.vision.github.books.datastructureandalgorithm.chapter1;

import org.junit.Test;

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
}