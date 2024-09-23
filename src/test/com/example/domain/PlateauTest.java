package com.example.domain;

import main.com.example.domain.Plateau;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlateauTest {

    @Test
    public void testWithinBounds() {
        Plateau plateau = new Plateau(5, 5);
        assertTrue("Point (3,3) should be within plateau bounds.", plateau.isWithinBounds(3, 3));
        assertTrue("Point (0,0) should be within plateau bounds.", plateau.isWithinBounds(0, 0));
        assertTrue("Point (5,5) should be within plateau bounds.", plateau.isWithinBounds(5, 5));
    }

    @Test
    public void testOutOfBounds() {
        Plateau plateau = new Plateau(5, 5);
        assertFalse("Point (6,5) should be out of plateau bounds.", plateau.isWithinBounds(6, 5));
        assertFalse("Point (5,6) should be out of plateau bounds.", plateau.isWithinBounds(5, 6));
        assertFalse("Negative X coordinates should be out of bounds.", plateau.isWithinBounds(-1, 0) );
        assertFalse("Negative Y coordinates should be out of bounds.", plateau.isWithinBounds(0, -1));
    }

    @Test
    public void testInvalidPlateauInitialization() {
        assertThrows("Plateau should not allow negative x dimension.", IllegalArgumentException.class, () -> new Plateau(-1, 5));
        assertThrows("Plateau should not allow negative y dimension.", IllegalArgumentException.class, () -> new Plateau(5, -1));
        assertThrows("Plateau should not allow both dimensions to be negative.", IllegalArgumentException.class, () -> new Plateau(-1, -1));
    }
}

