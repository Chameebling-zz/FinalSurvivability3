package assets;

import java.io.*;

import main.Main;

import java.awt.*;
/*
 * Fonts.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class Fonts {
	
	// The main larger font
	public static Font MAIN;
	
	// The smaller description font
	public static Font CONTENT;
	
	// Initializes the fonts for the static fields. Have to do them in a method because 
	// the methods involved
	// need to be surrounded with try/catch.
	public static void loadFonts() {
		try {
			MAIN = Font.createFont(Font.TRUETYPE_FONT, 
				new File(Main.REL_PATH_TO_FILES+
						"fonts/blue highway d.ttf")).deriveFont(40F);
			CONTENT = Font.createFont(Font.TRUETYPE_FONT, 
				new File(Main.REL_PATH_TO_FILES+
						"fonts/PTM55FT.ttf")).deriveFont(20F);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
