package main.com.example.domain;

public class Rover {
    private int x;
    private int y;
    private char direction;
    private final Plateau plateau;

    // Directions: North, East, South, West
    private static final char[] DIRECTIONS = {'N', 'E', 'S', 'W'};

    public Rover(int x, int y, char direction, Plateau plateau) {
        if (!plateau.isWithinBounds(x, y)) {
            throw new IllegalArgumentException("Initial rover position is out of plateau bounds.");
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.plateau = plateau;
    }

    public void executeCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    moveForward();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command: " + command);
            }
        }
    }

    private void turnLeft() {
        int currentIndex = getDirectionIndex();
        direction = DIRECTIONS[(currentIndex + 3) % 4];  // Turn counter-clockwise
    }

    private void turnRight() {
        int currentIndex = getDirectionIndex();
        direction = DIRECTIONS[(currentIndex + 1) % 4];  // Turn clockwise
    }

    private void moveForward() {
        int newX = x;
        int newY = y;

        switch (direction) {
            case 'N':
                newY++;
                break;
            case 'E':
                newX++;
                break;
            case 'S':
                newY--;
                break;
            case 'W':
                newX--;
                break;
        }

        if (plateau.isWithinBounds(newX, newY)) {
            this.x = newX;
            this.y = newY;
        } else {
            throw new IllegalArgumentException("Rover is attempting to move out of plateau bounds.");
        }
    }

    private int getDirectionIndex() {
        for (int i = 0; i < DIRECTIONS.length; i++) {
            if (DIRECTIONS[i] == direction) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid direction: " + direction);
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}
