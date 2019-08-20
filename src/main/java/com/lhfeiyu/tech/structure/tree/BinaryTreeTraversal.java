package com.lhfeiyu.tech.structure.tree;


public class BinaryTreeTraversal {

    public static void main(String[] args) {
        demo();
    }


    /**
     *
     */
    public static void demo() {

        BinaryTree<Integer> left21 = new BinaryTree<>(21, null, null);
        BinaryTree<Integer> right22 = new BinaryTree<>(22, null, null);
        BinaryTree<Integer> left11 = new BinaryTree<>(11, null, null);
        BinaryTree<Integer> right12 = new BinaryTree<>(12, null, null);
        BinaryTree<Integer> left1 = new BinaryTree<>(1, left11, right12);
        BinaryTree<Integer> right2 = new BinaryTree<>(2, left21, right22);
        BinaryTree<Integer> root = new BinaryTree<>(0, left1, right2);

        System.out.println("先序遍历");
        preorder_traversal(root);
        System.out.println("中序遍历");
        inorder_traversal(root);
        System.out.println("后序遍历");
        postorder_traversal(root);

    }


    /**
     *
     */
    public static void preorder_traversal(BinaryTree<Integer> node) {
        if (null == node) {
            return;
        }
        System.out.println(node.getElement());
        if (null != node.getLeft()) {
            preorder_traversal(node.getLeft());
        }
        if (null != node.getRight()) {
            preorder_traversal(node.getRight());
        }
    }

    public static void inorder_traversal(BinaryTree<Integer> node) {
        if (null == node) {
            return;
        }
        if (null != node.getLeft()) {
            inorder_traversal(node.getLeft());
        }
        System.out.println(node.getElement());
        if (null != node.getRight()) {
            inorder_traversal(node.getRight());
        }
    }

    public static void postorder_traversal(BinaryTree<Integer> node) {
        if (null == node) {
            return;
        }
        if (null != node.getLeft()) {
            postorder_traversal(node.getLeft());
        }
        if (null != node.getRight()) {
            postorder_traversal(node.getRight());
        }
        System.out.println(node.getElement());
    }


}

