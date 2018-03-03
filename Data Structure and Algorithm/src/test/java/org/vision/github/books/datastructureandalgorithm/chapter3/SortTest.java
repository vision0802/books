package org.vision.github.books.datastructureandalgorithm.chapter3;

import org.junit.Test;

public class SortTest {
    @Test public void bubbleSort() {
        Sort sort = new Sort(12);
        sort.insert(20); sort.insert(3); sort.insert(8);
        sort.insert(12); sort.insert(9); sort.insert(28);
        sort.insert(6); sort.insert(17); sort.insert(2);
        sort.insert(9); sort.insert(6); sort.insert(1);

        sort.display();
        sort.bubbleSort();
        sort.display();
    }

    @Test public void selectSort(){
        Sort sort = new Sort(12);
        sort.insert(20); sort.insert(3); sort.insert(8);
        sort.insert(12); sort.insert(9); sort.insert(28);
        sort.insert(6); sort.insert(17); sort.insert(2);
        sort.insert(9); sort.insert(6); sort.insert(1);

        sort.display();
        sort.selectSort();
        sort.display();
    }

    @Test public void insertSort(){
        Sort sort = new Sort(12);
        sort.insert(20); sort.insert(3); sort.insert(8);
        sort.insert(12); sort.insert(9); sort.insert(28);
        sort.insert(6); sort.insert(17); sort.insert(2);
        sort.insert(9); sort.insert(6); sort.insert(1);

        sort.display();
        sort.insertSort();
        sort.display();
    }
}