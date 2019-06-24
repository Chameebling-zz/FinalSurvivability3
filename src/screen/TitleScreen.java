package screen;

import assets.*;
import game.*;
import map.*;
import render.*;
import screen.compo.MainButton;
import screen.compo.MainText;
import screen.compo.SubButton;
import screen.compo.TitleText;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * TitleScreen.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class TitleScreen extends CameraScreen implements ActionListener {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 632046522747878932L;
	public static final int MAX_DISTORTION_COUNT = 1000;
	
	private Point[] distortions;
		
	private Camera bgCam;
	private GameMap map;
	
	private double[] bgRot;
	private double viewAngle;
	
	public TitleScreen(GameMap map, GameFrame frame, String name, int width, int height) {
		super(frame, name, width, height);
		this.map = map;
		distortions = new Point[MAX_DISTORTION_COUNT];		
		
		bgRot = new double[] {Math.PI, 0, Math.PI};
		
		for(int i = 0; i < TitleScreen.MAX_DISTORTION_COUNT; i++) {
			distortions[i] = new Point();
		}
		
		bgCam = new Camera(map, this, new double[] {32, 25, 32}, bgRot, 100);
		setCam(bgCam);
		
		JLabel title = new TitleText(this, "SURVIVABILITY 3", 0, 25, resWidth, 80);
		
		initStartUI(50,250);
		initMapUI(50,500);
		loadComponents();
		
	}
	
	// Initialize JComponents for the 2 methods below \/
	private void initStartUI(int x, int y) {
		JButton start = new MainButton(this, "START",
					       x,y,500,50,"start");
		JButton editGameSettings = new SubButton(this, "Edit Game Settings...",
							 x,y+50,500,50,"egs");
	}
	
	private void initMapUI(int x, int y) {
		JLabel currMapLabel = new MainText(this, "Map: "+map.getName(),
						   x+15, y, 485, 50);
		JButton changeMap = new SubButton(this, "Click here to Change...",
						  x, y+50,500,50,"cm");
		
	}
	
	public void run() {
		super.run();
		
		Color distort = new Color(127, 127, 127, 200);
 		Graphics2D g2d = getGraphics2D();
 		
 		
 		for(int i = 0; i < TitleScreen.MAX_DISTORTION_COUNT; i++) {
 			
 			int x = (int)(Math.random() * 1920);
			int y = (int)(Math.random() * 1080);
			
 			g2d.setColor(distort);
			g2d.fillRect(x, y, 15, 3);
			
 		}
 		
 		bgRot[1]+=Math.PI / 60;
 		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if(ac.equals("start")){
			
			GameScreen gameScreen = (GameScreen)frame.getScreen("Game");
			GameSession session = new GameSession(map, gameScreen, 300);
			frame.switchScreen("Game");
			gameScreen.setSession(session);
			
		}
	}

}
