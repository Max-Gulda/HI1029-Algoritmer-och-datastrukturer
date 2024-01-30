package F6.NB19;

import java.util.ArrayList;
import java.util.List;

public class Marbles {

    public enum Marble{EMPTY, WHITE, BLACK};
    public static Marble[] board;

    public static void solveGame(){
        board = new Marble[]{Marble.BLACK, Marble.BLACK, Marble.BLACK, Marble.EMPTY, Marble.WHITE, Marble.WHITE, Marble.WHITE};
        List<String> moves = new ArrayList<>();
        solve(board, moves);
    }
    private static void solve(Marble[] board, List<String> moves){
        if(gameComplete(board)){
            for(String str: moves){
                System.out.print(str);
            }
            System.out.println(" ");
        }
        for(int i = 0; i < board.length; i++){
            if(canMoveRight(board, i)){ //Slide to the right
                //Update state
                board[i+1] = Marble.BLACK;
                board[i] = Marble.EMPTY;
                moves.add(i + "->" + (i+1) +", ");

                //recursive call
                solve(board,moves);

                //backtrack
                moves.remove(moves.size() - 1);
                board[i+1] = Marble.EMPTY;
                board[i] = Marble.BLACK;
            }
            if(canJumpRight(board, i)){ //Jump to the right
                //Update state
                board[i+2] = Marble.BLACK;
                board[i] = Marble.EMPTY;
                moves.add(i + "->" + (i+2) +", ");

                //recursive call
                solve(board,moves);

                //backtrack
                moves.remove(moves.size() - 1);
                board[i+2] = Marble.EMPTY;
                board[i] = Marble.BLACK;
            }
            if(canMoveLeft(board, i)){ //Slide to the left
                //Update state
                board[i-1] = Marble.WHITE;
                board[i] = Marble.EMPTY;
                moves.add(i + "->" + (i-1) +", ");

                //recursive call
                solve(board,moves);

                //backtrack
                moves.remove(moves.size() - 1);
                board[i-1] = Marble.EMPTY;
                board[i] = Marble.WHITE;
            }
            if(canJumpLeft(board,i)){ //Jump to the left
                //Update state
                board[i-2] = Marble.WHITE;
                board[i] = Marble.EMPTY;
                moves.add(i + "->" + (i-2) +", ");

                //recursive call
                solve(board,moves);

                //backtrack
                moves.remove(moves.size() - 1);
                board[i-2] = Marble.EMPTY;
                board[i] = Marble.WHITE;
            }
        }
    }

    private static boolean gameComplete(Marble[] board){
        return  board[0].equals(Marble.WHITE) &&
                board[1].equals(Marble.WHITE) &&
                board[2].equals(Marble.WHITE) &&
                board[3].equals(Marble.EMPTY) &&
                board[4].equals(Marble.BLACK) &&
                board[5].equals(Marble.BLACK) &&
                board[6].equals(Marble.BLACK);
    }

    private static boolean canMoveRight(Marble[] board, int index){
        if(index < board.length - 1){
            return board[index + 1].equals(Marble.EMPTY) && board[index].equals(Marble.BLACK);
        }
        return false;
    }
    private static boolean canJumpRight(Marble[] board, int index){
        if(index < board.length - 2){
            return board[index + 2].equals(Marble.EMPTY) && board[index].equals(Marble.BLACK);
        }
        return false;
    }
    private static boolean canMoveLeft(Marble[] board, int index){
        if(index > 0){
            return board[index - 1].equals(Marble.EMPTY) && board[index].equals(Marble.WHITE);
        }
        return false;
    }

    private static boolean canJumpLeft(Marble[] board, int index){
        if(index > 1){
            return board[index -2].equals(Marble.EMPTY) && board[index].equals(Marble.WHITE);
        }
        return false;
    }

    public static void main(String[] args) {
        solveGame();
    }

}
