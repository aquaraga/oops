package com.thoughtworks.marsrovers;

public class NorthState extends AbstractFacingState {

	public NorthState(Rover rover) {
		super(rover);
	}

	@Override
	public void move() {
		Position oldPos = rover.getPosition();
		rover.setPosition(oldPos.getXPos(), oldPos.getYPos() + 1);

	}

	@Override
	public void turnLeft() {
		rover.setCurrState(rover.getWest());

	}

	@Override
	public void turnRight() {
		rover.setCurrState(rover.getEast());
	}
	
	@Override
	public String getStateString() {
		return "N";
	}

}
