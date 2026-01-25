package com.example.Structure.structurebase;

public class Node {
  private State state;
  private Node nextNode;
  private Node parent;
  private String action;
  private int cost ;
  private int heuristic ;

  // for uninformed search (bfs , dfs)
  public Node(State state, Node parent, String action){
    this.state = state;
    this.parent = parent;
    this.action = action;
  }
  // for informed search (a star)
  public Node(State state , Node parent, String action, int heuristic, int cost){
    this.state = state;
    this.parent = parent;
    this.action = action;
    this.heuristic = heuristic;
    this.cost = cost;
  }
  //for greedy search
  public Node(State state, Node parent, Node nextNode, int heuristic){
    this.state = state;
    this.parent = parent;
    this.nextNode = nextNode;
    this.heuristic = heuristic;
    this.cost = 0;
  }
  public int getEvaluation(){
    return this.heuristic + this.cost;
  }
  public Node getNextNode() {
	return nextNode;
  }
  public void setNextNode(Node nextNode) {
	this.nextNode = nextNode;
  }
  public State getState() {
	return state;
  }
  public void setState(State state) {
	this.state = state;
  }
  public Node getParent() {
	return parent;
  }
  public void setParent(Node parent) {
	this.parent = parent;
  }
  public String getAction() {
	return action;
  }
  public void setAction(String action) {
	this.action = action;
  }
  public int getCost() {
	return cost;
  }
  public void setCost(int cost) {
	this.cost = cost;
  }
  public int getHeuristic() {
	return heuristic;
  }
  public void setHeuristic(int heuristic) {
	this.heuristic = heuristic;
  }
}
