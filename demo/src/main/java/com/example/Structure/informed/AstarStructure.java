package com.example.Structure.informed;

import com.example.Structure.structurebase.*;

public class AstarStructure {
    private Heapq frontier;
    private State[] explored;
    private int exploredCount;
    private int capacity;

    public AstarStructure(int capacity) {
        this.capacity = capacity;
        this.frontier = new Heapq(capacity);
        this.explored = new State[capacity];
        this.exploredCount = 0;
    }

    public void addToFrontier(Node node) {
        frontier.push(node);
    }

    public Node removeFromFrontier() {
        return frontier.pop();
    }

    public boolean isFrontierEmpty() {
        return frontier.isEmpty();
    }

    public void addToExplored(State state) {
        if (exploredCount < capacity) {
            explored[exploredCount++] = state;
        }
    }

    public boolean isExplored(State state) {
        for (int i = 0; i < exploredCount; i++) {
            if (explored[i].equals(state)) return true;
        }
        return false;
    }
}
