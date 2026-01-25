package com.example.maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.example.Structure.structurebase.*;

public class Maze {
    private int height;
    private int width;
    private char[][] grid;
    private State start;
    private State goal;

    public Maze(String filename) {
        loadMaze(filename);
    }

    private void loadMaze(String filename) {
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            
            int rows = 0;
            int cols = 0;
            
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (cols == 0) cols = line.length();
                rows++;
            }
            reader.close();

            this.height = rows;
            this.width = cols;
            this.grid = new char[height][width];

            reader = new Scanner(file);
            for (int i = 0; i < height; i++) {
                String line = reader.nextLine();
                for (int j = 0; j < width; j++) {
                    char c = line.charAt(j);
                    grid[i][j] = c;
                    if (c == 'A') {
                        start = new State(i, j);
                    } else if (c == 'B') {
                        goal = new State(i, j);
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    public boolean isWall(int r, int c) {
        return grid[r][c] == '#';
    }

    public State getStart() {
        return start;
    }

    public State getGoal() {
        return goal;
    }

    public int getHeight() { return height; }
    public int getWidth() { return width; }

    public void printMaze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
 public void printSolution(Node goalNode) {
    char[][] solutionGrid = new char[height][width];
    for (int i = 0; i < height; i++) {
        solutionGrid[i] = grid[i].clone();
    }

    Node curr = goalNode;
    while (curr != null && curr.getParent() != null) {
        if (solutionGrid[curr.getState().getRow()][curr.getState().getCol()] != 'B' && 
            solutionGrid[curr.getState().getRow()][curr.getState().getCol()] != 'A') {
            solutionGrid[curr.getState().getRow()][curr.getState().getCol()] = '.';
        }
        curr = curr.getParent();
    }

    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            System.out.print(solutionGrid[i][j]);
        }
        System.out.println();
    }
   }
}
