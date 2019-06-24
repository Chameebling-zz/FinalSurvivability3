package screen.compo;

import assets.Fonts;
import screen.Screen;

/*
 * MainText.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class MainText extends GameText {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8218384374376521913L;
	
	// The text with the main font!
	public MainText(Screen s, String text, int x, int y, int width, int height) {
		super(s, text, x, y, width, height);
		setFont(Fonts.MAIN);
		s.add(this);
	}

}
