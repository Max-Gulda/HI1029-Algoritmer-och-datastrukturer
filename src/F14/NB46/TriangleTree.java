package F14.NB46;

import java.util.HashMap;

public class TriangleTree {
    public static int maxSumBottomUp(int[][] triangle) {
        int[] dp = triangle[triangle.length - 1].clone();

        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.max(dp[j], dp[j + 1]) + triangle[i][j];
            }
        }
        return dp[0];
    }

    public static int max(Node current) {
        return maxPath(current, new HashMap<>());
    }
    public static int maxPath(Node current, HashMap<Node, Integer> memo){
        if(current == null) return 0;
        if(memo.containsKey(current)) return memo.get(current);
        int result = maxPath(current.leftChild, memo) + current.value;
        result = Math.max(result, maxPath(current.rightChild, memo) + current.value);
        memo.put(current, result);
        return result;
    }

    public static class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

    public static Node buildTriangleTree(int[][] triangle) {
        Node root = new Node(triangle[0][0]);
        Node[][] nodeTriangle = new Node[triangle.length][];

        nodeTriangle[0] = new Node[]{root};

        for (int i = 1; i < triangle.length; i++) {
            nodeTriangle[i] = new Node[triangle[i].length];
            for (int j = 0; j < triangle[i].length; j++) {
                nodeTriangle[i][j] = new Node(triangle[i][j]);
                if (j < triangle[i - 1].length) {
                    nodeTriangle[i - 1][j].rightChild = nodeTriangle[i][j];
                }
                if (j > 0) {
                    nodeTriangle[i - 1][j - 1].leftChild = nodeTriangle[i][j];
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        Node root = buildTriangleTree(triangle);

        System.out.println(max(root));
        System.out.println(maxSumBottomUp(triangle));

    }
}
