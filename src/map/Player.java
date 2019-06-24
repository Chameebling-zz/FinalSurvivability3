package map;

import main.*;
import map.*;
import render.*;
import screen.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;

import game.GameSession;

/*
 * Player.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */


public class Player extends Entity implements KeyListener, MouseListener, MouseMotionListener {
		
	private GameSession session;
	private GameFrame frame;
	private Camera c;
	private GameScreen s;
	private Robot r;
		
	private Point mouseMid;
	
	private boolean[] keys;
	
	private boolean dead;
	
	private double[] eyePos;
	
	private Timer deathInterval;
		
	public Player(GameSession session, GameScreen s, double x, double y, double z,
		      double rx, double ry, double rz) {
		super(session, new double[] {x, y, z}, new double[3], 9.8, true);
		
		hp = 100;
		
		eyePos = new double[3];
		
		rot[0] = rx;
		rot[1] = ry;
		rot[2] = rz;
		
		updateEyePos();
		
		this.session = session;
		frame = s.getFrame();
		c = new Camera(map, s, eyePos, rot, 500);
		try {
			r = new Robot();
		}catch(AWTException e) {
			e.printStackTrace();
		}
		
		mouseMid = new Point();
				
		s.setCam(c);
		
		keys = new boolean[4];
		
		hitboxes.add(new HitBox(0, 0, 0, 32, 32, 32));
		
		this.s = s;
		
		centerMouse();
		
		session.getMap().addEntity(session,0,10,0);
	}
	
	// Runs every time the Runnable interface runs from the main method.
	public void run() {
		if(!dead) {
			s.hideCursor();
			
			// When the player goes above all the chunk components!
			if(pos[1]>=Chunk.MAX_COMPONENTS*Main.IMAGE_SIZE) {
				die("Went too high in the world!");
			}
			
			super.run();
			handleKeys();
			updateEyePos();
			
			// When the player goes below all the chunk components!
			if(pos[1]<0) {
				damage(100,"Fell out of the world!");
			}
			
			// When the player goes in a chunk index less than 0,0.
			if(pos[0]<=-Main.IMAGE_SIZE || pos[2]<=-Main.IMAGE_SIZE){
				damage(100,"Suffocation");
			}
			centerMouse();
		} else {
			
		}
	}
	
	// Updates so that the camera position is 16 units above the player feet.
	private void updateEyePos() {
		eyePos[0] = pos[0];
		eyePos[1] = pos[1] + 16;
		eyePos[2] = pos[2];
	}
	
	// Damage the player by a certain amount and have a cause of damage to use for the cause of 
	// death.
	public void damage(int amt, String cause) {
		if(!dead) {
			hp -= amt;
			if(hp<=0) {
				hp = 0;
				die(cause);
			}
		}
	}
	
	private void die(final String cause) {
		dead = true;
		s.showCursor();
		int[] raster = s.getRaster();
		for(int i = 0; i < raster.length; i++) {
			raster[i] += 100;
		}
		final JLabel label = s.getCauseOfDeathLabel();
		label.setVisible(true);
		JButton button = s.getBackButton();
		button.setVisible(true);
		
		// TimerTask to auto type the cause of death onto the screen in a fancy way!
		TimerTask task = new TimerTask() {
			int i = 0;
			double textType = 0;
			
			public void run() {
				if(textType<cause.length()-1) {
					typewriteCauseOfDeath(label, cause, 
							      (int)textType);
					textType = Math.min(textType+=0.5, cause.length() - 1);
				} else {
					blinkCursor(cause, i);
					i++;
					if(i>8) {
						i = 0;
					}
				}
			}
		};
		deathInterval = new Timer();
		deathInterval.scheduleAtFixedRate(task, 100, 50);
	}
	
	// Typewrites parts accepted by a String and an index int.
	private void typewriteCauseOfDeath(JLabel label, String text, int index) {
		JLabel causeOfDeath = s.getCauseOfDeathLabel();
		text = (" Cause of Death: " + text).substring(0,17+index+1);
		causeOfDeath.setText(text+"_");
	}
	
	// Blink the cursor after typing the cause of death!
	private void blinkCursor(String text, int i) {
		JLabel causeOfDeath = s.getCauseOfDeathLabel();
		if(i>4) {
			text+=" ";
		} else {
			text += "_";
		}
		causeOfDeath.setText("Cause of Death: "+text);
	}
	
	// Centers the mouse in the screen!
	private void centerMouse() {
		
		int absoluteMidX = frame.getX() + frame.getWidth() / 2;
		int absoluteMidY = frame.getY() + frame.getHeight() / 2;
		
		mouseMid.setLocation(absoluteMidX, absoluteMidY);
		
		r.mouseMove(absoluteMidX, absoluteMidY);
	}
	
	// Handles player movement!
	private void handleKeys() {
		double moveSpeed = session.getMoveSpeed();
		if(keys[0]) {
			moveForward();
		}
		if(keys[1]) {
			pos[0]-=-moveSpeed*Math.sin(rot[1]);
			pos[2]-=-moveSpeed*Math.cos(rot[1]);
		}
		if(keys[2]){
			pos[0]+=1/moveSpeed*Math.cos(rot[1]);
			pos[2]+=-1/moveSpeed*Math.sin(rot[1]);
		}
		if(keys[3]){
			pos[0]-=1/moveSpeed*Math.cos(rot[1]);
			pos[2]-=-1/moveSpeed*Math.sin(rot[1]);
		}
	}
	
	// Handles mouse rotation!
	private void handleMouseMovement() {
		
		if(!dead) {
			Point mouseP = MouseInfo.getPointerInfo().getLocation();
			
			int mouseX = (int) mouseP.getX();
			int mouseY = (int) mouseP.getY();
			
			double rotSpeed = session.getRotSpeed();
			
			int difX = mouseX - (int)mouseMid.getX();
			int difY = mouseY - (int)mouseMid.getY();
			
			double rotDifX = rotSpeed * difX/2000;
			double rotDifY = rotSpeed * difY/2000;
						
			if(rot[0]>Math.PI/2 || rot[0]+rotDifY>=Math.PI/2) {
				rot[0] = Math.PI/2;
			}
			
			if(rot[0]<-Math.PI/2 || rot[0]+rotDifY<=-Math.PI/2) {
				rot[0] = -Math.PI/2;
			}
			
			rot[0]-=rotDifY;
			rot[1]+=rotDifX;
		}
	}
	
	// key, mouse, and mouse motion listener interface methods!
	
	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if(!dead) {
			if(k==KeyEvent.VK_UP){
				keys[0] = true;
			}
			if(k==KeyEvent.VK_DOWN) {
				keys[1] = true;
			}
			if(k==KeyEvent.VK_LEFT) {
				keys[2] = true;
			}
			if(k==KeyEvent.VK_RIGHT) {
				keys[3] = true;
			}
			if(k==KeyEvent.VK_SPACE) {
				pos[1]+=25;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k==KeyEvent.VK_UP){
			keys[0] = false;
		}
		if(k==KeyEvent.VK_DOWN) {
			keys[1] = false;
		}
		if(k==KeyEvent.VK_LEFT) {
			keys[2] = false;
		}
		if(k==KeyEvent.VK_RIGHT) {
			keys[3] = false;
		}
	}
	
	public double getDistFromPlayer(double x, double y, double z) {
		return Math.sqrt( Math.pow(pos[0] - x, 2)
				 + Math.pow(pos[1] - y, 2)
				 + Math.pow(pos[2] - z, 2) );
	}
	
	public Timer getDeathInterval() {
		return deathInterval;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		handleMouseMovement();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		handleMouseMovement();
	}

}
