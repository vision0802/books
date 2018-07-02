package org.vision.github.books.datastructureandalgorithm.chapter8;

import lombok.Data;

/** @author ganminghui */

public class Tree {
    @Data protected static class Node{
        private int iData;
        private double dData;
        private Node leftChild;
        private Node rightChild;

        public void  displayNode(){
            System.out.println(new StringBuilder("{").append(iData).append(",").append(dData).append("}").toString());
        }
    }

    private Node root;

    /** find node with given key */
    public Node find(int key){
        Node current = root;
        while (current.iData != key){
            /** 根据数据值查找current */
            current = key < current.iData ? current.leftChild : current.rightChild;
            if(current == null){ return null; }
        }
        return current;
    }

    public void insert(int id, double dd){
        Node node = new Node();     node.iData = id;    node.dData = dd;
        if(root == null) { root = node; }
        else {
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if(id < current.iData){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = node;
                        return;
                    }
                }else {
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public void delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.iData != key){

        }
    }
}