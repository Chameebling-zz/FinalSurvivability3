package screen.compo;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;

import screen.Screen;

/*
 * GameText.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class GameText extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8974514423985332340L;
	
	// The game syle of the JLabel!
	public GameText(Screen s, String text, int x, int y, int width, int height) {
		super(text);
		setBounds(x, y, width, height);
		setForeground(Color.WHITE);
	}
}
