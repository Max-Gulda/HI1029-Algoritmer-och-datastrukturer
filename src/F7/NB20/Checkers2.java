package F7.NB20;

import java.util.Arrays;

public class Checkers2 {
    public static boolean[] northWestDiagonal, northEastDiagonal, columnFree;
    public static boolean[][] board;

    public static void solve(int n){
        board = new boolean[n][n];
        northWestDiagonal = new boolean[n * 2];
        northEastDiagonal = new boolean[n * 2];
        columnFree = new boolean[n];
        Arrays.fill(columnFree, true);
        Arrays.fill(northEastDiagonal, false);
        Arrays.fill(northWestDiagonal, false);
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], false);
        }
        solveGame(board,0);
    }

    private static void solveGame(boolean[][] board,int row){
        if (row >= board.length){
            printBoard(board);
        } else {
          for(int col = 0; col < board.length; col++){
              if(!northEastDiagonal[row+col] && !northWestDiagonal[(row - col) + board.length - 1] && columnFree[col]){
                  //Change state
                  board[row][col] = true;
                  columnFree[col] = false;
                  northEastDiagonal[row+col] = true;
                  northWestDiagonal[(row-col)+board.length-1] = true;

                  //recursive call
                  solveGame(board, row + 1);

                  //backtrack
                  board[row][col] = false;
                  columnFree[col] = true;
                  northEastDiagonal[row+col] = false;
                  northWestDiagonal[(row-col)+board.length-1] = false;
              }
          }
        }
    }

    private static void printBoard(boolean[][] board){
        System.out.println("---------------------");
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board.length; col++){
                System.out.print((board[row][col] ? 1 : 0 ) + " ");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        solve(4);
    }
}
