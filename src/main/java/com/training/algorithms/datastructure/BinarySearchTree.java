package com.training.algorithms.datastructure;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class BinarySearchTree {

    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        while (true) {
            if (id < current.data && current.left == null) {
                current.left = newNode;
                return;
            } else if (id < current.data) {
                current = current.left;
            } else if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                current = current.right;
            }
        }
    }

    public boolean find(int id) {
        Node current = root;
        while (current != null) {
            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        Node current = root;

        if (current == null) {
            return false;
        }

        if (current.data == id) {
            return delete(null, current);
        }

        while (current != null) {
            if (current.data > id && current.left != null && current.left.data == id) {
                return delete(current, current.left);
            } else if (current.data > id) {
                current = current.left;
            } else if (current.data < id && current.right != null && current.right.data == id) {
                return delete(current, current.right);
            } else {
                current = current.right;
            }
        }
        return false;
    }

    private boolean delete(Node parent, Node deleting) {
        // Case 1: if node to be deleted has no children
        if (deleting.left == null && deleting.right == null) {
            if (deleting == root) {
                root = null;
            } else if (parent.left == deleting) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2 : if node to be deleted has only one child
        else if (deleting.right == null) {
            if (deleting == root) {
                root = deleting.left;
            } else if (parent.left == deleting) {
                parent.left = deleting.left;
            } else {
                parent.right = deleting.left;
            }
        } else if (deleting.left == null) {
            if (deleting == root) {
                root = deleting.right;
            } else if (parent.left == deleting) {
                parent.left = deleting.right;
            } else {
                parent.right = deleting.right;
            }
        } else if (deleting.left != null && deleting.right != null) {

            // now we have found the minimum element in the right sub tree
            Node successor = getSuccessor(deleting);
            if (deleting == root) {
                root = successor;
            } else if (parent.left == deleting) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = deleting.left;
        }
        return true;
    }

//    public boolean delete(int id) {
//        Node parent = root;
//        Node current = root;
//        boolean isLeftChild = false;
//        while (current.data != id) {
//            parent = current;
//            if (current.data > id) {
//                isLeftChild = true;
//                current = current.left;
//            } else {
//                isLeftChild = false;
//                current = current.right;
//            }
//            if (current == null) {
//                return false;
//            }
//        }
//        // if i am here that means we have found the node
//        // Case 1: if node to be deleted has no children
//        if (current.left == null && current.right == null) {
//            if (current == root) {
//                root = null;
//            }
//            if (isLeftChild == true) {
//                parent.left = null;
//            } else {
//                parent.right = null;
//            }
//        }
//        // Case 2 : if node to be deleted has only one child
//        else if (current.right == null) {
//            if (current == root) {
//                root = current.left;
//            } else if (isLeftChild) {
//                parent.left = current.left;
//            } else {
//                parent.right = current.left;
//            }
//        } else if (current.left == null) {
//            if (current == root) {
//                root = current.right;
//            } else if (isLeftChild) {
//                parent.left = current.right;
//            } else {
//                parent.right = current.right;
//            }
//        } else if (current.left != null && current.right != null) {
//
//            // now we have found the minimum element in the right sub tree
//            Node successor = getSuccessor(current);
//            if (current == root) {
//                root = successor;
//            } else if (isLeftChild) {
//                parent.left = successor;
//            } else {
//                parent.right = successor;
//            }
//            successor.left = current.left;
//        }
//        return true;
//    }

    private Node getSuccessor(Node deleleNode) {
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        // check if successor has the right child, it cannot have left child for
        // sure
        // if it does have the right child, add it to the left of
        // successorParent.
        // successsorParent
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    public void rotateRight() {
        //left child becomes root.
        //left child's right becomes old roots left
        //roots right will be old root.

        Node oldRoot = root;
        root = oldRoot.left;
        oldRoot.left = root.right;
        root.right = oldRoot;
    }

    public void rotateLeft() {
        //right child becomes root.
        //old root will become left child of left most smallest left node of new root.

        Node oldRoot = root;
        root = oldRoot.left;
        Node leftSuccessor = root.left;
        if (leftSuccessor == null) {
            root.left = oldRoot;
        }
        while (leftSuccessor.left != null) {
            leftSuccessor = leftSuccessor.left;
        }
        leftSuccessor.left = oldRoot;
    }

    public void display(Node root) {
        if (root == null) {
            System.out.print("Empty Binary Search Tree");
        }
        Map<Integer, ArrayList<String>> nodeLevelMap = new TreeMap<>();
        printTree(root, 1, nodeLevelMap, "R");
        printTree(nodeLevelMap);

    }

    private void printTree(Node root, int treeLevel, Map<Integer, ArrayList<String>> nodeLevelMap, String parentIndicator) {
        if (root != null) {
            printTree(root.left, treeLevel + 1, nodeLevelMap, root.data + "L");
            if (nodeLevelMap.get(treeLevel) == null) {
                nodeLevelMap.put(treeLevel, new ArrayList<>());
            }
            nodeLevelMap.get(treeLevel).add(root.data + "(" + parentIndicator + ")");
            printTree(root.right, treeLevel + 1, nodeLevelMap, root.data + "R");
        }
    }

    private void printTree(Map<Integer, ArrayList<String>> nodeLevelMap) {
        int totalNodeLevel = nodeLevelMap.keySet().size();
        nodeLevelMap.forEach((nodeLevel, nodeValues) -> printTree(totalNodeLevel - nodeLevel, nodeValues));
    }

    private void printTree(Integer spaces, ArrayList<String> nodeValues) {
        nodeValues.forEach(value -> printTree(spaces, value));
        System.out.print("\n");
    }

    private void printTree(Integer spaces, String value) {
        Stream.iterate(0, n -> n + 1).limit(spaces).forEach(integer -> System.out.print(" "));
        System.out.print(value);
    }

    public static void main(String arg[]) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(3);
        b.insert(8);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(9);
        b.insert(20);
        b.insert(25);
        b.insert(15);
        b.insert(16);
        System.out.println("Original Tree : ");
        b.display(b.root);
        System.out.println("");
        System.out.println("Check whether Node with value 4 exists : " + b.find(4));
        System.out.println("Delete Node with no children (2) : " + b.delete(2));
        b.display(b.root);
        System.out.println("\n Delete Node with one child (4) : " + b.delete(4));
        b.display(b.root);
        System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));
        b.display(b.root);

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

}
