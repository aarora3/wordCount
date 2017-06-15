package wordCount.visitors;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.TreeI;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
/**
 * Visitor 2 - WordCountVisitor class
 * @author Ankush
 *
 */
public class WordCountVisitor implements TreeProcessingVisitorI {

	FileProcessor fp;
	/**
	 * WordCountVisitor constructor
	 * @param fileprocessor
	 */
	public WordCountVisitor(FileProcessor fileprocessor) {
		
		DebugLevel db = DebugLevel.CONSTR;
		Logger.getUniqueInstance();
		Logger.writeMessage("WordCount Visitor constructor called.",db);
		
		fp = fileprocessor;
		
		DebugLevel db1 = DebugLevel.VISITOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("WordCount Visitor executing.",db1);
		
	}

	/**
	 * visit method overridden of Interface for WordCountVisitor
	 * @param t Tree
	 */
	@Override
	public void visit(TreeI t) {
		Node d = ((BST) t).getRoot();
		((BST) t).inOrderTraverse(d);
				
		fp.writeToFile("Total word count: " + (((BST) t).getTotalWordCount()));
		fp.writeToFile("Total distinct word count: " + ((BST) t).getDistinctWordCount());
		fp.writeToFile("Total character count: " + ((BST) t).getTotalCharCount());
	}
	
}
