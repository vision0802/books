package org.vision.github.books.datastructureandalgorithm.chapter3;

import org.junit.Test;

public class BubbleSortTest {
    @Test public void bubbleSort() {
        BubbleSort bubbleSort = new BubbleSort(12);
        bubbleSort.insert(20); bubbleSort.insert(3); bubbleSort.insert(8);
        bubbleSort.insert(12); bubbleSort.insert(9); bubbleSort.insert(28);
        bubbleSort.insert(6); bubbleSort.insert(17); bubbleSort.insert(2);
        bubbleSort.insert(9); bubbleSort.insert(6); bubbleSort.insert(1);

        bubbleSort.display();
        bubbleSort.bubbleSort();
        bubbleSort.display();
    }

    @Test public void selectSort(){
        BubbleSort bubbleSort = new BubbleSort(12);
        bubbleSort.insert(20); bubbleSort.insert(3); bubbleSort.insert(8);
        bubbleSort.insert(12); bubbleSort.insert(9); bubbleSort.insert(28);
        bubbleSort.insert(6); bubbleSort.insert(17); bubbleSort.insert(2);
        bubbleSort.insert(9); bubbleSort.insert(6); bubbleSort.insert(1);

        bubbleSort.display();
        bubbleSort.selectSort();
        bubbleSort.display();
    }
}