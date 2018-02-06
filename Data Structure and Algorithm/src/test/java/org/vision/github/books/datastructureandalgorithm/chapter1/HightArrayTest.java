package org.vision.github.books.datastructureandalgorithm.chapter1;

import org.junit.Test;

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
}