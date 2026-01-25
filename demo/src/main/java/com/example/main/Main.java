package com.example.main;

import com.example.maze.Maze;
import com.example.Algorithm.*;
import com.example.Structure.informed.*;
import com.example.Structure.structurebase.*;
import com.example.maze.MazeImageGenerator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maze maze = new Maze("maze.txt");
        System.out.println("--- Maze Loaded Successfully ---");
        maze.printMaze(); 

        System.out.println("\nChoose the algorithm you want to use:");
        System.out.println("1. Breadth-First Search (BFS)");
        System.out.println("2. Depth-First Search (DFS)");
        System.out.println("3. Greedy Best-First Search");
        System.out.println("4. A* Search");
        System.out.print("Enter choice (1-4): ");

        int choice = scanner.nextInt();
        Node result = null;
        long startTime = System.currentTimeMillis();

        switch (choice){
            case 1:
                System.out.println("Running BFS...");
                BreadthFirstSearch bfs = new BreadthFirstSearch(10000, maze);
                result = bfs.solve(maze.getStart());
                break;
            case 2:
                System.out.println("Running DFS...");
                DepthFirstSearch dfs = new DepthFirstSearch(10000, maze);
                result = dfs.solve(maze.getStart());
                break;
            case 3:
                System.out.println("Running Greedy...");
                GreedyStructure greedyStruct = new GreedyStructure(10000);
                GreedySearch greedy = new GreedySearch(greedyStruct, maze);
                result = greedy.solve(maze.getStart());
                break;
            case 4:
                System.out.println("Running A*...");
                AstarStructure astarStruct = new AstarStructure(10000);
                AstarSearch astar = new AstarSearch(astarStruct, maze);
                result = astar.solve(maze.getStart());
                break;
            default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
        }

        long endTime = System.currentTimeMillis();

        if (result != null) {
            System.out.println("\n--- Path Found! ---");
            System.out.println("Time taken: " + (endTime - startTime) + " ms");
            System.out.println("Total steps (Cost): " + result.getCost());
            maze.printSolution(result);
            MazeImageGenerator.saveMazeAsImage(maze, result, "maze_solution.png");
        } else {
            System.out.println("No path could be found by this algorithm.");
        }

        scanner.close();
    }
}
