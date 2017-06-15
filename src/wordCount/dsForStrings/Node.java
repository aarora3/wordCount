package wordCount.dsForStrings;

import java.util.ArrayList;

import wordCount.observer.ObserverI;
import wordCount.observer.SubjectI;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

/**
 * 
 * @author Ankush
 * Class for Node
 */
public class Node implements Cloneable, ObserverI, SubjectI{
	private String data;
	private int count;
	private Node left;
	private Node right;	
	private ArrayList<Node> observers;
	
	/**
	 * getter method to get count value at node 
	 * @return int - count
	 */
	public int getCount(){
		return count;
	}
	
	/**
	 * setter method to set count value at node
	 * @param c - count value
	 */
	public void setCount(int c){
		count = c;
		notifyObserver();
	}
	
	/**
	 * class constructor to create a new Node
	 * @param data - data to be stored at node (each distinct word in our case)
	 */
	public Node(String data){
		this.data = data;
		this.count=1;
		left = null;
		right = null;
		observers=new ArrayList<Node>();
		
		DebugLevel db = DebugLevel.CONSTR;
		Logger.getUniqueInstance();
		Logger.writeMessage("Node constructor called. Data= " + data,db);
		
	}
	
	/**
	 * getter method to get the string data value at node
	 * @return String data - data at node
	 */
	public String getData(){
		return data;
	}
	
	/**
	 * getter method to get node pointed to by left pointer of current node 
	 * @return left Node
	 */
	public Node getLeft(){
		return left;
	}
	
	/**
	 * getter method to get node pointed to by right pointer of current node
	 * @return right Node
	 */
	public Node getRight(){
		return right;
	}
	
	/**
	 * setter method to set value to data at node
	 * @param s data
	 */
	public void setData(String s){
		data = s;
	}
	
	/**
	 * setter method to set the argument as the left node of current node.
	 * @param d left Node
	 */
	public void setLeft(Node d){
		left=d;
	}
	
	/**
	 * setter method to set the argument as the right node of current node.
	 * @param d right Node
	 */
	public void setRight(Node d){
		right=d;
	}
	
	/**
	 * method to clone and return current node
	 * @return Node
	 */
	public Node clone()
	{
		Node clonedNode=(Node)this;
		return new Node(clonedNode.data);
	}

	/**
	 * method to notify Observer node(s) of changes in Subject
	 */
	@Override
	public void notifyObserver() {
		for(int i=0;i<observers.size();i++)
		{	
			Node observer=observers.get(i);
			observer.update(getCount());
		}
		
	}

	/**
	 * method to add Observers to a Node
	 * @param d Node
	 */
	@Override
	public void registerObserver(Node d) {
		observers.add(d);
	}

	/**
	 * method to update count value of a node
	 * @param countIn count value of a node
	 */
	@Override
	public void update(int countIn) {
		count = countIn; 
	}
	
	/**
	 * getter method to get observers of current node 
	 * @return ArrayList<Node> observers of node
	 */
	public ArrayList<Node> getObservers() {
		return observers;
	}
	
	/**
	 * setter method to set observers for the current node
	 * @param observersIn observers ArrayList
	 */
	public void setObservers(ArrayList<Node> observersIn) {
		observers = observersIn;
	}
	
}
