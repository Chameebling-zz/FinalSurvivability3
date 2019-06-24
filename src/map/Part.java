package map;

import java.awt.image.*;

/*
 * Part.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class Part {
	
	// Orientation constants! Only the upward orientation works so far.
	public static final int UP = 0, DOWN = 1, NORTH = 2, SOUTH = 3, EAST = 4, WEST = 5;
	
	protected Entity e;
	protected BufferedImage image;
	protected int orient, x, y, width, length, displacement, chunkX, chunkY, chunkZ;
	
	public Part(Entity e, BufferedImage image, int orient, int x, int y, int width, int length
		    , int displacement){
		this.e = e;
		this.image = image;
		this.orient = orient;
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;
		this.displacement = displacement;
	}
	
	// Getters for the part params! \/
	public BufferedImage getImage() {
		return image;
	}
	
	public int getRGB(int x, int y) {
		return image.getRGB(x, y);
	}
	
	public int getOrient() {
		return orient;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getDisplacement() {
		return displacement;
	}
	
	// Getters for the chunk index! \/
	public int getChunkX() {
		return chunkX;
	}
	
	public int getChunkY() {
		return chunkY;
	}
	
	public int getChunkZ() {
		return chunkZ;
	}
	
	// Getters for the fields for the entity fields! \/
	public int getEntityX() {
		if(e==null) {
			return 0;
		}
		return (int)Math.round(e.getX());
	}
	
	public int getEntityY() {
		if(e==null) {
			return 0;
		}
		return (int)Math.round(e.getY());
	}
	
	public int getEntityZ() {
		if(e==null) {
			return 0;
		}
		return (int)Math.round(e.getZ());
	}
}
