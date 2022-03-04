package com.sagar.lld.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.border.Border;

import com.sagar.lld.model.Board;
import com.sagar.lld.model.Cell;
import com.sagar.lld.model.Player;

public class Game {
	Board board;
	Queue<Player> playersQueue;
	int boardFillCount;
	
	public Game(int size) {
		this.board = new Board(size);
		this.playersQueue = new LinkedList<Player>();
		this.boardFillCount=0;
	}
	
	
	
	
	
	
	//Setting Up Game
	public void setPlayers(List<String> player) {
		List<Player> playersOnBoard=new ArrayList<>();
		List<String> playersQList=new ArrayList<String>();
		for(String p:player) {
			String[] playerDetail=p.split(" ");
			playersOnBoard.add(new Player(playerDetail[1], playerDetail[0]));	
			playersQList.add(playerDetail[1]);
		}
		board.setPlayers(playersOnBoard);
		playersQueue.addAll(playersOnBoard);
	}

	
	
	
	
	
	// GAME LOGIC
	public void startGame() {
		board.displayBoard();
	}


	public boolean playGame(int x, int y) {
		// TODO Auto-generated method stub
		Player currentPlayer=playersQueue.poll();
		Cell[][] grid=board.getGrid();
		if(isCellEmpty(grid,x,y)) {
			setPlayersNextPiece(currentPlayer,x,y);
			board.displayBoard();
			boardFillCount++;
			playersQueue.add(currentPlayer);
			if(hasPlayerWon(currentPlayer,x,y)) {
				System.out.println(currentPlayer.getPlayerName()+" has won!");
				return true;
			}
		}else {
			System.out.println("Already Filled");
			playersQueue.add(currentPlayer);
			playersQueue.add(playersQueue.poll());
		}
		
		if(boardFillCount==board.getSize()*board.getSize()){
			System.out.println("GAME DRAW!");
			return true;
		}
		return false;
		
	}


	private boolean isCellEmpty(Cell[][] grid, int x, int y) {
		// TODO Auto-generated method stub
		if(grid[x][y].getValue().equals("-")) {
			return true;
		}
		return false;
	}


	public boolean hasPlayerWon(Player currentPlayer, int x, int y) {
		// TODO Auto-generated method stub
		Cell[][] grid=board.getGrid();
		String piece=currentPlayer.getPlayerPiece();
		
		//check column
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
	
	
	public void setPlayersNextPiece(Player currentPlayer, int x, int y) {
		// TODO Auto-generated method stub
		Cell[][] grid=board.getGrid();
		grid[x][y].setValue(currentPlayer.getPlayerPiece());
//		board.setGrid(grid);
		
	}
	

}
