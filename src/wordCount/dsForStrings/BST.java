package wordCount.dsForStrings;

import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
/**
 * BST class - implementation of Tree interface
 * @author Ankush
 *
 */
public class BST implements TreeI {
	private Node root;
	int totalWordCount;
	int distinctWordCount;
	int totalCharCount;
	/**
	 * Tree constructor method 
	 */
	public BST(){
		totalWordCount=0;
		distinctWordCount=0;
		totalCharCount=0;
		
		DebugLevel db = DebugLevel.CONSTR;
		Logger.getUniqueInstance();
		Logger.writeMessage("Tree constructor called",db);
	}
	/**
	 * accept method of Visitor calls visit
	 * @param visitor
	 */
	public void accept(TreeProcessingVisitorI visitor) {
		visitor.visit(this);
	}
	
	/**
	 * method to create add new node to tree
	 * @param s string - data to be added to a new node
	 */
	public void addNode(String s){
		Node curr;
		
		if(root==null){
			root=new Node(s);
			return;
		}
		curr=root;
		while(true){
			if((curr.getData()).equals(s)){
				curr.setCount(curr.getCount()+1);
				break;
			}
			if(s.compareTo(curr.getData())<0){
				if(curr.getLeft()==null){
					curr.setLeft(new Node(s));
					break;
				}
				curr=curr.getLeft();
			}
			if(s.compareTo(curr.getData())>0){
				if(curr.getRight()==null){
					curr.setRight(new Node(s));
					break;
				}
				curr=curr.getRight();
			}
			
		}
	}
	/**
	 * method to do in-order traversal on the tree
	 * @param curr Node
	 */
	public void inOrderTraverse(Node curr){
		if(curr!=null){
			inOrderTraverse(curr.getLeft());
			
			totalWordCount = totalWordCount + curr.getCount();
			distinctWordCount = distinctWordCount + 1;
			totalCharCount = totalCharCount + ((curr.getCount()*((curr.getData()).length())));
			
			inOrderTraverse(curr.getRight());
		}
	}
	/**
	 * getter method to get total word count obtained after in-order traversal
	 * @return int totalWordCount
	 */
	public int getTotalWordCount(){
		return totalWordCount;
	}
	/**
	 * getter method to get distinct word count obtained after in-order traversal
	 * @return int distinctWordCount
	 */
	public int getDistinctWordCount(){
		return distinctWordCount;
	}
	/**
	 * getter method to get total Character count obtained after in-order traversal
	 * @return int totalCharCount
	 */
	public int getTotalCharCount(){
		return totalCharCount;
	}
	
	/**
	 * getter method to get root node of tree
	 * @return root Node
	 */
	public Node getRoot() {
		return root;
	}
	/**
	 * setter method to set root node of tree
	 * @param rootIn Node
	 */
	public void setRoot(Node rootIn) {
		root = rootIn;
	}
}
