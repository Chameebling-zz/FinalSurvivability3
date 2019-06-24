package map;

/*
 * Interaction.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

// This class isn't really being used, but is supposed to allow interactions with entities.
public class Interaction {
	
	private char key;
	private String name, actionCommand;
	
	public Interaction(char key, String name, String actionCommand){
		this.key = key;
		this.name = name;
		this.actionCommand = actionCommand;
	}
	
}
