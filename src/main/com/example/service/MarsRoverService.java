package main.com.example.service;

import main.com.example.domain.Rover;
import main.com.example.domain.Plateau;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MarsRoverService {

    public List<String> processRovers(File file) throws FileNotFoundException, InputMismatchException, IllegalArgumentException {
        List<String> roverResults = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        // Reading plateau's upper-right coordinates
        int plateauX = scanner.nextInt();
        int plateauY = scanner.nextInt();
        Plateau plateau = new Plateau(plateauX, plateauY);

        // Process each rover's position and commands
        while (scanner.hasNext()) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            char startDirection = scanner.next().charAt(0);

            Rover rover = new Rover(startX, startY, startDirection, plateau);
            scanner.nextLine(); // Move to the next line
            String commands = scanner.nextLine();

            rover.executeCommands(commands);

            // Store the final position and orientation
            roverResults.add(rover.toString());
        }

        scanner.close();
        return roverResults;
    }
}

