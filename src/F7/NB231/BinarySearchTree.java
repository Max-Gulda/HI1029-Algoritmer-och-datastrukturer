package F7.NB231;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E> {
        private Node<E> left, right;
        private E data;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<E> root;
    private E deletedData;

    public BinarySearchTree() {
        root = null;
    }


    private Node<E> delete(E target, Node<E> node) {
        if (node == null) {
            deletedData = null;
            return null;
        }
        if (node.data.compareTo(target) > 0) {
            node.left = delete(target, node.left);
        } else if (node.data.compareTo(target) < 0) {
            node.right = delete(target, node.right);
        } else {
            deletedData = node.data;
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node<E> nodeToMove = node.right;
            Node<E> nodeToMoveParent = node;
            if (nodeToMove.left == null) {
                nodeToMove.left = node.left;
            } else {
                while (nodeToMove.left != null) {
                    nodeToMoveParent = nodeToMove;
                    nodeToMove = nodeToMove.left;
                }
                nodeToMoveParent.left = nodeToMove.right;
                nodeToMove.right = node.right;
                nodeToMove.left = node.left;
            }
            node.data = nodeToMove.data;
            if (nodeToMoveParent != node) {
                nodeToMoveParent.left = null;
            }
            return nodeToMove;
        }
        return node;
    }

    private int numberOfLeaves(Node<E> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return numberOfLeaves(node.left) + numberOfLeaves(node.right);
    }

    public int numberOfLeaves() {
        return numberOfLeaves(root);
    }

    private int numberOfNodes(Node<E> node) {
        if (node == null) return 0;
        return numberOfNodes(node.left) + numberOfNodes(node.right) + 1;
    }

    public int numberOfNodes() {
        return numberOfNodes(root);
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        return Math.max(height(node.left) + 1, height(node.right) + 1);
    }

    public int height() {
        return height(root);
    }

    public void printTree() {
        Queue<Node<E>> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        levelQueue.offer(0);
        queue.offer(root);
        Node<E> node;
        int level;
        StringBuilder sb = new StringBuilder();
        int children = 0;
        while (!queue.isEmpty()) {
            node = queue.poll();
            level = levelQueue.poll();

            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
                levelQueue.offer(level + 1);
                levelQueue.offer(level + 1);
                sb.append(node.data.toString()).append(" ");
            } else {
                sb.append("Null ");
            }
            if (!levelQueue.isEmpty() && levelQueue.peek() > level) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public E delete(E target) {
        root = delete(target, root);
        return deletedData;
    }

    private E find(E target, Node<E> current) {
        if (current == null)
            return null;
        else if (current.data.compareTo(target) == 0)
            return current.data;
        else if (current.data.compareTo(target) > 0)
            return find(target, current.left);
        return find(target, current.right);
    }

    public E find(E target) {
        return find(target, root);
    }

    public E findItr(E target) {
        Node<E> current = root;
        while (current != null) {
            if (current.data.equals(target)) return current.data;
            else if (current.data.compareTo(target) < 0) {
                current = current.right;
            } else if (current.data.compareTo(target) > 0) {
                current = current.left;
            }
        }
        return null;
    }

    public E maxRec(){
        if(root == null) return null;
        return maxRec(root);
    }

    private E maxRec(Node<E> node){
        if(node.right == null) return node.data;
        return maxRec(node.right);
    }
    public E maxItr(){
        if(root == null) return null;
        Node<E> node = root;
        while(node.right != null){
            node = node.right;
        }
        return node.data;
    }

    private boolean add(E data, Node<E> current) {
        if (current.data.compareTo(data) == 0) {
            return false;
        }
        if (current.data.compareTo(data) > 0) { // left
            if (current.left != null) {
                return add(data, current.left);
            } else {
                current.left = new Node<>(data);
                return true;
            }
        } else { //right
            if (current.right != null) {
                return add(data, current.right);
            } else {
                current.right = new Node<>(data);
                return true;
            }
        }
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<E>(data);
            return true;
        }
        return add(data, root);
    }

    private void inOrder(Node<E> current, StringBuilder sb) {
        if (current == null) {
            return;
        }
        inOrder(current.left, sb);
        if (!sb.isEmpty()) {
            sb.append(":");
        }
        sb.append(current.data);
        inOrder(current.right, sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.add("H");
        bst.add("B");
        bst.add("N");
        bst.add("A");
        bst.add("E");
        bst.add("C");
        bst.add("F");
        bst.add("D");
        System.out.println(bst);

        System.out.println("This binary tree has " + bst.numberOfLeaves() + " leaves!");
        System.out.println("This binary tree has " + bst.numberOfNodes() + " nodes!");
        System.out.println("This binary tree has a height of " + bst.height());

        bst.printTree();

        System.out.println("Find itterative = " + bst.findItr("C"));

        System.out.println("Max value = " + bst.maxRec());
        System.out.println("Max value = " + bst.maxItr());
    }
}
