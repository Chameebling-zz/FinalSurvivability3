package map;

import java.awt.image.BufferedImage;

/*
 * EntityPart.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class EntityPart extends Part {

	public EntityPart(Entity e, BufferedImage image, int orient, int x, int y
			  , int width, int length,
			int displacement) {
		super(e, image, orient, x, y, width, length, displacement);
	}

}
