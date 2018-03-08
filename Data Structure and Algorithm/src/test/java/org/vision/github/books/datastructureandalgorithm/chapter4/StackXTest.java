package org.vision.github.books.datastructureandalgorithm.chapter4;

import org.junit.Test;

public class StackXTest {

    @Test public void testStackX() {
        StackX stackX = new StackX(10);
        stackX.push(20);stackX.push(10);stackX.push(72);
        stackX.push(5);stackX.push(39);stackX.push(15);
        stackX.push(68);stackX.push(25);stackX.push(52);

        while (!stackX.isEmpty()){
            System.out.print(stackX.pop() + "  ");
        }
        System.out.println();
    }
}