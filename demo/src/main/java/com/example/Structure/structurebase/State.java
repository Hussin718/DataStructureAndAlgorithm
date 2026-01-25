package com.example.Structure.structurebase;

public class State {
    private int row, col;
    public State(int row, int col) {
        this.row = row;
        this.col = col;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State state = (State) o;
        return row == state.row && col == state.col;
    }
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}

}
