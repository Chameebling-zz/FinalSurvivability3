package screen;

import java.util.*;
import java.awt.*;
import java.awt.Component;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

import assets.*;

/*
 * Screen.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class Screen extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8659340140176518549L;

	public static final int MENU_BUTTON = 0;
	public static final int SUB_BUTTON = 1;
	
	protected GameFrame frame;
	protected BufferedImage image;
	protected Graphics2D g2d;
	protected int[] raster;
	
	// ArrayLists for all the JComponents.
	//All the indexes correspond to each other:
	
	// - The JComponents to be on the screen.
	protected ArrayList<JComponent> components;
	
	// - The original bounds of the corresponding JComponents
	//to base off of when resizing.
	protected ArrayList<Rectangle> componentBounds;
	
	// - The original font sizes of the corresponding JComponents
	//to base off of when resizing.
	protected ArrayList<Float> componentFontSizes;
	
	// The ArrayList for the popups that will show on the screen.
	//Not really working.
	protected ArrayList<PopUp> popups;
	
	protected int gameWidth = 1920, gameHeight = 1080;
	protected int resWidth, resHeight;
	
	private String name;
	
	protected double sf;
	
	public Screen(GameFrame frame, String name, int width, int height) {
				
		image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		components = new ArrayList<JComponent>();
		componentBounds = new ArrayList<Rectangle>();
		componentFontSizes = new ArrayList<Float>();
		
		resWidth = width;
		resHeight = height;
		
		g2d = (Graphics2D) image.getGraphics();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
		
		raster = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		
		this.frame = frame;
		this.name = name;
		
		setLayout(null);
		
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		setDoubleBuffered(true);
		
		setFocusable(true);
		
		repaint();
	}
	
	public void startRun() {
		startup();
		loadComponents();
		requestFocusInWindow();
	}
	
	public void endRun() {
		removeAll();
	}
	
	protected void startup() {
		
	}
	
	public void run() {
		repaint();
	}
	
	public void add(JComponent c) {
		components.add(c);
		componentBounds.add(c.getBounds());
		componentFontSizes.add((float) c.getFont().getSize());
		super.add(c);
		resize();
	}
	
	private double getSF(int originalSize, int targetSize) {
		return (double)targetSize / originalSize;
	}
	
	private double getSFToFit() {
		double widthSF = getSF(gameWidth, frame.getContentPane().getWidth());
		double heightSF = getSF(gameHeight, frame.getContentPane().getHeight());
				
		return Math.min(widthSF, heightSF);
	}
	
	private Rectangle getBoundsToFit() {
		double sf = getSFToFit();
		
		int sWidth = (int)Math.round(gameWidth * sf);
		int sHeight = (int)Math.round(gameHeight * sf);
		
		int x = (frame.getContentPane().getWidth() - sWidth) / 2;
		int y = (frame.getContentPane().getHeight() - sHeight) / 2;
		
		return new Rectangle(x, y, sWidth, sHeight);
	}
	
	public GameFrame getFrame(){
		return frame;
	}
	
	// Getter for the BufferedImage field. Getters for fields are below his one also.
	public BufferedImage getImage() {
		return image;
	}
	
	public Graphics2D getGraphics2D() {
		return g2d;
	}
	
	public int[] getRaster() {
		return raster;
	}
	
	public String getName(){
		return name;
	}
	
	public int getWidth() {
		return resWidth;
	}
	
	public int getHeight() {
		return resHeight;
	}
	
	public void loadComponents() {
		
		for(int i = 0; i < components.size(); i++) {
			super.add((Component) components.get(i));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if(action.equals("start")) {
			GameFrame f = (GameFrame) frame;
			f.switchScreen("Game");
		}
	}
	
	protected void runPrior() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		runPrior();
		
		super.paintComponent(g);
		g.drawImage(image, 0, 0, super.getWidth(), super.getHeight(), null);
	}

	public void resize() {
		
		Rectangle r = getBoundsToFit();
		
		setBounds(r);
		
		resWidth = r.width;
		resHeight = r.height;
				
		double sf = getSFToFit();
		for(int i = 0; i < components.size(); i++) {
						
			JComponent c = components.get(i);
			Rectangle cb = componentBounds.get(i);
			float cfs = componentFontSizes.get(i);
			
			int x = cb.x;
			int y = cb.y;
			int width = cb.width;
			int height = cb.height;
			
			int newX = (int)Math.round(x * sf);
			int newY = (int)Math.round(y * sf);
			int newWidth = (int)Math.round(width * sf);
			int newHeight = (int)Math.round(height * sf);
			
			c.setBounds(newX, newY, newWidth, newHeight);
			c.setFont(c.getFont().deriveFont(cfs*(float)sf));
		}
		
	}
	
	public int getResWidth() {
		return resWidth;
	}
	
	public int getResHeight() {
		return resHeight;
	}
	
}
