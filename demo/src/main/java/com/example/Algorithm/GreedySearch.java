package com.example.Algorithm;
import com.example.Structure.structurebase.*;
import com.example.maze.Maze;
import com.example.Structure.informed.*;

public class GreedySearch {
    private GreedyStructure structure;
    // تحديد الهدف داخل كلاس البحث
    private int GOAL_ROW;
    private int GOAL_COL;
    private Maze maze ;
    public GreedySearch(GreedyStructure structure, Maze maze) {
        this.structure = structure;
        this.maze = maze ;
        this.GOAL_ROW = maze.getGoal().getRow();
        this.GOAL_COL = maze.getGoal().getCol();
    }

    public Node solve(State initialState) {
        // 1. حساب الـ Heuristic الأولي لعقدة البداية
        int h = calculateHeuristic(initialState);
        Node startNode = new Node(initialState, null, null, 0, h);
        structure.addToFrontier(startNode);

        while (!structure.isFrontierEmpty()) {
            // استخراج العقدة ذات أقل h
            Node currentNode = structure.removeFromFrontier();

            // 2. فحص الهدف
            if (isGoal(currentNode.getState())) {
                return currentNode;
            }

            // 3. إذا لم تُستكشف من قبل، قم بتوسيعها
            if (!structure.isExplored(currentNode.getState())) {
                structure.addToExplored(currentNode.getState());
                expandNode(currentNode);
            }
        }
        return null; // لم يتم العثور على حل
    }

    // دالة حساب المسافة التقديرية (Heuristic) - مسافة مانهاتن
    private int calculateHeuristic(State state) {
        return Math.abs(state.getRow() - GOAL_ROW) + Math.abs(state.getCol() - GOAL_COL);
    }

    // دالة التحقق من الوصول للهدف
    private boolean isGoal(State state) {
        return state.getRow() == GOAL_ROW && state.getCol() == GOAL_COL;
    }

    // دالة التحقق من حدود الخريطة
    private boolean isValid(int r, int c) {
        return r >= 0 && r < 20 && c >= 0 && c < 20;
    }

    private void expandNode(Node parent) {
        // الاتجاهات: يمين، يسار، أسفل، أعلى
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        String[] actions = {"Right", "Left", "Down", "Up"};

        for (int i = 0; i < 4; i++) {
            int nextRow = parent.getState().getRow() + dr[i];
            int nextCol = parent.getState().getCol() + dc[i];

            if (isValid(nextRow, nextCol)) {
                State nextState = new State(nextRow, nextCol);

                // التأكد أن الحالة لم تُستكشف بعد
                if (!structure.isExplored(nextState)) {
                    int h = calculateHeuristic(nextState);
                    // في Greedy نضع cost دائماً 0 لأننا لا نهتم بالتكلفة التراكمية
                    Node child = new Node(nextState, parent, actions[i], 0, h);
                    structure.addToFrontier(child);
                }
            }
        }
    }
}
