package org.vision.github.books.datastructureandalgorithm.chapter5;

import lombok.Data;

import java.util.Objects;

/** @author ganminghui */

public class LinkX {

    /** 链节点对象 */
    @Data protected static class Link {
        public int iData;
        public double dData;
        public Link next;

        public Link(int iData,double dData){ setIData(iData); setDData(dData); }

        public void displayLink(){ System.out.print("{"+iData+", "+dData+"} "); }
    }

    /** 单向链表 */
    protected static class SingleLinkList{
        /** 链表本身存在一个字段用于指向链表头的引用 */
        private Link first;

        public SingleLinkList(){ first = null; }

        /** 判断整个链表是否有链节点 */
        public boolean isEmpty(){ return Objects.isNull(first); }

        /** 插入链表头,返回链表本身,用于连续添加新的链节点。 */
        public SingleLinkList insertFirst(int iData,double dData){
            Link newLink = new Link(iData,dData);
            /** 在没有将新链节点添加到链表中时,first指向的是当前的链表头,将待添加的链节点的next引用指向当前的first,这样链表头就添加新的链节点 */
            newLink.setNext(first);
            /** 新的链节点成新的链表头后,将链表本身的first引用指向刚刚加入的链节点 */
            first = newLink;
            return this;
        }

        /** 移除链表头,first指向新的链表头 */
        public Link deleteFirst(){
            /** 首先拿出当前链表的链表头 */
            Link temp = first;
            /** 然后将链表头的引用指向当前链表头的next引用,那之前的链表头就孤立了,没有引用指向这个链节点,就不存在链表的链条中了 */
            first = first.getNext();
            return temp;
        }

        /** 遍历链表的每个链节点的内容 */
        public void displayList(){
            System.out.println("print link list from first to last");
            Link current = first;
            while (Objects.nonNull(current)){
               current.displayLink();
               current = current.getNext();
            }
            System.out.println();
        }

        /** 单向链表查找某个链节点 */
        public Link find(int key){
            if(isEmpty()) { return null; }
            Link current = first;
            while (Objects.nonNull(current)){
                if(current.getIData() == key) { return current; }
                current = current.getNext();
            }
            return null;
        }

        /** 单向链表删除某个链节点 */
        public Link delete(int key){
            /** 首先要找到关键字所在的链节点,以及它的上一个、下一个链节点 */
            Link previous=null,current=first,next=null;
            if(isEmpty()){ return null; }

            if(current.getIData() == key){ return deleteFirst(); }

            while (Objects.nonNull(current)){
                if(current.getIData() == key){ next = current.getNext(); break; }

                previous = current;
                current = current.getNext();
            }
            if(Objects.nonNull(next)){ previous.setNext(next); return current; }
            return null;
        }
    }

    /** 双端单向链表 */
    protected static class FirstLastLinkList{
        private Link first,last;

        public FirstLastLinkList(){ first = last = null; }

        public boolean isEmpty(){ return Objects.isNull(first); }

        /** 双端单向链表往链头添加链节点 */
        public FirstLastLinkList insertFirst(int iData,double dData){
            Link newLink = new Link(iData,dData);
            newLink.setNext(first);
            /** 如果是空链表,first、last指向都是第一个链节点 */
            if(isEmpty()){ last = first = newLink; return this; }

            first = newLink;
            return this;
        }

        public FirstLastLinkList insertLast(int iData,double dData){
            Link newLink = new Link(iData, dData);

            if (isEmpty()){ first = last = newLink; return this; }

            last.setNext(newLink);
            last = newLink;
            return this;
        }

        /** 移除链表头,first指向新的链表头,没有移除链表尾的方法,因为链表尾不能关联到上一个链节点 */
        public Link deleteFirst(){
            Link temp = first;
            first = first.getNext();

            if(isEmpty()){ last = null;}
            return temp;
        }

        /** 遍历链表的每个链节点的内容 */
        public void displayList(){
            System.out.println("print link list from first to last");
            Link current = first;
            while (Objects.nonNull(current)){
                current.displayLink();
                current = current.getNext();
            }
            System.out.println();
        }
    }

    /** 单向链表实现栈 */
    protected static class SingleLinkListStack{
        private SingleLinkList singleLinkList;

        public SingleLinkListStack(){
            this.singleLinkList = new SingleLinkList();
        }

        public void push(int iData,double dData){
            this.singleLinkList.insertFirst(iData, dData);
        }

        public Link pop(){ return this.singleLinkList.deleteFirst(); }

        public Link peek(){ return this.singleLinkList.first; }

        public boolean isEmpty(){ return this.singleLinkList.isEmpty(); }

        public void displayStack(){
            System.out.println("Stack (top-->bottom): ");
            this.singleLinkList.displayList();
        }
    }

    /** 双端单向链表实现队列(last添加链节点,first移除链节点) */
    protected static class FirstLastLinkListQueue{
        private FirstLastLinkList firstLastLinkList;

