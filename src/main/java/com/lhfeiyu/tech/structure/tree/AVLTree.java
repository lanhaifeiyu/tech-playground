package com.lhfeiyu.tech.structure.tree;

import org.jetbrains.annotations.Contract;

/**
 * @param <T>
 */
public class AVLTree<T extends Comparable> {

    static class AVLNode<T extends Comparable> {

        AVLNode(T element, AVLNode<T> left, AVLNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

        T          element;
        AVLNode<T> left;
        AVLNode<T> right;
        int        height;

    }

    private static final int ALLOWED_INBANLANCE = 1;

    AVLNode<T> root = null;

    public void initData(AVLNode<T> root) {
        this.root = root;
    }

    private int height(AVLNode<T> node) {
        return node == null ? -1 : node.height;

    }

    private AVLNode<T> balance(AVLNode<T> node) {
        if (null == node) {
            return null;
        }
        if (height(node.left) - height(node.right) > ALLOWED_INBANLANCE) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rotateWithLeftChild(node);
            } else {
                node = doubleWithLeftChild(node);
            }
        } else if (height(node.right) - height(node.left) > ALLOWED_INBANLANCE) {
            if (height(node.right.right) >= height(node.right.left)) {
                rotateWithRightChild(node);
            } else {
                doubleWithRightChild(node);
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private AVLNode<T> rotateWithLeftChild(AVLNode<T> k2) {
        AVLNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AVLNode<T> doubleWithLeftChild(AVLNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AVLNode<T> rotateWithRightChild(AVLNode<T> k2) {
        AVLNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.right), k2.height) + 1;
        return k1;
    }

    private AVLNode<T> doubleWithRightChild(AVLNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    public boolean isEmpty() {
        return null == root;
    }

    public void makeEmpty() {
        root = null;
    }

    public T findMax() {
        return findMax(root);
    }

    private T findMax(AVLNode<T> node) {
        if (null == node.right) {
            return node.element;
        }
        return findMax(node.right);
    }

    public T findMin() {
        return findMin(root);
    }

    private T findMin(AVLNode<T> node) {
        if (null == node.left) {
            return node.element;
        }
        return findMin(node.left);
    }

    private AVLNode<T> findMinNode(AVLNode<T> node) {
        if (null == node.left) {
            return node;
        }
        return findMinNode(node.left);
    }

    public boolean contains(T data) {
        return contains(data, root);
    }

    private boolean contains(T data, AVLNode<T> node) {
        if (null == node) {
            return false;
        }
        if (node.element.compareTo(data) == 0) {
            return true;
        } else if (node.element.compareTo(data) > 0) { // >
            return contains(data, node.left);
        } else if (node.element.compareTo(data) < 0) { // <
            return contains(data, node.right);
        }
        return false;
    }

    public void print() {
        print(root);
    }

    private void print(AVLNode<T> node) {
        if (null == node) {
            return;
        }
        if (null != node.left) {
            print(node.left);
        }
        System.out.println(node.element);
        if (null != node.right) {
            print(node.right);
        }
    }

    public void insert(T data) {
        root = insert(data, root);
    }

    private AVLNode<T> insert(T data, AVLNode<T> node) {
        if (null == data) {
            return node;
        }
        if (null == node) {
            return new AVLNode<>(data, null, null);
        }
        int result = data.compareTo(node.element);
        if (result > 0) {
            insert(data, node.right);
        } else if (result < 0) {
            insert(data, node.left);
        } else {
            // duplicate, do nothing
        }
        return balance(node);
    }

    public void remove(T data) {
        root = remove(data, root);
    }

    private AVLNode<T> remove(T data, AVLNode<T> node) {
        if (null == data) {
            return node;
        }
        if (null == node) {
            return null;
        }
        int result = data.compareTo(node.element);
        if (result > 0) {
            node.right = remove(data, node.right);
        } else if (result < 0) {
            node.left = remove(data, node.left);
        } else if (null != node.right && null != node.left) {
            AVLNode<T> right_min = findMinNode(node.right);
            node.element = right_min.element;
            node.right = remove(right_min.element, right_min.right);
        } else {
            return node.left == null ? node.right : node.left;
        }

        return balance(node);

    }

}

