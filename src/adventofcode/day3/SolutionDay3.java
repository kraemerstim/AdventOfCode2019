package adventofcode.day3;

import javafx.util.Pair;

import java.util.*;

import static adventofcode.utility.AOCUtility.readFile;
import static java.lang.Math.abs;

class Coordinate {
    public int x;
    public int y;
    public int steps;

    public Coordinate(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }

    public int hashCode() {
        return (x + " " + y).hashCode();
    }

    @Override
    protected Coordinate clone() {
        return new Coordinate(x, y, steps);
    }

    public int getDistance() {
        return abs(x) + abs(y);
    }
}

public class SolutionDay3 {

    static Map<Integer, Coordinate> calculate_coordinates(String input) {
        Map<Integer, Coordinate> coordinates = new HashMap<>();
        var inputValues = input.split(",");
        var current_coordinate = new Coordinate(0,0, 0);
        for (String command: inputValues) {
            var direction = command.charAt(0);
            var steps = Integer.valueOf(command.substring(1));
            switch (direction) {
                case 'R':
                    for (int i=0; i< steps; i++) {
                        current_coordinate.x++;
                        current_coordinate.steps++;
                        coordinates.putIfAbsent(current_coordinate.hashCode(), current_coordinate.clone());
                    }
                    break;
                case 'L':
                    for (int i=0; i< steps; i++) {
                        current_coordinate.x--;
                        current_coordinate.steps++;
                        coordinates.putIfAbsent(current_coordinate.hashCode(), current_coordinate.clone());
                    }
                    break;
                case 'U':
                    for (int i=0; i< steps; i++) {
                        current_coordinate.y++;
                        current_coordinate.steps++;
                        coordinates.putIfAbsent(current_coordinate.hashCode(), current_coordinate.clone());
                    }
                    break;
                case 'D':
                    for (int i=0; i< steps; i++) {
                        current_coordinate.y--;
                        current_coordinate.steps++;
                        coordinates.putIfAbsent(current_coordinate.hashCode(), current_coordinate.clone());
                    }
                    break;
                default:
                    break;
            }
        }
        return coordinates;
    }

    public static void main(String[] args) {
        var fileName = "resources/day3.txt";
        List<String> input = readFile(fileName);
        Map<Integer, Coordinate> coordinates1 = calculate_coordinates(input.get(0));
        Map<Integer, Coordinate> coordinates2 = calculate_coordinates(input.get(1));
        Set<Coordinate> intersections = new HashSet<>();
        int shortestDistance = -1;
        for (Integer c1: coordinates1.keySet()) {
            Coordinate wire = coordinates2.get(c1);
            if (wire != null) {
                if (shortestDistance == -1 || wire.getDistance() < shortestDistance) {
                    shortestDistance = wire.getDistance();
                }
            }
        }
        System.out.println("Solution 1 = " + shortestDistance);

        shortestDistance = -1;
        for (Integer c1: coordinates1.keySet()) {
            Coordinate wire1 = coordinates1.get(c1);
            Coordinate wire2 = coordinates2.get(c1);
            if (wire2 != null) {
                if (shortestDistance == -1 || wire1.steps + wire2.steps < shortestDistance) {
                    shortestDistance = wire1.steps + wire2.steps;
                }
            }
        }
        System.out.println("Solution 2 = " + shortestDistance);
    }
}
