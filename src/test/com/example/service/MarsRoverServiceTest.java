package com.example.service;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MarsRoverServiceTest {

    @Test
    public void testProcessRovers() throws FileNotFoundException {
        MarsRoverService service = new MarsRoverService();
        File inputFile = new File("src/test/resources/input.txt");

        List<String> results = service.processRovers(inputFile);
        assertEquals("There should be two rovers processed.", 2, results.size());
        assertEquals("First rover should end up at (1,3) facing North.", "1 3 N", results.get(0));
        assertEquals("Second rover should end up at (5,1) facing East.", "5 1 E", results.get(1));
    }

    @Test
    public void testFileNotFound() {
        MarsRoverService service = new MarsRoverService();
        assertThrows(FileNotFoundException.class, () -> service.processRovers(new File("non-existent-file.txt")));
    }

    @Test
    public void testFileWithWrongFormat() {
        MarsRoverService service = new MarsRoverService();

        File wrongFormatInputFile = new File("src/test/resources/wrongFormatInput.txt");
        assertThrows("Should throw an exception when the input in wrongly formated",
                InputMismatchException.class, () -> service.processRovers(wrongFormatInputFile));
    }
}

