package screen;

import game.*;
import map.*;
import render.*;
import screen.compo.MainButton;
import screen.compo.SubText;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

/*
 * LaunchScreen.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class GameScreen extends CameraScreen implements ActionListener {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 632046522747878932L;
	
	private GameSession session;
	
	private Player p;
	
	// The JComponents for when the player dies!
	private JLabel causeOfDeath;
	private JButton backButton;
	
	private BufferedImage blankCursorImg;
	private Cursor blankCursor;
	
	public GameScreen(GameMap map, GameFrame frame, String name, int width, int height) {
		super(frame, name, width, height);
		
		causeOfDeath = new SubText(this, "Cause of Death: ", 0, 40, resWidth, 50);
		causeOfDeath.setVisible(false);
		causeOfDeath.setHorizontalAlignment(SwingConstants.CENTER);
		
		backButton = new MainButton(this, "BACK TO TITLE SCREEN", 250, 250, 500, 50, "bts");
		backButton.setVisible(false);
		
		blankCursorImg = new BufferedImage(16,16,BufferedImage.TYPE_INT_ARGB);
		blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(blankCursorImg,new Point(0, 0),"");
	}	
	
	public void startup() {
	}
	
	public void run() {
		
		super.run();
		if(session!=null) {
			session.getPlayer().run();
		}
	}
	
	// Sets the session for the game!
	public void setSession(GameSession session){
		this.session = session;
		p = session.getPlayer();
		addKeyListener(p);
		addMouseListener(p);
		addMouseMotionListener(p);
	}
	
	// Getters for cause of death screen JComponents.
	public JLabel getCauseOfDeathLabel() {
		return causeOfDeath;
	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	// Show and hide the mouse cursor.
	public void hideCursor() {
		frame.setCursor(blankCursor);
	}
	
	public void showCursor() {
		frame.setCursor(Cursor.getDefaultCursor());
	}
	
	@Override
	public void runPrior() {
		if(p!=null && g2d!=null) {
			g2d.drawString(p.getHP()+" HP",50, 250);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if(ac.equals("bts")) {
			p.getDeathInterval().cancel();
			causeOfDeath.setVisible(false);
			backButton.setVisible(false);
			frame.switchScreen("Title Screen");
		}
	}

}
