package com.thoughtworks.marsrovers;

/**
 * Depicts a position on the rectangular coordinate system
 * @author kumar
 *
 */
public class Position {
	
	private int xPos;
	private int yPos;

	public void setXPos(int pos) {
		xPos = pos;
	}

	public void setYPos(int pos) {
		yPos = pos;
	}

	public int getXPos() {
		return xPos;
	}
	
	@Override
	public String toString() {
		return xPos + " " + yPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	
}
