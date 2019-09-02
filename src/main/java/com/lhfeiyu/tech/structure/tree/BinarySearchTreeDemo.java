package com.lhfeiyu.tech.structure.tree;


public class BinarySearchTreeDemo {


    public static void main(String[] args) {
        demo();
    }


    /**
     *
     */
    public static void demo() {


        BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();

        BinarySearchTree.BinaryNode<Integer> left21 = new BinarySearchTree.BinaryNode<>(1100, null, null);
        BinarySearchTree.BinaryNode<Integer> right22 = new BinarySearchTree.BinaryNode<>(1300, null, null);
        BinarySearchTree.BinaryNode<Integer> left11 = new BinarySearchTree.BinaryNode<>(400, null, null);
        BinarySearchTree.BinaryNode<Integer> right12 = new BinarySearchTree.BinaryNode<>(600, null, null);
        BinarySearchTree.BinaryNode<Integer> left1 = new BinarySearchTree.BinaryNode<>(500, left11, right12);
        BinarySearchTree.BinaryNode<Integer> right2 = new BinarySearchTree.BinaryNode<>(1200, left21, right22);
        BinarySearchTree.BinaryNode<Integer> root = new BinarySearchTree.BinaryNode<>(1000, left1, right2);

        searchTree.initData(root);

        boolean insert = true;
        if (insert) {
            searchTree.insert(11);
            searchTree.insert(111);
            searchTree.insert(711);
            searchTree.insert(1211);
            searchTree.insert(2211);
        }
        boolean remove = true;
        if (remove) {
            searchTree.remove(11);
            searchTree.remove(711);
            searchTree.remove(2211);
            searchTree.remove(500);
        }

        searchTree.print();

        System.out.println("contains 500:" + searchTree.contains(500));
        System.out.println("contains 5001:" + searchTree.contains(5001));
        System.out.println("isEmpty:" + searchTree.isEmpty());
        System.out.println("max:" + searchTree.findMax());
        System.out.println("min:" + searchTree.findMin());


    }


}

