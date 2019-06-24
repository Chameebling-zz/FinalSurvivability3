package screen;

import render.*;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

import assets.Fonts;

/*
 * CameraScreen.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class CameraScreen extends Screen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5647678227801065020L;
	
	private Camera cam;
	
	public CameraScreen(GameFrame frame, String name, int width, int height) {
		super(frame, name, width, height);
		// TODO Auto-generated constructor stub
	}
	
	// Set the camera to render what it sees.
	public void setCam(Camera cam) {
		this.cam = cam;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if(cam!=null) {
			cam.run();
			
			// Draws debug info on the camera pos and rot.
			int debugX = 0;
			int debugY = 100;
			
			g2d.setColor(Color.WHITE);
			g2d.setFont(Fonts.CONTENT.deriveFont(25F));
			try{
				g2d.drawString(cam.posToString(), debugX, debugY);
				g2d.drawString(cam.rotToDeg(), debugX, debugY+50);
			}catch(NullPointerException e) {
				
			}
		}
		super.paintComponent(g);
	}
	
}
