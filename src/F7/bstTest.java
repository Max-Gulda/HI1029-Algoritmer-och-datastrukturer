package F7;

public class bstTest<E extends Comparable<E>>{

    private class Node<E>{
        Node<E> right, left;
        E data;
        public Node(E data){
            this.data = data;
        }
        @Override
        public String toString() {
            return data.toString();
        }
    }
    private Node<E> root;
    private E deletedData;

    public bstTest(){
        root = null;
        deletedData = null;
    }
    public boolean add(E item){
        if(root == null) root = new Node<>(item);
        return add(root, item);
    }

    private boolean add(Node<E> node, E item){
        if(node.data.compareTo(item) == 0) return false;
        if(node.data.compareTo(item) < 0){
            if(node.right == null){
                node.right = new Node<>(item);
                return true;
            }else{
                return add(node.right, item);
            }
        } else {
            if(node.left == null){
                node.left = new Node<>(item);
                return true;
            }else{
                return add(node.left, item);
            }
        }
    }
    private Node<E> findMin(Node<E> node){
        if(node.left == null) return node;
        return findMin(node.left);
    }
    private Node<E> delete(Node<E> node, E target){
        if(node == null) return null;
        if (node.data.compareTo(target) > 0) {
            node.left = delete(node.left, target);
        } else if (node.data.compareTo(target) < 0) {
            node.right = delete(node.right, target);
        } else {
            if(deletedData==null){
                deletedData = node.data;
            }
            if(node.right != null && node.left !=null){
                System.out.println("ett");
                Node<E> successor = findMin(node.right);
                node.data = successor.data;
                node.right = delete(node.right, successor.data);
            }else if (node.left != null){
                System.out.println("två");
                return node.left;
            }else{
                return node.right;
            }
        }
        return node;
    }
    public E remove(E target){
        deletedData = null;
        root = delete(root, target);
        return deletedData;
    }

    public E find(E target){
        return find(root, target);
    }

    private E find(Node<E> node, E target){
        if(node==null) return null;
        if(node.data.compareTo(target) == 0) return node.data;
        if(node.data.compareTo(target) < 0){
            return find(node.right,target);
        }
        if(node.data.compareTo(target)>0){
            return find(node.left, target);
        }
        return null;
    }

    private void toString(Node<E> node, StringBuilder sb){
        if(node == null) return;
        toString(node.left, sb);
        if(!sb.isEmpty()) sb.append(" : ");
        sb.append(node.data.toString());
        toString(node.right, sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        bstTest<Integer> bst = new bstTest<>();
        bst.add(500);
        bst.add(50);
        bst.add(25);
        bst.add(100);
        bst.add(98);
        bst.add(1000);
        bst.add(99);
        System.out.println(bst);
        System.out.println("Removing : " + bst.remove(50));
        System.out.println(bst);
    }
}
