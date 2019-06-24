package main;


import assets.*;
import map.*;
import render.*;
import screen.*;
import settings.*;

import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

/*
 * Main.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class Main implements Runnable {
	
	// --- CHANGE THIS SO THAT FILES ARE REACHABLE! ---
	public static final String REL_PATH_TO_FILES = "../";
	
	// Constant string for the version.
	public static final String VERSION = "0.1";
	
	// Sets frames per second for the Runnable interface using delta and while loops.
	public static final int FPS = 60;
	
	// Sets the image size for the parts per meter.
	public static final int IMAGE_SIZE = 64;
	
	// The current map used for the game and the map that the player will be in.
	private GameMap currMap;
	
	// The thread used for the Runnable interface.
	private Thread thread;
	
	// Boolean for when the program is running or not.
	private boolean running;
	
	// The window that is used to display the game on.
	private GameFrame frame;
	
	// The screens used in the game
	private Screen launch, title, game;
	
	public static void main(String[] args) {
		
		// Loads fonts and images into the game!
		Fonts.loadFonts();
		Images.loadImages();
		
		new Main();

	}
	
	// Constructs to allow for the "this" keyword to be used.
	public Main() {
	
		thread = new Thread(this);
		frame = new GameFrame("Survivability 3", 1280, 720);
		
		launch = new LaunchScreen(frame, "Launch Screen", 1920, 1080);
		frame.addScreen(launch);		
		
		currMap = new GameMap("Room 319",25,25);
		
		initTitleScreen();
		initGameScreen();
		
		frame.switchScreen("Title Screen");
		
		// Start the thread!
		start();
	}
	
	// Initializes the title screen!
	private void initTitleScreen() {
		
		title = new TitleScreen(currMap, frame, "Title Screen", 1920, 1080);
		
		frame.addScreen(title);
		
	}
	
	// Initializes the game screen!
	public void initGameScreen(){
		game = new GameScreen(currMap, frame, "Game", 1920, 1080);
		
		frame.addScreen(game);
	}
	
	// Starts the thread!
	private synchronized void start() {
		running = true;
		thread.start();
	}
	
	// Stops the thread!
	public synchronized void stop() {
		running = false;
	}
	
	// Runnable interface method. Runs things at desired FPS.
	public void run() {
		
		long upTime = System.nanoTime();
		double ns = 1E9 / FPS;
		double delta = 0;
		frame.requestFocus();
		
		while(running) {
			
			long current = System.nanoTime();
			delta += (current - upTime) / ns;
			upTime = current;
			
			while(delta >= 1) {
				
				// THINGS TO RUN AT DESIRED FPS \/ \/ \/
				
				frame.run();
								
				delta--;
			}
		}
	}
}
