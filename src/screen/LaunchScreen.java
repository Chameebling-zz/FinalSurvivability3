package screen;

import javax.swing.JFrame;
import javax.swing.JLabel;

import assets.*;
import screen.compo.MainText;
import screen.compo.SubText;

/*
 * LaunchScreen.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class LaunchScreen extends Screen {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1252912036773618639L;

	public LaunchScreen(GameFrame frame, String name, int width, int height) {
		super(frame, name, width, height);
		
		// Adds loading text to the screen!
		JLabel loadingText = new MainText(this, "SURVIVABILITY 3 IS LOADING...", 100, 100, 500, 50);
		System.out.println(components);
		loadComponents();
	}
	
	public void run() {
		super.run();
		
		
	}

}
