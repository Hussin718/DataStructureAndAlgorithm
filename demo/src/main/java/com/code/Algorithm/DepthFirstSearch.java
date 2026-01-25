package com.example.Algorithm;
import com.example.Structure.uninformed.*;
import com.example.maze.Maze;
import com.example.Structure.structurebase.*;

public class DepthFirstSearch {
    private StackFrontier frontier;
    private State[] explored;
    private int exploredCount;

    private int GOAL_ROW ;
    private int GOAL_COL ;
    private int GRID_SIZE = 100 ;
    private Maze maze ;

    public DepthFirstSearch(int maxNodes, Maze maze) {
        this.frontier = new StackFrontier();
        this.explored = new State[maxNodes];
        this.exploredCount = 0;
        this.maze = maze ;
        this.GOAL_COL = maze.getGoal().getCol();
        this.GOAL_ROW = maze.getGoal().getRow();
    }

    public Node solve(State initialState) {
        frontier.add(new Node(initialState, null, null, 0, 0));

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.remove();

            if (isGoal(currentNode.getState())) {
                return currentNode;
            }

            if (!isExplored(currentNode.getState())) {
                addToExplored(currentNode.getState());

                int[] dr = {0, 0, 1, -1};
                int[] dc = {1, -1, 0, 0};
                String[] actions = {"Right", "Left", "Down", "Up"};

                for (int i = 0; i < 4; i++) {
                    int nr = currentNode.getState().getRow() + dr[i];
                    int nc = currentNode.getState().getCol() + dc[i];

                    if (isValid(nr, nc)) {
                        State nextState = new State(nr, nc);
                        if (!isExplored(nextState)) {
                            frontier.add(new Node(nextState, currentNode, actions[i], currentNode.getCost() + 1, 0));
                        }
                    }
                }
            }
        }
        return null;
    }

    private boolean isGoal(State s) {
        return s.getRow()== GOAL_ROW && s.getCol() == GOAL_COL;
    }
    private boolean isValid(int r, int c) {
        // الفحص الصحيح: داخل الحدود + ليس جداراً
        return r >= 0 && r < maze.getHeight() && 
               c >= 0 && c < maze.getWidth() && 
               !maze.isWall(r, c);
    }
    private boolean isExplored(State s) {
        for (int i = 0; i < exploredCount; i++) {
            if (explored[i].equals(s)) return true;
        }
        return false;
    }

    private void addToExplored(State s) {
        if (exploredCount < explored.length) {
            explored[exploredCount++] = s;
        }
    }
}
