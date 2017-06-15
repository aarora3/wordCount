package wordCount.dsForStrings;

import wordCount.visitors.TreeProcessingVisitorI;

/**
 * 
 * Tree class - BST data structure used
 * @author Ankush
 *
 */
public interface TreeI {
	/**
	 * accept method
	 * @param visitor
	 */
	public void accept(TreeProcessingVisitorI visitor);
	
}

	 
