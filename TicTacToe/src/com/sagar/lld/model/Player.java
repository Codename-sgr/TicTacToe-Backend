package com.sagar.lld.model;

public class Player {
	private String playerName;
	private String playerPiece;
	
	public Player(String playerName, String playerPiece) {
		this.playerName = playerName;
		this.playerPiece = playerPiece;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerPiece() {
		return playerPiece;
	}
	public void setPlayerPiece(String playerPiece) {
		this.playerPiece = playerPiece;
	}
	
	
}
