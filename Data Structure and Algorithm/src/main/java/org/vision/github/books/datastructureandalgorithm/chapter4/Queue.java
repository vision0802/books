package org.vision.github.books.datastructureandalgorithm.chapter4;

/** @author ganminghui */

public class Queue {

    protected static class CommonQueue{
        /** 队列核载 */private int maxSize;
        /** 队列实例 */private long[] array;
        /** 队头指针 */private int front;
        /** 队尾指针 */private int rear;
        /** 队列中元素个数 */private int nItem;

        public CommonQueue(int maxSize){
            this.maxSize = maxSize;
            array = new long[this.maxSize];
            front = 0; rear = -1; nItem = 0;
        }

        /** 将待新增的元素添加到队尾 */
        public void insert(long element){
            /** 队尾指针循环,当指向最大索引时,下一个可能的队尾初始化到-1 */
            rear = maxSize-1 == rear? -1:rear;
            array[++rear] = element;
            nItem ++;
        }

        /** 将队头的元素移除 */
        public long remove(){
            /** 获取当前队头元素,并队头指针加1 */
            long temp = array[front++];
            /** 当队头到队列长度时,将队头指向0 */
            front = maxSize== front ? 0 : front;
            nItem--;
            return temp;
        }

        /** 查看队头元素 */
        public long peekFront(){
            return array[front];
        }

        /** 判断队列是否为空 */
        public boolean isEmpty(){
            return nItem == 0;
        }

        /** 判断队列是否满员 */
        public boolean isFull(){
            return nItem == maxSize;
        }

        /** 查看队列中元素数量 */
        public int size(){
            return nItem;
        }
    }

    protected static class PriorityQueue{
       private int maxSize,nItems;
       private long[] array;

       public PriorityQueue(int maxSize){
           this.maxSize = maxSize;
           array = new long[this.maxSize];
           nItems= 0;
       }

       public void insert(long element){
           if(nItems==0) { array[nItems++] = element; return; }

           int index;
           /** 从队尾逐个比较,不是适合的位置就将比较的元素往后挪一挪 */
           for (index = nItems-1; index >=0 ; index--) {
               if(element > array[index]){
                   array[index+1] = array[index];
               }else {
                   break;
               }
           }
           array[index+1] = element;
           nItems++;
       }

       public long remove(){
           return array[--nItems];
       }

       public long peekMin(){
           return array[nItems-1];
       }

       public boolean isEmpty(){
           return nItems == 0;
       }

       public boolean isFull(){
           return nItems==maxSize;
       }


    }
}