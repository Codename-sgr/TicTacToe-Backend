package com.sagar.lld.service;

import java.net.SecureCacheResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sagar.lld.model.Board;
import com.sagar.lld.model.Player;

public class Game {
	Board board;
	Queue<Player> players;
	int boardFillCount;
	
	public Game(int size) {
		this.board = new Board(size);
		this.players = new LinkedList<Player>();
		this.boardFillCount=0;
	}
	
	
	//Setting Up Game
	public void setPlayers(List<Player> player) {
		for(Player p:player) {
			players.add(p);
		}
		board.setPlayers(player);
	}

	// GAME LOGIC
	public void startGame() {
		
		board.displayBoard();
	}


	public boolean playGame(int x, int y) {
		// TODO Auto-generated method stub
		Player currentPlayer=players.poll();
		if(board.isCellEmpty(x,y)) {
			board.setPlayersNextPiece(currentPlayer,x,y);
			board.displayBoard();
			boardFillCount++;
			players.add(currentPlayer);
			if(hasPlayerWon(currentPlayer,x,y)) {
				System.out.println(currentPlayer.getPlayerName()+" has won!");
				return true;
			}
		}else {
			System.out.println("Invalid Move");
			players.add(currentPlayer);
			players.add(players.poll());
		}
		
		if(boardFillCount==board.getSize()*board.getSize()){
			System.out.println("GAME DRAW!");
			return true;
		}
		return false;
		
	}


	public boolean hasPlayerWon(Player currentPlayer, int x, int y) {
		// TODO Auto-generated method stub
		return board.hasPlayerWon(currentPlayer, x, y);
	}
	
	

}
