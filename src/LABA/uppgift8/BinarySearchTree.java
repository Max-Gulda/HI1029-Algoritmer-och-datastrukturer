package LABA.uppgift8;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {
    private static class Node<E> {
        public E data;
        public Node<E> left;
        public Node<E> right;

        public Node(E dataRef) {
            left = null;
            right = null;
            data = dataRef;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private class State<E> {
        private Node<E> node;
        private int level;

        public State(Node<E> nodeData, int level) {
            this.node = nodeData;
            this.level = level;
        }

        @Override
        public String toString() {
            return node == null ? "null" : node.toString();
        }
    }

    public void printTree() {
        printTree(root);
    }


    private Node<E> root;
    private E deletedData;

    public BinarySearchTree() {
        root = null;
    }

    public boolean add(E element) {
        if(root == null) {
            root = new Node<>(element);
            return true;
        }
        return add(element, root);

    }

    private boolean add(E element, Node<E> node) {
        if(element.compareTo(node.data) == 0) {
            return false;
        } else if(element.compareTo(node.data) < 0) {
            if(node.left == null) {
                node.left = new Node<E>(element);
                return true;
            } else {
                return add(element, node.left);
            }
        } else {
            if(node.right == null) {
                node.right = new Node<>(element);
                return true;
            } else {
                return add(element, node.right);
            }
        }
    }

    private E find(E target, Node<E> node) {
        if(node == null) return null;
        if(target.compareTo(node.data) == 0) return node.data;

        if(target.compareTo(node.data) < 0) {
            return find(target, node.left);
        }
        return find(target, node.right);
    }

    public E find(E target) {
        return find(target, root);
    }

    public E delete(E target) {
        delete(target, root);
        return deletedData;
    }

    private Node<E> delete(E target, Node<E> node) {
        if(node == null) {
            deletedData = null;
            return null;
        } else {
            if(target.compareTo(node.data) < 0) {
                node.left = delete(target, node.left);
                return node;
            } else if(target.compareTo(node.data) > 0) {
                node.right = delete(target, node.right);
                return node;
            } else {
                deletedData = node.data;
                if(node.left == null) {
                    return node.right;
                } else if(node.right == null) {
                    return node.left;
                } else {
                    Node<E> nodeToMove = node.right, parentNodeToMove = node;
                    if(nodeToMove.left == null) {
                        nodeToMove.left = node.left;
                        return nodeToMove;
                    }

                    while (nodeToMove.left != null) {
                        parentNodeToMove = nodeToMove;
                        nodeToMove = nodeToMove.left;
                    }
                    parentNodeToMove.left = nodeToMove.right;
                    node.data = nodeToMove.data;
                    return node;
                }
            }
        }
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if(node == null) return;
        inOrder(node.left, sb);
        sb.append(node.data.toString()).append(": ");
        inOrder(node.right, sb);
    }

    private void preOrder(Node<E> node, StringBuilder sb) {
        if(node == null) return;
        sb.append(node.data.toString()).append(": ");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    private void postOrder(Node<E> node, StringBuilder sb) {
        if(node == null) return;
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.data.toString()).append(": ");
    }

    public E getNextLargest(E data){
        return getNextLargest(root, data);
    }

    private E getNextLargest(Node<E> node, E data){
        if(node==null) return null;
        if(node.data.compareTo(data) > 0){
            E nextLargest = getNextLargest(node.left,data);
            return nextLargest != null ? nextLargest : node.data;
        }
        else{
            return getNextLargest(node.right, data);
        }
    }

    private void printTree(Node<E> node) {
        if(root == null) {
            System.out.println("empty");
            return;
        }
        Queue<State> q = new LinkedList<>();
        q.offer(new State(node, 0));

        while (!q.isEmpty()) {
            int level = q.peek().level;

            while (!q.isEmpty() && q.peek().level == level) {
                State<E> s = q.poll();
                System.out.print(s + " ");
                if(s.node != null) {
                    q.offer(new State<>(s.node.left, level + 1));
                    q.offer(new State<>(s.node.right, level + 1));
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(5);
        bst.add(2);
        bst.add(1);
        bst.add(8);
        bst.add(12);
        System.out.println("The number is : " + bst.getNextLargest(30));
    }
}
