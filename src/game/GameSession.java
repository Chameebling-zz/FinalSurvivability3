package game;

import map.*;
import screen.CameraScreen;
import screen.GameScreen;

import javax.swing.*;

/*
 * GameSession.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class GameSession {
	
	// Not implemented! The timer for the game to time how long the player should
	// survive for.
	private Timer timer;
	
	// Not implemented into the game! Supposed to track how many coins the player earns
	// during the round.
	private int coinsEarned;
	
	// Not implemented! Supposed to track the number of xp earned suring the round.
	private int xpEarned;
	
	// The field for the Player entity.
	private Player p;
	
	// The field for the map of the round.
	private GameMap map;
	
	// The field for the move and rotation speed for the session!
	private double moveSpeed, rotSpeed;
	
	// Constructs a game session passing a map, game screen, and the
	// time (only param not working).
	public GameSession(GameMap map, GameScreen s, int time) {
		this.map = map;
		p = new Player(this, s, 32, 1, 32, 0, 0, 0);
		moveSpeed = 1;
		rotSpeed = 10;
	}
	
	// Not needed! Was at first an idea to organize code a bit more.
	private void init(){
		
	}
	
	// Getter for the player field! [p]
	public Player getPlayer() {
		return p;
	}
	
	// Getter for the map field! [map]
	public GameMap getMap() {
		return map;
	}
	
	// Getter for the move speed! [moveSpeed]
	public double getMoveSpeed() {
		return moveSpeed;
	}
	
	// Getter for the rotation speed! [rotSpeed]
	public double getRotSpeed() {
		return rotSpeed;
	}

}
