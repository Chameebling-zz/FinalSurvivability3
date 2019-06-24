package map;

import main.*;

import java.util.*;

/*
 * ChunkComponent.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class ChunkComponent {
   	
	// An ArrayList of all the parts!
	private ArrayList<ChunkPart> parts;
	
	// An ArrayList of the hitboxes!
 	private ArrayList<HitBox> hitboxes;  
	
	// Constructs a ChunkComponent and constructing the ArrayList fields!
	public ChunkComponent(){
		parts = new ArrayList<ChunkPart>();
		hitboxes = new ArrayList<HitBox>();
	}
	
	// Add a Part to this ChunkComponent!
	public void add(ChunkPart p) {
		parts.add(p);
		hitboxes.add(new HitBox(0, 0, 0, Main.IMAGE_SIZE, 0, Main.IMAGE_SIZE));
	}
	
	// Get the parts of this ChunkComponent!
	public Part[] getParts() {
		return parts.toArray(new Part[parts.size()]);
	}
	
	// Get a specific part of this ChunkComponent!
	public Part getPart(int index) {
		return parts.get(index);
	}
	
	// Get the HitBox within a passed coordinate or return null!
	public HitBox getHitBox(int x, int y, int z){
		for(int i = 0; i < hitboxes.size(); i++){
			HitBox hb = hitboxes.get(i);
			int x1 = hb.getX();
			int y1 = hb.getY();
			int z1 = hb.getZ();
			
			int dx = hb.getDx();
			int dy = hb.getDy();
			int dz = hb.getDz();
			
			int x2 = x1 + dx;
			int y2 = y1 + dy;
			int z2 = z1 + dz;
			
			// Checks if the passed coordinate is within the hit box boundary!
			if( (x>=x1 && x<=x2) && (y>=y1 && y<=y2) && (z>=z1 && z<=z2) ){
				return hb;
			}
		}
		return null;
	}
}
