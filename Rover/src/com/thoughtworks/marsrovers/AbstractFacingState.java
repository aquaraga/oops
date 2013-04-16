package com.thoughtworks.marsrovers;

/**
 * The abstract base class that models the "facing" state of the rover.
 * The rover may face one of the 4 cardinal directions. Each of these 4 states
 * are modeled as sub-classes of this class.
 * @author kumar
 *
 */
abstract class AbstractFacingState {
	
	protected Rover rover;
	
	public AbstractFacingState(Rover aRover) {
		rover = aRover;
	}
	
	/*
	 * Following are the possible state transitions.
	 * turnLeft and turnRight lead to a new state, whereas 'move' preserves
	 * the current state
	 */
	public abstract void turnLeft();
	public abstract void turnRight();
	public abstract void move();
	
	/**
	 * Returns a string representation of the current state
	 * @return
	 */
	public abstract String getStateString();
}
	