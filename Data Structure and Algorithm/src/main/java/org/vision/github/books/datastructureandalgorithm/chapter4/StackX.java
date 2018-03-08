package org.vision.github.books.datastructureandalgorithm.chapter4;


/**
 * @author ganminghui
 * 栈
 */
public class StackX {
    private long[] array;
    private int maxSize,top;

    /** 构造方法 */
    public StackX(int maxSize){
        array = new long[maxSize];
        this.maxSize = maxSize;
        /** 初始化栈底 */top = -1;
    }

    /** 入栈 */
    public void push(long value){ /** 递增栈顶标志,并入栈 */array[++top] = value; }

    /** 出栈 */
    public long pop(){ /** 递减栈顶标志，并出栈(注意数据还是在栈中,只是标志移动了) */return array[top--]; }

    /** 查看 */
    public long peek(){ return array[top]; }

    /** 是否栈空 */
    public boolean isEmpty(){ return top == -1; }

    /** 是否栈满 */
    public boolean isFull(){ return top == maxSize; }

}