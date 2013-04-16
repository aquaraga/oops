package com.thoughtworks.marsrovers;


import org.junit.BeforeClass;
import org.junit.Test;

import com.thoughtworks.marsrovers.Plateau;
import com.thoughtworks.marsrovers.Rover;

public class RoverTest {
	
	private static Plateau plateau = null;

	@BeforeClass
	public static void setUp() throws Exception {
		plateau = new Plateau(5, 5);
	}	
	
	@Test
	public void testNoMovement() {
		Rover rover = new Rover(plateau, 1, 2, 'N');
		rover.interpret("");
		assert "1 2 N".equals(rover.getFinalState());
	}
	
	@Test
	public void test360DegreeMovement01() {
		Rover rover = new Rover(plateau, 1, 2, 'N');
		rover.interpret("LLLL");
		assert "1 2 N".equals(rover.getFinalState());
	}
	
	@Test
	public void test360DegreeMovement02() {
		Rover rover = new Rover(plateau, 1, 2, 'N');
		rover.interpret("RRRR");
		assert "1 2 N".equals(rover.getFinalState());
	}
	
	@Test
	public void testMovement01() {
		Rover rover = new Rover(plateau, 1, 2, 'N');
		rover.interpret("LMLMLMLMM");
		assert "1 3 N".equals(rover.getFinalState());
	}
	
	@Test
	public void testMovement02() {
		Rover rover = new Rover(plateau, 3, 3, 'E');
		rover.interpret("MMRMMRMRRM");
		assert "5 1 E".equals(rover.getFinalState());
	}
	
	@Test
	public void testFallFromPlateau() {
		Rover rover = new Rover(plateau, 0, 4, 'N');
		try {
			rover.interpret("MMMM");
			assert false;
		}
		catch(IllegalStateException ise) {
			assert "Rover fell off from Mars!".equals(ise.getMessage());
		}
	}
}
