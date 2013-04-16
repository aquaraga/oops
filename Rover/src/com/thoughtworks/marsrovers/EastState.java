package com.thoughtworks.marsrovers;

public class EastState extends AbstractFacingState {

	public EastState(Rover rover) {
		super(rover);
	}

	@Override
	public void move() {
		Position oldPos = rover.getPosition();
		rover.setPosition(oldPos.getXPos() + 1, oldPos.getYPos());
	}

	@Override
	public void turnLeft() {
		rover.setCurrState(rover.getNorth());

	}

	@Override
	public void turnRight() {
		rover.setCurrState(rover.getSouth());
	}

	@Override
	public String getStateString() {
		return "E";
	}

}
