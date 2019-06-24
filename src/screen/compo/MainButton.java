package screen.compo;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import assets.Fonts;
import screen.Screen;

/*
 * MainButton.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class MainButton extends GameButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9148564389770265919L;
	
	// The main button has the main font!
	public MainButton(Screen s, final String name, int x, int y, int width, int height, String actionCommand) {
		super(s, name, x, y, width, height, actionCommand);
		setFont(Fonts.MAIN);
		s.add(this);
	}

}
