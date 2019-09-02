package com.lhfeiyu.tech.structure.tree;

/**
 * https://www.cnblogs.com/yangecnu/p/Introduce-Binary-Search-Tree.html
 * https://www.cnblogs.com/gaochundong/p/binary_search_tree.html#delete-node
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable> {

    static class BinaryNode<T extends Comparable> {

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        T             element;
        BinaryNode<T> left;
        BinaryNode<T> right;
    }

    BinaryNode<T> root = null;

    public void initData(BinaryNode<T> root) {
        this.root = root;
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

    private T findMax(BinaryNode<T> node) {
        if (null == node.right) {
            return node.element;
        }
        return findMax(node.right);
    }

    public T findMin() {
        return findMin(root);
    }

    private T findMin(BinaryNode<T> node) {
        if (null == node.left) {
            return node.element;
        }
        return findMin(node.left);
    }

    private BinaryNode<T> findMinNode(BinaryNode<T> node) {
        if (null == node.left) {
            return node;
        }
        return findMinNode(node.left);
    }

    public boolean contains(T data) {
        return contains(data, root);
    }

    private boolean contains(T data, BinaryNode<T> node) {
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

    private void print(BinaryNode<T> node) {
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

    private BinaryNode<T> insert(T data, BinaryNode<T> node) {
        if (null == data) {
            return node;
        }
        if (null == node) {
            return new BinaryNode<>(data, null, null);
        }
        int result = data.compareTo(node.element);
        if (result > 0) {
            node.right = insert(data, node.right);
        } else if (result < 0) {
            node.left = insert(data, node.left);
        } else {
            // duplicate, do nothing
        }
        return node;
    }

    public void remove(T data) {
        root = remove(data, root);
    }

    private BinaryNode<T> remove(T data, BinaryNode<T> node) {
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
            BinaryNode<T> right_min = findMinNode(node.right);
            node.element = right_min.element;
            node.right = remove(right_min.element, right_min.right);
        } else {
            return node.left == null ? node.right : node.left;
        }

        return node;

    }

}

