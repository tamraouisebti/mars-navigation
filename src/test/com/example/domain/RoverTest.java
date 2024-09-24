package com.example.domain;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RoverTest {

    @Test
    public void testRoverMovement() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, 'N', plateau);

        rover.executeCommands("LMLMLMLMM");
        assertEquals("Rover should be at (1, 3) facing North.","1 3 N", rover.toString());
    }

    @Test
    public void testOutOfBoundsMovement() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(0, 0, 'S', plateau);
        assertThrows("Rover should throw an exception if it moves out of bounds.", IllegalArgumentException.class, () -> rover.executeCommands("M"));
    }

    @Test
    public void testInvalidCommand() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(0, 0, 'N', plateau);
        assertThrows("Rover should throw an exception for invalid commands.", IllegalArgumentException.class, () -> rover.executeCommands("X"));
    }
}
