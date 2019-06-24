package screen.compo;

import javax.swing.SwingConstants;

import assets.Fonts;
import screen.Screen;

/*
 * TitleText.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class TitleText extends GameText {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8256503163549077060L;
	
	// The object to display the title onto the title screen!
	public TitleText(Screen s, String text, int x, int y, int width, int height) {
		super(s, text, x, y, width, height);
		setFont(Fonts.MAIN.deriveFont(100F));
		setHorizontalAlignment(SwingConstants.CENTER);
		s.add(this);
	}

}
