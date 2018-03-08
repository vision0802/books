package org.vision.github.books.datastructureandalgorithm.chapter4;

import org.junit.Test;

public class QueueTest {

    @Test public void testCommonQueue(){
        Queue.CommonQueue queue = new Queue.CommonQueue(10);
        queue.insert(10); queue.insert(20); queue.insert(30); queue.insert(40);

        queue.remove(); queue.remove(); queue.remove();

        queue.insert(50); queue.insert(60); queue.insert(70); queue.insert(80);

        while (!queue.isEmpty()){
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    @Test public void testPriorityQueue(){
        Queue.PriorityQueue priorityQueue = new Queue.PriorityQueue(5);
        priorityQueue.insert(30); priorityQueue.insert(50); priorityQueue.insert(10);
        priorityQueue.insert(40); priorityQueue.insert(20);

        while (!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.remove() + " ");
        }
        System.out.println();
    }
}