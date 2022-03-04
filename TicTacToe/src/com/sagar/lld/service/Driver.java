package com.sagar.lld.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sagar.lld.model.Player;

public class Driver {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		List<Player> players=new ArrayList<Player>();
		for(int i=0;i<2;i++) {
			String player=sc.nextLine();
			String[] playerDetail=player.split(" ");
			players.add(new Player(playerDetail[1], playerDetail[0]));			
		}
		
		int size=3;
		Game game=new Game(size);
		game.setPlayers(players);
		game.startGame();
		
		boolean isGameFinished=false;
		
		while(!isGameFinished) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			if(x>size || y>size) {
				System.out.println("Please Enter Valid Input");
				continue;
			}
				
			isGameFinished= game.playGame(x-1,y-1);
		}
		
	}
}
