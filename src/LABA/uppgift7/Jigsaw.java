package LABA.uppgift7;

import java.util.Arrays;

public class Jigsaw {
    private enum orientation {NE, NW, SW, SE}

    private static int nrOfSolutions;

    public static void solveJigsaw(int row, int col) {
        if (row < 1 || row > 5 || col < 1 || col > 5) throw new UnsupportedOperationException();
        int[][] board = new int[5][5];
        nrOfSolutions = 0;
        initBoard(board);
        board[row - 1][col - 1] = 1;
        solveJigsaw(board, 1, 0, 0);
        System.out.println(nrOfSolutions + " number of solutions!");
    }

    private static void solveJigsaw(int[][] board, int placedPieces, int nextRow, int nextCol) {
        if (placedPieces == 9) {
            printBoard(board);
            nrOfSolutions++;
            return;
        }

        for (int r = nextRow; r < 5; r++) {
            for (int c = (r == nextRow ? nextCol : 0); c < 5; c++) {
                for (orientation o : orientation.values()) {
                    if (placePiece(r, c, o, board, placedPieces + 1)) {
                        int nextR = (c + 1) / 5 + r;
                        int nextC = (c + 1) % 5;
                        solveJigsaw(board,placedPieces+1, nextR, nextC);
                        removePiece(r,c,o,board);
                    }
                }
            }
        }
    }

    private static boolean boardComplete(int[][] board) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (board[row][col] == 0) return false;
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        StringBuilder sb = new StringBuilder("--------------------\n");
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                sb.append(board[row][col]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        sb.append("--------------------\n");
        System.out.println(sb.toString());
    }

    private static boolean placePiece(int row, int col, orientation ori, int[][] board, int number) {
        if (board[row][col] != 0) return false;

        switch (ori) {
            case NE -> {/* x
                           x x */
                if (row == 0 || col == 4) return false;
                if (board[row - 1][col] != 0 || board[row][col + 1] != 0) return false;
                board[row - 1][col] = number;
                board[row][col + 1] = number;
                board[row][col] = number;
            }
            case NW -> {
                if (row == 0 || col == 0) return false;
                if (board[row - 1][col] != 0 || board[row][col - 1] != 0) return false;
                board[row][col] = number;
                board[row - 1][col] = number;
                board[row][col - 1] = number;
            }
            case SE -> {
                if (row == 4 || col == 4) return false;
                if (board[row + 1][col] != 0 || board[row][col + 1] != 0) return false;
                board[row][col] = number;
                board[row + 1][col] = number;
                board[row][col + 1] = number;
            }
            case SW -> {
                if (row == 4 || col == 0) return false;
                if (board[row + 1][col] != 0 || board[row][col - 1] != 0) return false;
                board[row][col] = number;
                board[row + 1][col] = number;
                board[row][col - 1] = number;
            }
            default -> throw new IllegalArgumentException("Invalid orientation: " + ori);
        }
        return true;
    }


    private static void removePiece(int row, int col, orientation ori, int[][] board) {
        switch (ori) {
            case NE -> {
                board[row - 1][col] = 0;
                board[row][col + 1] = 0;
                board[row][col] = 0;
            }
            case NW -> {
                board[row][col] = 0;
                board[row - 1][col] = 0;
                board[row][col - 1] = 0;
            }
            case SE -> {
                board[row][col] = 0;
                board[row + 1][col] = 0;
                board[row][col + 1] = 0;
            }
            case SW -> {
                board[row][col] = 0;
                board[row + 1][col] = 0;
                board[row][col - 1] = 0;
            }
            default -> throw new IllegalArgumentException("Invalid orientation: " + ori);
        }
    }

    private static void initBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            Arrays.fill(board[row], 0);
        }
    }

    public static void main(String[] args) {
        solveJigsaw(1, 1);
    }
}
