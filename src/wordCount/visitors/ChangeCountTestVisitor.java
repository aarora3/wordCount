package wordCount.visitors;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.TreeI;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
/**
 * Visitor 4 - ChangeCountTest Visitor class 
 * @author Ankush
 *
 */
public class ChangeCountTestVisitor implements TreeProcessingVisitorI {

	FileProcessor origFile;
	FileProcessor backupFile;
	TreeI backupTree;
	/**
	 * ChangeCountTestVisitor constructor
	 * @param backupTreeIn Tree
	 */
	public ChangeCountTestVisitor(TreeI backupTreeIn) {
		
		DebugLevel db = DebugLevel.CONSTR;
		Logger.getUniqueInstance();
		Logger.writeMessage("ChangeCountTest Visitor constructor called.",db);
		
		origFile = new FileProcessor("OrigFile.txt");
		backupFile = new FileProcessor("BackUpFile.txt");
		backupTree = backupTreeIn;
		
		DebugLevel db1 = DebugLevel.VISITOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("ChangeCountTest Visitor executing.",db1);
		
	}
	/**
	 * visit method overridden of Interface for ChangeCountTest Visitor
	 * @param t Tree
	 */
	@Override
	public void visit(TreeI t) {
		Node root = ((BST) t).getRoot();
		if(root==null)
			return;
		else
		{
			changeCount(root);
			writeOrigFile(root);
			writeBackupFile(((BST) backupTree).getRoot());
		}
		
	}
	/**
	 * method to change Count of node
	 * @param d Node
	 */
	public void changeCount(Node d){
		if(d!=null){
			changeCount(d.getLeft());
			d.setCount(d.getCount()*2);
			changeCount(d.getRight());
		}
		else
			return;
	}
	/**
	 * method to write original file
	 * @param d Node
	 */
	public void writeOrigFile(Node d){
		if(d!=null){
			writeOrigFile(d.getLeft());
			origFile.writeToFile(d.getData() + " " + d.getCount());
			writeOrigFile(d.getRight());
		}
		else
			return;
		
	}
	/**
	 * method to write backup file
	 * @param d Node
	 */
	public void writeBackupFile(Node d){
		if(d!=null){
			writeBackupFile(d.getLeft());
			backupFile.writeToFile(d.getData() + " " + d.getCount());
			writeBackupFile(d.getRight());
		}
		else
			return;
	}

}
