package com.sagar.lld.service;

import java.util.List;
import java.util.Scanner;

import com.sagar.lld.model.Player;

public class GameState {
	Game game;
	int size;
	
	public GameState(int size) {
		// TODO Auto-generated
		this.size=size;
		this.game=new Game(size);
	}	

	public void setPlayers(List<String> players) {
		// TODO Auto-generated method stub
		game.setPlayers(players);
	}

	public void startGame() {
		// TODO Auto-generated method stub
		game.startGame();
		Scanner sc=new Scanner(System.in);
		boolean isGameFinished=false;
		
		while(!isGameFinished) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			if(x>size || y>size || x<0 ||y<0) {
				System.out.println("Please Enter Valid Input");
				continue;
			}
				
			isGameFinished= game.playGame(x-1,y-1);
		}
	}

}
