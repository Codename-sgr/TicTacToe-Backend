package com.sagar.lld.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sagar.lld.model.Player;

public class Driver {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		List<String> playersAndPiece=new ArrayList<String>();
		for(int i=0;i<2;i++) {
			String player=sc.nextLine();
			playersAndPiece.add(player);		
		}
		
		int size=3;
		GameState gameSate=new GameState(size);		
		gameSate.setPlayers(playersAndPiece);
		gameSate.startGame();
		
		
	}
}
