package screen;

import java.util.*;
import java.awt.*;
import java.awt.Component;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/*
 * GameFrame.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class GameFrame extends JFrame implements ComponentListener {
	
	/**
	 * GameFrame.java
	 * 
	 */
	private static final long serialVersionUID = 942289975349692315L;
	
	// The list of screens that the GameFrame can project!
	private ArrayList<Screen> screens;
	Screen currScreen;
	
	private boolean fullscreen;
	
	public GameFrame(String title, int width, int height) {
		super(title);
		setLayout(null);
		getContentPane().setPreferredSize(new Dimension(width, height));
		setBackground(Color.BLACK);
		
		screens = new ArrayList<Screen>();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setResizable(true);
		setLocationRelativeTo(null);
		
		addComponentListener(this);
		
		setVisible(true);
	}
	
	// What to run from the Runnable interface!
	public void run() {
		
		switchScreen(currScreen.getName());
		currScreen.run();
	}
	
	// Adds a screen to the GameFrame!
	public void addScreen(Screen s) {
		getContentPane().add(s);
		screens.add(s);
		
		if(screens.size()==1) {
			currScreen = s;
			switchScreen(s.getName());
		}
	}
	
	// Returns the current screen displayed on the GameFrame!
	public Screen getCurrentScreen() {
		if(screens.size()>=0) {
			return currScreen;
		} else {
			return null;
		}
	}
	
	// Searches for the screen to return based on screen name!
	public Screen getScreen(String name){
		for(int i = 0; i < screens.size(); i++){
			if(screens.get(i).getName().equals(name)){
				return screens.get(i);
			}
		}
		return null;
	}
	
	// Searches screen by name o switch to!
	public void switchScreen(String name){
		currScreen.endRun();
		setCursor(Cursor.getDefaultCursor());
		for(int i = 0; i < screens.size(); i++){
			Screen s = screens.get(i);
			if(s.getName().equals(name)){
				currScreen = s;
				currScreen.startRun();
				return;
			}
		}
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// Does not do anything
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// Does not do anything
	}
	
	// Makes the screens resize based on the size of this GameFrame!
	@Override
	public void componentResized(ComponentEvent e) {
		for(int i = 0; i < screens.size(); i++) {
			screens.get(i).resize();
		}
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// Does not do anything
	}
}
