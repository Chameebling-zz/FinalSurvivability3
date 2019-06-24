package settings;

import java.util.*;

/*
 * Settings.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

// This class is not in use!

public class Settings {
	
	private ArrayList<Setting> settings;
	
	public Settings(){
		settings = new ArrayList<Setting>();
	}
	
	public void add(Setting s){
		settings.add(s);
	}
}
