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

}