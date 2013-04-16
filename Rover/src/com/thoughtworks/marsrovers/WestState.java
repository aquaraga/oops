package com.thoughtworks.marsrovers;

public class WestState extends AbstractFacingState {
	
	public WestState(Rover rover) {
		super(rover);
	}

	@Override
	public void move() {
		Position oldPos = rover.getPosition();
		rover.setPosition(oldPos.getXPos() - 1, oldPos.getYPos());
	}

	@Override
	public void turnLeft() {
		rover.setCurrState(rover.getSouth());

	}

	@Override
	public void turnRight() {
		rover.setCurrState(rover.getNorth());
	}

	@Override
	public String getStateString() {
		return "W";
	}

}
