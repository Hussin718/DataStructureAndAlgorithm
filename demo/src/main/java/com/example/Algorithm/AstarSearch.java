package com.example.Algorithm;
import com.example.Structure.informed.*;
import com.example.Structure.structurebase.*;
import com.example.maze.Maze;

public class AstarSearch {
    private AstarStructure structure;
    private final int GOAL_ROW = 10;
    private final int GOAL_COL = 10;
    private Maze maze;
    public AstarSearch(int maxNodes) {
        this.structure = new AstarStructure(maxNodes);
    }
    public AstarSearch(AstarStructure structure, Maze maze) {
        this.structure = structure;
        this.maze = maze;
    }

    public Node solve(State initialState) {
        int startH = calculateHeuristic(initialState);
        Node startNode = new Node(initialState, null, null, 0, startH);
        structure.addToFrontier(startNode);

        while (!structure.isFrontierEmpty()) {
            Node currentNode = structure.removeFromFrontier();

            // 1. التحقق من الهدف داخل كلاس البحث
            if (isGoal(currentNode.getState())) {
                return currentNode;
            }

            if (!structure.isExplored(currentNode.getState())) {
                structure.addToExplored(currentNode.getState());

                expandNode(currentNode);
            }
        }
        return null;
    }

    private int calculateHeuristic(State state) {
        return Math.abs(state.getRow() - GOAL_ROW) + Math.abs(state.getCol() - GOAL_COL);
    }

    private boolean isGoal(State s) {
        return s.getRow() == maze.getGoal().getRow() && s.getCol() == maze.getGoal().getCol();
  }
    private void expandNode(Node parent) {
        int[] dRow = {0, 0, 1, -1};
        int[] dCol = {1, -1, 0, 0};
        String[] actions = {"Right", "Left", "Down", "Up"};

        for (int i = 0; i < 4; i++) {
            int nextRow = parent.getState().getRow() + dRow[i];
            int nextCol = parent.getState().getCol() + dCol[i];

            if (isValid(nextRow, nextCol)) {
                State nextState = new State(nextRow, nextCol);
                if (!structure.isExplored(nextState)) {
                    int h = calculateHeuristic(nextState);
                    Node child = new Node(nextState, parent, actions[i], parent.getCost() + 1, h);
                    structure.addToFrontier(child);
                }
            }
        }
    }

    private boolean isValid(int r, int c) {
    if (r < 0 || r >= maze.getHeight() || c < 0 || c >= maze.getWidth()) {
        return false;
    }
    return !maze.isWall(r, c);
}
}
