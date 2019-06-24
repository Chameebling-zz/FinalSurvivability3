package assets;

import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;

import main.Main;

/*
 * Images.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class Images {
	
	// Images that would be used in some parts of the program. In this case, no images were
	// needed
	// prior to submission of the project.
	public static Image TITLE, ICON;
	
	// Uses a method like the Fonts class because initialization needs to be done
	// in a try/catch.
	public static void loadImages() {
		try {
			TITLE = ImageIO.read(new File(Main.REL_PATH_TO_FILES+"images/title.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
