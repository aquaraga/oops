package com.thoughtworks.marsrovers;

/**
 * The class that models a Rover
 * @author kumar
 *
 */
public class Rover {
	
	//The current position of the rover
	private Position position = new Position();
	
	//The plateau on which the rover navigates
	private Plateau plateauContext;
	
	/*
	 * The various states of the rover
	 */
	private AbstractFacingState north = null;
	private AbstractFacingState east = null;
	private AbstractFacingState south = null;
	private AbstractFacingState west = null;
	
	//Current state of the rover
	private AbstractFacingState currState = null;
	
	public AbstractFacingState getNorth() {
		return north;
	}

	public AbstractFacingState getEast() {
		return east;
	}

	public AbstractFacingState getSouth() {
		return south;
	}

	public AbstractFacingState getWest() {
		return west;
	}

	public void setCurrState(AbstractFacingState currState) {
		this.currState = currState;
	}
	
	/**
	 * Set the position of the rover on the plateau
	 * @param anXPos
	 * @param aYPos
	 * @throws IllegalArgumentException
	 */
	public void setPosition(int anXPos, int aYPos) {
		position.setXPos(anXPos);
		position.setYPos(aYPos);
		//Check if the new position is within the bounds of the Martian plateau
		if (!plateauContext.isContainedInPlateau(position)) {
			throw new IllegalStateException("Rover fell off from Mars!");
		}
	}	

	public Position getPosition() {
		return position;
	}
	
	/**
	 * Rover construction and initialization
	 * @param anInitX
	 * @param anInitY
	 * @param anInitDirection
	 * @param aPlateauCtx
	 */
	public Rover(Plateau aPlateauCtx, int anInitX, int anInitY, char anInitDirection) {
		//Set the plateau on which the rover navigates
		plateauContext = aPlateauCtx;
		
		//Set the position
		setPosition(anInitX, anInitY);
		
		//Initialize the various states, and set the current rover state
		north = new NorthState(this);
		south = new SouthState(this);
		east = new EastState(this);
		west = new WestState(this);	
		
		//Current rover state is set, based on the initial direction of rover
		switch (anInitDirection) {
		case 'N':
			currState = north;
			break;
		case 'S':
			currState = south;
			break;
		case 'W':
			currState = west;
			break;
		case 'E':
			currState = east;
			break;
		}
	}
	
	/**
	 * For a given command string, the rover performs certain actions
	 * @param aCmdString
	 */
	public void interpret(String aCmdString) {
		char[] cmdChars = aCmdString.toCharArray();
		for (char c : cmdChars) {
			switch (c) {
			case 'M':
				currState.move();
				break;
			case 'L':
				currState.turnLeft();
				break;
			case 'R':
				currState.turnRight();
				break;
			}
		}			
	}

	/**
	 * This method gets the final state of the rover, after interpreting to the
	 * commands.
	 * @return
	 */
	public String getFinalState() {
		return position + " " + currState.getStateString();
	}
}
