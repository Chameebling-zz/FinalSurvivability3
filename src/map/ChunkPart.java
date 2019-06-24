package map;

import java.awt.image.BufferedImage;

/*
 * ChunkPart.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class ChunkPart extends Part {
	
	public ChunkPart(BufferedImage image, int orient, int x, int y, int width, int length
			 , int displacement, int chunkX,
			int chunkY, int chunkZ) {
		super(null, image, orient, x, y, width, length, displacement);
		this.chunkX = chunkX;
		this.chunkY = chunkY;
		this.chunkZ = chunkZ;
	}
}
