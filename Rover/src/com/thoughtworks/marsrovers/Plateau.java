package com.thoughtworks.marsrovers;

/**
 * This class models a rectangular plateau
 * @author kumar
 *
 */
public class Plateau {
	
	//Length of plateau (across the x-axis)
	private int length; 
	
	//Width of plateau (across the y-axis)
	private int width;
	
	public Plateau (int aLength, int aWidth) {
		length = aLength;
		width = aWidth;
	}
	
	/**
	 * Checks if the given position is within the bounds of the plateau
	 * @param aPos
	 * @return
	 */
	public boolean isContainedInPlateau(Position aPos) {
		int xCord = aPos.getXPos();
		int yCord = aPos.getYPos();
		return (xCord >= 0 && xCord <= length &&
				yCord >= 0 && yCord <= width);
	}
}
