package settings;

import java.util.*;
import java.io.*;

/*
 * Setting.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

// This class is not in use!!

public class Setting {
	
	private HashMap<Integer, String> map;
	
	private String name;
	private int currentSettingKey;
	
	public Setting(String name){
		
		map = new HashMap<Integer, String>();
		
		this.name = name;
		currentSettingKey = 1;
		
	}
	
	public void add(String optionName){
		map.put(map.size()+1,optionName);
	}
	
	public String getName(){
		return name;
	}
	
	public String getValueName(){
		return map.get(currentSettingKey);
	}
	
}
