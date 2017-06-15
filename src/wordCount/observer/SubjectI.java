package wordCount.observer;

import wordCount.dsForStrings.Node;

/**
 * 
 * Interface SubjectI
 * @author Ankush
 *
 */
public interface SubjectI {
	/**
	 * method to notify registered observer when count changed of its Subject
	 */
	public void notifyObserver();
	/**
	 * method to register observers
	 * @param d Node
	 */
	public void registerObserver(Node d);
}
