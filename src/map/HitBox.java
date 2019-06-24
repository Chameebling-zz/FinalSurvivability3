package map;

import java.util.*;

/*
 * HitBox.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class HitBox {
	
	private int x, y, z, dx, dy, dz;
	
	public HitBox(int x, int y, int z, int dx, int dy, int dz){
		this.x = x;
		this.y = y;
		this.z = z;
		this.dx = dx;
		this.dy = dy;
		this.dz = dz;
	}
	
	// Getters and sessers for the hit box! (a 3D rectangle pretty much)
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getZ(){
		return z;
	}
	
	public void setZ(){
		this.z = z;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public int getDz(){
		return dz;
	}
	
	public void setDz(){
		this.dz = dz;
	}
	
	// The String representation of the HitBox!
	public String toString(){
		return "map.HitBox"+Arrays.toString(new int[]{x, y, z, dx, dy, dz});
	}
	
}
