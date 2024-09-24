# mars-navigation
This repository will present a solution for a technical interview in java, its goal is to calculate the correct position after following navigation instructions

### Context
Assume that the square directly North from (x, y) is (x, y+1).

##### INPUT:
The first line of input is the upper-right coordinates of the plateau, the
lower-left coordinates are assumed to be 0,0.
The rest of the input is information pertaining to the rovers that have
been deployed. Each rover has two lines of input. The first line gives the
rover's position, and the second line is a series of instructions telling
the rover how to explore the plateau. <br />
The position is made up of two integers and a letter separated by spaces,
corresponding to the x and y coordinates and the rover's orientation.
Each rover will be finished sequentially, which means that the second rover
won't start to move until the first one has finished moving.

##### OUTPUT:
The output for each rover should be its final co-ordinates and heading.

##### Test Input:
5 5 <br />
1 2 N <br />
LMLMLMLMM <br />
3 3 E <br />
MMRMMRMRRM
##### Expected Output:
1 3 N <br />
5 1 E

##### COMMAND LINE:
The program will be runned with this command line:

 	java -jar rover.jar input.txt

### Solution
In this solution we tried to follow a structured, object-oriented approach by dividing the problem into :
- **Plateau** : represents the rectangular area where the rovers move.
  -  Ensures that the boundaries are correctly defined
  -  Ensures that the rover does not go beyond the boundaries 
- **Rover** : Each rover is modeled as an object with **X** and **Y** coordinates and a direction (**N**, **W**, **S**, **E**).
  -  Executes command (Turn right, Turn left, moves forward)
  -  calculates the updated position.
- **MarsRoverService** : This service processes the input, creates the Plateau and the rovers and executes the instruction for each rover.
- **MarsRoverApp** : The entry point that orchestrates reading the file and printing the final results.

#### Project Structure
 	mars-navigation/ 
    ├── src/
    │   ├── main/
    │   │   └── java/
    │   │       └── com/
    │   │           └── example/
    │   │               ├── MarsRoverApp.java
    │   │               ├── domain/
    │   │               │   ├── Rover.java
    │   │               │   └── Plateau.java
    │   │               └── service/
    │   │                   └── MarsRoverService.java
    │   └── test/
    │       └── java/
    │           └── com/
    │               └── example/
    │                   ├── MarsRoverAppTest.java
    │                   ├── domain/
    │                   │   └── RoverTest.java
    │                   │   └── PlateauTest.java
    │                   └── service/
    │                       └── MarsRoverServiceTest.java
    └── README.md

#### How to Run the Program
###### Requirements
- Java JDK 8 or higher
###### Running the Program
1. Download the [latest release](https://github.com/tamraouisebti/mars-navigation/releases/tag/v1.0.0).
2. Download the [Input example](https://github.com/tamraouisebti/mars-navigation/blob/main/input.txt).
3. Run the jar :
```
   java -jar mars-navigation.jar input.txt
```