        public FirstLastLinkListQueue(){ firstLastLinkList = new FirstLastLinkList(); }

        public void push(int iData,double dData){ firstLastLinkList.insertLast(iData,dData); }

        public Link pop(){ return firstLastLinkList.deleteFirst(); }

        public Link peek(){ return this.firstLastLinkList.first; }

        public boolean isEmpty(){ return this.firstLastLinkList.isEmpty(); }

        public void displayQueue(){
            System.out.println("Queue (front-->rear): ");
            this.firstLastLinkList.displayList();
        }
    }

    /** 有序单向链表,小的放在前面 */
    protected static class SortedSingleLinkList {
        private Link first;

        public SortedSingleLinkList(){ first = null; }

        public boolean isEmpty(){ return Objects.isNull(first); }

        /** 新增链节点,考虑特殊情况(满足的位置first之前,last之后) */
        public void insert(int iData,double dData){
            Link newLink = new Link(iData,dData);
            /** 如果链表是空的,该链节点就是链表头 */
            if(isEmpty()){ first = newLink; return; }

            /** 如果链表不是空的,就需要找到合适的位置(起码得知道上一个链节点和下一个链节点) */
            Link prious = null, next = null, current = first;
            while(Objects.nonNull(current)){
                /** 如果新的链节点符合这里,记录下当前节点 */
                if(iData <= current.getIData()){ next = current; break; }

                prious = current; current = current.getNext();
            }

            if(Objects.isNull(prious)){ newLink.setNext(first); first = newLink; return; }

            if(Objects.isNull(next)){ prious.setNext(newLink); return; }

            prious.setNext(newLink); newLink.setNext(next);
        }

        /** 从链表头移除链节点 */
        public Link remove(){
            Link temp = first;
            first = first.getNext();
            return temp;
        }

        /** 遍历链表的每个链节点 */
        public void displayList(){
            System.out.println("print link list from first to last");
            Link current = first;
            while (Objects.nonNull(current)){
                current.displayLink();
                current = current.getNext();
            }
            System.out.println();
        }
    }

    /** 链节点需要有next、previous的引用 */
    @Data protected static class DoubleLink{
        public int iData;
        public double dData;
        public DoubleLink next;
        private DoubleLink previous;

        public DoubleLink(int iData,double dData){ setIData(iData); setDData(dData); }
        public void displayLink(){ System.out.print("{"+iData+", "+dData+"} "); }
    }

    /** 双向双端链表 */
    protected static class DoubleLinkList {
        private DoubleLink first,last;

        public DoubleLinkList(){ first = last = null; }

        public boolean isEmpty(){ return Objects.isNull(first); }

        /** 链表头添加链节点 */
        public void insertFirst(int iData, double dData){
            DoubleLink doubleLink = new DoubleLink(iData, dData);
            /** 如果是空链表,则first、last都指向这个新的链节点,next和preious不用设置 */
            if(isEmpty()) { first = last = doubleLink; return; }

            /** 待添加的链节点的next指向当前的链表头(first) */
            doubleLink.setNext(first);
            /** 当前的链表头(first)的previous指向待新增的链节点(doubleLink) */
            first.previous = doubleLink;
            /** 链表头指针重新指向新的链节点 */
            first = doubleLink;
        }

        /** 链表尾添加链节点 */
        public void insertLast(int iData,int dData){
            if(isEmpty()){ insertFirst(iData,dData); return; }

            DoubleLink doubleLink = new DoubleLink(iData,dData);

            last.setNext(doubleLink);
            doubleLink.setPrevious(last);
            last = doubleLink;
        }

        /** 从链表头移除 */
        public DoubleLink deleteFirst(){
            DoubleLink temp = first;
            /** 如果链表只有一个链节点,移除后尾节点指向null. */
            if(Objects.isNull(first.getNext())){ last = null; }
            /** 切断当前链表头与第二个链节点的关系 */
            first.getNext().setPrevious(null);
            /** 重新给first指向 */
            first = first.getNext();
            return temp;
        }

        /** 从链表尾移除 */
        public DoubleLink deleteLast(){
            DoubleLink temp = last;
            /** 如果链表只有一个节点,将first指向null */
            if(Objects.isNull(last.getPrevious())){ first = null; }
            /** 切断倒数第二个链节点与倒数第一个链节点的关系 */
            last.getPrevious().setNext(null);
            /** 指定新的last */
            last = last.getPrevious();
            return temp;
        }

        public boolean insertAfter(int key,double dData){
            DoubleLink current = first;

            while (current.getDData() != key){
                current = current.next;
                if(Objects.isNull(current)) { return false; }
            }

            DoubleLink newLink = new DoubleLink(key,dData);
            if(current == last){ last = newLink; }
            else {
                newLink.next = current.next;
                current.next.previous = newLink;
            }
            current.next = newLink;
            newLink.previous = current;
            return true;
        }

    }


}