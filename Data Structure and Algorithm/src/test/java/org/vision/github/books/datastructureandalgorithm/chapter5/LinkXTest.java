package org.vision.github.books.datastructureandalgorithm.chapter5;

import org.junit.Test;

public class LinkXTest {

    @Test public void testSingleLinkList(){
        LinkX.SingleLinkList singleLinkList = new LinkX.SingleLinkList();
        singleLinkList.insertFirst(1,1.0).insertFirst(2,2.0).insertFirst(3,3.0).insertFirst(4,4.0);
        singleLinkList.displayList();

        System.out.println("find key[3]: " + singleLinkList.find(3));

        System.out.println("delete key[3]:" + singleLinkList.delete(3));

        singleLinkList.displayList();

        while (singleLinkList.isEmpty()){
            System.out.println("Deleted Link:"+singleLinkList.deleteFirst());
            singleLinkList.displayList();
        }
    }

    @Test public void testFirstLastLinkList(){
        LinkX.FirstLastLinkList firstLastLinkList = new LinkX.FirstLastLinkList();
        firstLastLinkList.insertFirst(4,4.0).insertLast(3,3.0).insertFirst(5,5.0).insertLast(2,2.0).insertLast(1,1.0);
        firstLastLinkList.displayList();

        firstLastLinkList.deleteFirst(); firstLastLinkList.deleteFirst();
        firstLastLinkList.displayList();
    }

    @Test public void testSingleLinkListStack(){
        LinkX.SingleLinkListStack singleLinkListStack = new LinkX.SingleLinkListStack();
        singleLinkListStack.push(1,1.0);
        singleLinkListStack.push(2,2.0);
        singleLinkListStack.displayStack();

        singleLinkListStack.push(3,3.0);
        singleLinkListStack.push(4,4.0);
        singleLinkListStack.displayStack();

        System.out.println("peek: " + singleLinkListStack.peek());
        singleLinkListStack.displayStack();
        System.out.println("pop: " + singleLinkListStack.pop());
        singleLinkListStack.displayStack();

    }

    @Test public void testFirstLastLinkListQueue(){
        LinkX.FirstLastLinkListQueue firstLastLinkListQueue = new LinkX.FirstLastLinkListQueue();
        firstLastLinkListQueue.push(1,1.0);
        firstLastLinkListQueue.push(2,2.0);
        firstLastLinkListQueue.displayQueue();

        firstLastLinkListQueue.push(3,3.0);
        firstLastLinkListQueue.push(4,4.0);
        firstLastLinkListQueue.displayQueue();

        System.out.println("peek: " + firstLastLinkListQueue.peek());
        firstLastLinkListQueue.displayQueue();
        System.out.println("pop: " + firstLastLinkListQueue.pop());
        firstLastLinkListQueue.displayQueue();
    }
}