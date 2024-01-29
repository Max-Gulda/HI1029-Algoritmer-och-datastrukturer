package F7.NB20;

import java.util.Arrays;

public class Checkers {

    public static boolean[] diagonalNorthWest, diagonalNorthEast, columnFree;
    public static boolean[][] board;
    public static int size = 0;
    public static void solveGame(int n){
        diagonalNorthEast = new boolean[n * 2];
        diagonalNorthWest = new boolean[n * 2];
        columnFree = new boolean[n];

        board = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], false);
        }
        Arrays.fill(columnFree, true);
        Arrays.fill(diagonalNorthWest, true);
        Arrays.fill(diagonalNorthEast, true);
        solve(board, 0, 0);
    }

    static boolean hasKnightMove(int rad, int col) {
        int[][] knightMoves = { {-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {1, 2}, {2, 1} };

        for (int[] move : knightMoves) {
            int newRow = rad + move[0];
            int newCol = col + move[1];

            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board.length && board[newRow][newCol]) {
                return true;
            }
        }
        return false;
    }

    private static void solve(boolean[][] board, int queensPlaced,int row){
        if(queensPlaced == board.length){ //Won?
            printGrid(board);
        }else{

            for(int col = 0; col < board.length; col++) {
                if (diagonalNorthEast[row + col] && diagonalNorthWest[(row - col) + board.length - 1] && columnFree[col] && !hasKnightMove(row, col)) { //update state
                    board[row][col] = true;
                    columnFree[col] = false;
                    diagonalNorthEast[row + col] = false;
                    diagonalNorthWest[(row - col) + board.length - 1] = false;

                    //recursion call
                    solve(board, queensPlaced + 1, row + 1);
                    //backtrack
                    board[row][col] = false;
                    diagonalNorthEast[row + col] = true;
                    columnFree[col] = true;
                    diagonalNorthWest[(row - col) + board.length - 1] = true;
                }
            }
        }
    }

    static void printGrid(boolean[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        System.out.println("\n----------------\n");
        for (boolean[] booleans : board) {
            for (int j = 0; j < cols; j++) {
                System.out.print(booleans[j] ? "1 " : "0 ");
            }
            System.out.println();
        }
        size++;
    }
    public static void main(String[] args) {
        solveGame(10);
        System.out.println("\n----------------\n");
        System.out.println("Number of solutions : " + size);
    }
}
