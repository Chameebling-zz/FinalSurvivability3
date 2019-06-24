package screen;

import assets.*;

import java.awt.*;
import javax.swing.*;

/*
 * PopUp.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

// All this doesn't work. This was an atempt to add popups onto the screen and then time ran out.

public class PopUp extends Screen {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1471927673208728357L;
	
	private Screen s;
	
	public PopUp(Screen s, String name, int width, int height) {
		super(s.getFrame(), name, width, height);
		
		this.s = s;
						
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}
	
	public void show() {
		s.add(this);
	}
}
