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
        if (null == root) {
            root = new BinaryNode<>(data, null, null);
        }
        insert(data, root);
    }

    private void insert(T data, BinaryNode<T> node) {
        if (null == data) {
            return;
        }
        if (null == node) {
            return;
        }
        if (node.element.compareTo(data) > 0) {
            if (null == node.left) {
                node.left = new BinaryNode<>(data, null, null);
                return;
            }
            insert(data, node.left);
        } else if (node.element.compareTo(data) < 0) {
            if (null == node.right) {
                node.right = new BinaryNode<>(data, null, null);
                return;
            }
            insert(data, node.right);
        } else {
            node.element = data;
        }
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
        if (node.element.compareTo(data) > 0) {
            node.left = remove(data, node.left);
        } else if (node.element.compareTo(data) < 0) {
            node.right = remove(data, node.right);
        } else {
            BinaryNode<T> target_node = node;
            if (null == target_node.right) {
                return target_node.left;
            } else if (null == target_node.left) {
                return target_node.right;
            } else {
                BinaryNode<T> right_min = findMinNode(target_node.right);

                node.right = right_min.right;

                return node;
            }

        }

        return node;

    }

}

