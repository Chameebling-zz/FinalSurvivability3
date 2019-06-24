package screen.compo;

import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

import assets.Fonts;
import screen.Screen;

/*
 * SubButton.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class SubButton extends GameButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7244927868216263168L;
	
	// The button with the content font!
	public SubButton(Screen s, final String name, int x, int y, int width, int height, String actionCommand) {
		super(s, name, x, y, width, height, actionCommand);
		setFont(Fonts.CONTENT);
		s.add(this);
	}

}
