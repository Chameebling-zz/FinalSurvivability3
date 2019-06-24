package map;

/*
 * Chunk.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class Chunk {
	
	// The maxmimum number of meters/components in terms of height!
	public static final int MAX_COMPONENTS = 8;
	
	// An array of ChunkComponents in a chunk that has an area of 1 square meter in this case!
	private ChunkComponent[] components;
	
	// Constructs a chunk at a certain map index based on x and z!
	public Chunk(){
				
		components = new ChunkComponent[Chunk.MAX_COMPONENTS];
		
		// Initializes and constructs all the ChunkComponents!
		for(int i = 0; i < components.length; i++) {
			components[i] = new ChunkComponent();
		}
	}
	
	// Adds a part to a chunk component in the chunk!
	public void addPart(ChunkPart p, int y) {
		ChunkComponent cc = components[0];
		cc.add(p);
	}
	
	// Returns a ChunkComponent through the passed index integer!
	public ChunkComponent getComponent(int y) {
		return components[y];
	}
}
