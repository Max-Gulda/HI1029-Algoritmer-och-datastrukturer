package LABA.uppgift7;

import java.util.Arrays;

public class Game {
    private Integer[][] board;
    private int size;
    private int solutions;

    public Game(int size, int x, int y) {
        this.size = size;
        board = new Integer[size][size];
        for (int j = 0; j < size; j++) {
            Arrays.fill(board[j], 0);
        }
        board[x-1][y-1] = 8;

        solutions = 0;
    }

    private boolean puzzlePiece1(int x, int y) {
        if (x == size - 1 || board[x + 1][y] != 0 || board[x][y + 1] != 0 || board[x + 1][y + 1] != 0) {
            return false;
        }
        board[x + 1][y] = 1;
        board[x][y + 1] = 1;
        board[x + 1][y + 1] = 1;
        return true;
    }

    private boolean puzzlePiece2(int x, int y) {
        if (x == size - 1 || board[x][y] != 0 || board[x][y + 1] != 0 || board[x + 1][y + 1] != 0) {
            return false;
        }
        board[x][y] = 2;
        board[x][y + 1] = 2;
        board[x + 1][y + 1] = 2;
        return true;
    }

    private boolean puzzlePiece3(int x, int y) {
        if (x == size - 1 || board[x][y] != 0 || board[x + 1][y] != 0 || board[x + 1][y + 1] != 0) {
            return false;
        }
        board[x][y] = 3;
        board[x + 1][y] = 3;
        board[x + 1][y + 1] = 3;
        return true;
    }

    private boolean puzzlePiece4(int x, int y) {
        if (x == size - 1 || board[x][y] != 0 || board[x + 1][y] != 0 || board[x][y + 1] != 0) {
            return false;
        }
        board[x][y] = 4;
        board[x + 1][y] = 4;
        board[x][y + 1] = 4;
        return true;
    }

    private boolean isGrayArea(int x, int y) {
        return x < size - 1 || (x == size - 1 && y < size - 2);
    }

    private boolean checkIfDone(){
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if(board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
    private void layPuzzles(){
        layPuzzles(0,0);
    }
    private void layPuzzles(int x, int y) {

        if (!isGrayArea(x, y)) {
            if (checkIfDone()) {
                solutions++;
                printBoard();
            }
            return;
        }

        if (puzzlePiece1(x, y)) {
            layPuzzles(x, y);
            removepuzzle1(x, y);
        }
        if (puzzlePiece2(x, y)) {
            layPuzzles(x, y);
            removepuzzle2(x, y);
        }
        if (puzzlePiece3(x, y)) {
            layPuzzles(x, y);
            removepuzzle3(x, y);
        }
        if (puzzlePiece4(x, y)) {
            layPuzzles(x, y);
            removepuzzle4(x, y);
        }


        int nextX = (x + 1) % size;
        int nextY = y + (nextX == 0 ? 1 : 0);
        layPuzzles(nextX, nextY);
    }
    private void removepuzzle1(int x,int y){
        board[x + 1][y] = 0;
        board[x][y + 1] = 0;
        board[x + 1][y + 1] = 0;
    }
    private void removepuzzle2(int x,int y){
        board[x][y] = 0;
        board[x][y + 1] = 0;
        board[x + 1][y + 1] = 0;
    }
    private void removepuzzle3(int x,int y){
        board[x][y] = 0;
        board[x + 1][y] = 0;
        board[x + 1][y + 1] = 0;
    }
    private void removepuzzle4(int x,int y){
        board[x][y] = 0;
        board[x + 1][y] = 0;
        board[x][y + 1] = 0;
    }

    public void solve() {
        layPuzzles();
        System.out.println("Number of solutions: " + solutions);
    }

    private void printBoard() {
        System.out.println("Solution: " + solutions);
        for (Integer[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Game game = new Game(5,1,1);
        game.solve();
    }
}