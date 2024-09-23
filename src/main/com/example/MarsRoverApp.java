package main.com.example;

import main.com.example.service.MarsRoverService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;

public class MarsRoverApp {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java -jar rover.jar input.txt");
            return;
        }

        try {
            File file = new File(args[0]);
            MarsRoverService roverService = new MarsRoverService();

            List<String> results = roverService.processRovers(file);

            // Output the final results of each rover
            results.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + args[0]);
        } catch (InputMismatchException e) {
            System.out.println("Error: Wrong File format - " + args[0]);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
