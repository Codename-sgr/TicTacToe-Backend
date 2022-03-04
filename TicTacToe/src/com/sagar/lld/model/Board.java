package com.sagar.lld.model;

import java.util.List;

public class Board {
	private int size;
	private Cell[][] grid;
	List<Cell> emptyCells;
	List<Player> players;
	
	public Board(int size) {
		// TODO Auto-generated constructor stub
		this.grid=new Cell[size][size];
		this.size=size;
		initializeBoard();
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public int getSize() {
		return size;
	}

	public void initializeBoard() {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				grid[i][j]=new Cell("-");
			}
		}
	}
	
//	public void getEmptyCells() {
//		for(int i=0;i<grid.length;i++) {
//			for(int j=0;j<grid.length;j++) {
//				if(grid[i][j].getValue()=="-") {
//					emptyCells.add(grid[i][j]);
//				}				
//			}
//		}
//	}
	
	public void displayBoard() {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid.length;j++) {
				System.out.print(grid[i][j].getValue()+" ");
				
			}
			System.out.println();
		}
	}

	public boolean isCellEmpty(int x, int y) {
		// TODO Auto-generated method stub
		if(grid[x][y].getValue().equals("-")) {
			return true;
		}
		return false;
	}

	public void setPlayersNextPiece(Player currentPlayer, int x, int y) {
		// TODO Auto-generated method stub
		grid[x][y].setValue(currentPlayer.getPlayerPiece());
		
	}

	public boolean hasPlayerWon(Player currentPlayer, int x, int y) {
		// TODO Auto-generated method stub
		//check column
		String piece=currentPlayer.getPlayerPiece();
		for(int i=0;i<grid.length;i++) {
			if(grid[i][y].getValue()!=piece) {
				break;
			}
			if(i==grid.length-1)
				return true;
		}
		
		//check row
		for(int i=0;i<grid.length;i++) {
			if(grid[x][i].getValue()!=piece) {
				break;
			}
			if(i==grid.length-1)
				return true;
		}
		
		//check diagonal
		if(x==y) {
			for(int i = 0; i < grid.length; i++){
                if(grid[i][i].getValue() != piece)
                    break;
                if(i == grid.length-1){
                	return true;
                }
            }
		}
		
		//check anti-diagonal
		if(x+y==grid.length-1) {
			for(int i = 0; i < grid.length; i++){
                if(grid[i][grid.length-1-i].getValue() != piece)
                    break;
                if(i == grid.length-1){
                	return true;
                }
            }
		}
		
		return false;
	}
}
