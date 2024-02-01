package F7.NB21;

import java.util.Scanner;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E>{
        private Node<E> left, right;
        private E data;
        public Node(E data){
            this.data = data;
            left = null;
            right = null;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }

    private Node<E> root;
    private E deletedData;

    public BinarySearchTree(){
        root = null;
    }

    private E find(E target, Node<E> current){
        if (current == null)
            return null;
        else if (current.data.compareTo(target) == 0)
            return current.data;
        else if (current.data.compareTo(target) > 0)
            return find(target, current.left);
        return find(target, current.right);
    }

    private Node<E> delete(E target, Node<E> node) {
        if(node == null){
            deletedData = null;
            return null;
        }
        if(node.data.compareTo(target) > 0) {
            node.left = delete(target, node.left);
        } else if(node.data.compareTo(target) < 0){
            node.right = delete(target, node.right);
        } else {
            deletedData = node.data;
            if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            }
            Node<E> nodeToMove = node.right;
            Node<E> nodeToMoveParent = node;
            if(nodeToMove.left == null) {
                nodeToMove.left = node.left;
            } else {
                while(nodeToMove.left != null) {
                    nodeToMoveParent = nodeToMove;
                    nodeToMove = nodeToMove.left;
                }
                nodeToMoveParent.left = nodeToMove.right;
                nodeToMove.right = node.right;
                nodeToMove.left = node.left;
            }
            node.data = nodeToMove.data;
            if(nodeToMoveParent != node) {
                nodeToMoveParent.left = null;
            }
            return nodeToMove;
        }
        return node;
    }

    public E delete(E target){
        root = delete(target,root);
        return deletedData;
    }
    public E find(E target){
        return find(target, root);
    }

    private boolean add(E data, Node<E> current){
        if(current.data.compareTo(data) == 0){
            return false;
        }
        if(current.data.compareTo(data) > 0){ // left
            if(current.left != null){
                return add(data,current.left);
            }else{
                current.left = new Node<>(data);
                return true;
            }
        } else { //right
            if(current.right != null){
                return add(data, current.right);
            }else{
                current.right = new Node<>(data);
                return true;
            }
        }
    }
    public boolean add(E data){
        if (root == null){
            root = new Node<E>(data);
            return true;
        }
        return add(data, root);
    }
    private void inOrder(Node<E> current, StringBuilder sb){
        if (current == null){
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
    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        Scanner scan = new Scanner(System.in);
        String input = " ";
        for(int i = 0; i < 7; i++){
            System.out.print("Enter string:");
            input = scan.next();
            bst.add(input);
        }
        System.out.println(bst);
    }

}
