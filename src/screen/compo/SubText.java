package screen.compo;

import assets.Fonts;
import screen.Screen;

/*
 * SubText.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class SubText extends GameText {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7972312747016978899L;
	
	// The text wih the content font!
	public SubText(Screen s, String text, int x, int y, int width, int height) {
		super(s, text, x, y, width, height);
		setFont(Fonts.CONTENT);
		s.add(this);
	}

}
