package screen.compo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import assets.Fonts;
import screen.Screen;

/*
 * GameButton.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class GameButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4185776569128905813L;
	
	// The game style of a JButton!
	public GameButton(Screen s, final String text, int x, int y, int width, int height, String actionCommand) {
		super(text);
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(false);
		setBounds(x, y, width, height);
		setForeground(Color.WHITE);
		setHorizontalAlignment(SwingConstants.LEFT);
		setActionCommand(actionCommand);
		addActionListener(s);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setText(text+" >");
			}
			
			public void mouseExited(MouseEvent e) {
				setText(text);
			}
		});
	}

}
