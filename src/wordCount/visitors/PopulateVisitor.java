package wordCount.visitors;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.TreeI;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

/**
 * Visitor 1 - Populate Visitor class
 * @author Ankush
 *
 */
public class PopulateVisitor implements TreeProcessingVisitorI {
	FileProcessor fp;
	
	/**
	 * PopulateVisitor constructor
	 * @param f FileProcessor
	 */
	public PopulateVisitor(FileProcessor f) {
		
		DebugLevel db = DebugLevel.CONSTR;
		Logger.getUniqueInstance();
		Logger.writeMessage("Populate Visitor constructor called.",db);
		
		fp = f;
		
		DebugLevel db1 = DebugLevel.VISITOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("Populate Visitor executing.",db1);
		
	}
	/**
	 * visit method overridden of Interface for PopulateVisitor
	 * @param t Tree
	 */
	@Override
	public void visit(TreeI t) {
		// TODO Auto-generated method stub
		String str;
		str=fp.readFromFile();
		while(str!=null) {
			String [] temp = str.split("\\s+");
			for(int i=0;i<temp.length;i++){
				((BST) t).addNode(temp[i]);
			}
			str=fp.readFromFile();
		}
	}

	
}
