package com.thoughtworks.collection;

import java.util.Collection;

public class MySingleLink<T> implements SingleLink<T>{
    private Node<T> head = null;
    private Node<T> tail = null;
    private int length = 0;

    @Override
    public T getHeaderData() {
        return head.getData();
    }

    @Override
    public T getTailData() {
        return tail.getData();
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean deleteFirst() {
        if (head == null) {
            return false;
        }
        head = head.getNext();
        length--;
        return true;
    }

    //删除尾部元素；
    @Override
    public boolean deleteLast() {
        if (tail == null) {
            return false;
        }
        if (head == tail) {
            head = tail = null;
            length--;
            return true;
        }
        Node<T> curNod = head;
        while (curNod.getNext() != tail) {
            curNod = curNod.getNext();
        }
        curNod.setNext(null);
        tail = curNod;
        length--;
        return true;
    }
    //添加头指针
    @Override
    public void addHeadPointer(T item) {
        Node<T> newHead = new Node<T>(item);
        newHead.setNext(head);
        head = newHead;
        length++;
    }
    //添加尾指针
    @Override
    public void addTailPointer(T item) {
        if (tail == null) {
            head = new Node<T>(item);
            tail = head;
        } else {
            Node<T> newTail = new Node<T>(item);
            tail.setNext(newTail);
            tail = newTail;
        }
        length++;
    }
    @Override
    public T getNode(int index) {
        int curIndex = 1;
        // no such Node
        if (size() < index) {
            return null;
        }
        Node<T> curNod = head;
        while (curIndex < index) {
            curNod = curNod.getNext();
            curIndex++;
        }
        return curNod.getData();
    }

    private static class Node<T> {
        private T data;
        private Node<T> next = null;

        public Node(T item) {
            data = item;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
