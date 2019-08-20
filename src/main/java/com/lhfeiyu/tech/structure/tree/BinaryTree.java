package com.lhfeiyu.tech.structure.tree;


/**
 * The type Base tree.
 *
 * @param <T> the type parameter
 */
public class BinaryTree<T> {

    public BinaryTree(T element, BinaryTree<T> left, BinaryTree<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    private T             element;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

}

