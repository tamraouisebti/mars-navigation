package main.com.example;

import main.com.example.service.MarsRoverService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;


public class MarsRoverApp {
    private static final Logger logger = Logger.getLogger(MarsRoverApp.class.getName());

    public static void main(String[] args) {
        if (args.length != 1) {
            logger.log(Level.WARNING, "Usage: java -jar rover.jar input.txt");
            return;
        }

        try {
            File file = new File(args[0]);
            MarsRoverService roverService = new MarsRoverService();

            List<String> results = roverService.processRovers(file);

            // Output the final results of each rover
            results.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Error: File not found - {0}", args[0]);
        } catch (InputMismatchException e) {
            logger.log(Level.SEVERE, "Error: Wrong File format - {0}", args[0]);
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error: {}", e.getMessage());
        }
    }
}
