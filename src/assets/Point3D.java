package assets;

import java.awt.Point;

/*
 * Point3D.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class Point3D extends Point {
	
	// Field for the z point, that is different from the java.awt.Point class.
	private int z;
	
	// All methods and constructors are like the java.awt.Point class but handles a z-value.
	public Point3D() {
		super();
	}
	
	public Point3D(int x, int y, int z) {
		super(x,y);
		this.z = z;
	}
	
	public Point3D getLocation() {
		return new Point3D(x,y,z);
	}
	
	public double getZ() {
		return z;
	}
	
	public void move(int x, int y, int z) {
		move(x,y);
		this.z = z;
	}
	
	public void setLocation(int x, int y, int z) {
		move(x,y,z);
	}
	
	public String toString() {
		return "assets.Point3D[x="+x+",y="+y+",z="+z+"]";
	}
	
	public void translate(int x, int y, int z) {
		translate(x,y);
		this.z += z;
	}
}
