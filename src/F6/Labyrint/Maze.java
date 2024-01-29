package F6.Labyrint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
	
	int rows,columns;
	public enum Cell{WALL,OPEN,CORRECT,VISITED};
	private Position currentP,goal;
	Cell[][] mazeMatrix;
	
	
	public Maze(){
		try{
			BufferedReader in = new BufferedReader(new FileReader("src/F6/Labyrint/Labyrint3.txt"));
			rows = Integer.parseInt(in.readLine())+2;
			columns = Integer.parseInt(in.readLine())+2;
			mazeMatrix = new Cell[rows][columns];
			for(int j=0;j<columns;j++){
				mazeMatrix[0][j] = Cell.WALL;
				mazeMatrix[rows-1][j] = Cell.WALL;
			}
			for(int i=1;i<rows-1;i++){
				mazeMatrix[i][0] = Cell.WALL;
				mazeMatrix[i][columns-1] = Cell.WALL;
			}
			for(int i=1;i<rows-1;i++){
				String s = in.readLine();
				for(int j=1;j<columns-1;j++){
					mazeMatrix[i][j]=Cell.OPEN;
					if(s.charAt(j-1)=='*')
						mazeMatrix[i][j]=Cell.WALL;
					else if(s.charAt(j-1)=='g'){
						goal = new Position(i,j);
					}
					else if(s.charAt(j-1)=='s'){
						currentP = new Position(i,j);
					}
				}
			}
			in.close();
		}catch(IOException e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
	private class Position{
		int row,column;
		public Position(int r, int c){
			row=r;
			column=c;
		}
		
		public boolean equals(Position p){
			return (row==p.row&&column==p.column);
		}

		@Override
		public String toString(){
			return "Row : " + Integer.toString(row) + "Col : " + Integer.toString(columns);
		}
	}
	
	public boolean solve(){
		return solve(currentP);
	}
	private boolean solve(Position p){
		if (p.equals(goal)) {
			mazeMatrix[p.row][p.column] = Cell.CORRECT;
			return true;
		}
		if(mazeMatrix[p.row][p.column] == Cell.VISITED || mazeMatrix[p.row][p.column] == Cell.WALL) return false;

		mazeMatrix[p.row][p.column] = Cell.VISITED;

		if(solve(new Position(p.row+1,p.column))){ //Move down
			mazeMatrix[p.row+1][p.column] = Cell.CORRECT;
			return true;
		}
		if(solve(new Position(p.row,p.column+1))){ //Move right
			mazeMatrix[p.row][p.column+1] = Cell.CORRECT;
			return true;
		}
		if(solve(new Position(p.row-1,p.column))){ //Move up
			mazeMatrix[p.row-1][p.column] = Cell.CORRECT;
			return true;
		}
		if(solve(new Position(p.row,p.column-1))){ //Move left
			mazeMatrix[p.row][p.column-1] = Cell.CORRECT;
			return true;
		}

		//mazeMatrix[p.row][p.column] = Cell.OPEN;
		return false;
	}
	
	public void print(){
		for(int i=1;i<rows-1;i++){
			for(int j=1;j<columns-1;j++)
				System.out.print(mazeMatrix[i][j].ordinal());
			System.out.println();
		}
	}

}
