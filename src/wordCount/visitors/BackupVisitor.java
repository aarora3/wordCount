package wordCount.visitors;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.TreeI;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
/**
 * Visitor 3 - Backup Visitor class
 * @author Ankush
 *
 */
public class BackupVisitor implements TreeProcessingVisitorI {

	TreeI backup;
	/**
	 * BackupVisitor constructor
	 * @param treeIn Tree
	 */
	public BackupVisitor(TreeI treeIn) {
		
		DebugLevel db = DebugLevel.CONSTR;
		Logger.getUniqueInstance();
		Logger.writeMessage("Backup Visitor constructor called.",db);
		
		backup = treeIn;
		
		DebugLevel db1 = DebugLevel.VISITOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("Backup Visitor executing.",db1);
	}

	/**
	 * visit method overridden of Interface for BackupVisitor
	 * @param t Tree
	 */
	@Override
	public void visit(TreeI t) {
		TreeI tree = t;
		Node root = ((BST) tree).getRoot();
		Node backUp = createBackup(root);
		((BST) backup).setRoot(backUp);
	}
	/**
	 * method to create backup of original node
	 * @param orig Node
	 * @return backup Node
	 */
	public Node createBackup(Node orig){
		if(orig==null){
			return null;
		}
		else
		{
			Node curr = orig.clone();
			curr.setCount(orig.getCount());
			orig.registerObserver(curr);
			curr.setLeft(createBackup(orig.getLeft()));
			curr.setRight(createBackup(orig.getRight()));
			return curr;
		}
	}

}
