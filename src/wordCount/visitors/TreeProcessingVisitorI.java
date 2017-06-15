package wordCount.visitors;

import wordCount.dsForStrings.TreeI;
/**
 * Interface TreeProcessingVisitorI
 * @author Ankush
 *
 */
public interface TreeProcessingVisitorI {
	/**
	 * visit method of Visitor
	 * @param t Tree
	 */
	public void visit(TreeI t);
}
