package wordCount.driver;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.TreeI;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.visitors.BackupVisitor;
import wordCount.visitors.ChangeCountTestVisitor;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.visitors.WordCountVisitor;

/**
 * Driver class
 * @author Ankush
 *
 */
public class Driver {
	
	static int NUM_ITERATIONS;
    static int DEBUG_VALUE;
    
    /**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		//validating command line arguments    
	    if(args.length != 4){
	      System.out.println("\nWrong number of command line arguments (see run instructions), terminating program.\n");
	      System.exit(0);
	    }
	    
	  //Validating NUM_ITERATIONS
	    if(Integer.parseInt(args[2])>=1){
	      NUM_ITERATIONS=Integer.parseInt(args[2]);
	    }
	    else{
	      System.out.println("\nIncorrect value of NUM_ITERATIONS (3rd command line argument), terminating program.\n");
	      System.exit(0);
	    }
	    
	    //VALIDATING DEBUG_VALUE
	    if(Integer.parseInt(args[2])>=0 && Integer.parseInt(args[3])<=3){
	      DEBUG_VALUE=Integer.parseInt(args[3]);
	    }
	    else{
	      System.out.println("\nIncorrect value of DEBUG_VALUE (4th command line argument), terminating program.\n");
	      System.exit(0);
	    }
	    
	    try {
	    	
	    	//setting Logger DebugValue
		    Logger.getUniqueInstance();
			Logger.setDebugValue(Integer.parseInt(args[3]));
	    	
	    	FileProcessor fileprocessor = new FileProcessor(args[0],args[1]);
	    	TreeI t=new BST();
	    	long startTime = System.currentTimeMillis();
	    	for(int i=0; i<NUM_ITERATIONS; i++){
	    		
	    		fileprocessor = new FileProcessor(args[0],args[1]);
	    		t=new BST();
	    		
	    		//Visitor 1 - populate visitor
	    		TreeProcessingVisitorI ptVisitor = new PopulateVisitor(fileprocessor);
	    		t.accept(ptVisitor);
				
				//Visitor 2 - word count visitor
				TreeProcessingVisitorI wcVisitor = new WordCountVisitor(fileprocessor);
				t.accept(wcVisitor);
				
	    	}
	    	
	    	long finishTime = System.currentTimeMillis();
			long totalTime = (finishTime - startTime)/NUM_ITERATIONS;
			System.out.println("Total time= " + totalTime + " milliseconds.");
			
			//Visitor 3 - to take backup visitor
			TreeI backupTree = new BST();
			TreeProcessingVisitorI bkVisitor = new BackupVisitor(backupTree);
			t.accept(bkVisitor);
			
			
			//Visitor 4 - to test backup visitor
			TreeProcessingVisitorI tstVisitor = new ChangeCountTestVisitor(backupTree);
			t.accept(tstVisitor);
			
	    }
	    catch(Exception fnfe){
	    	 System.out.println("File not found.");
	    	 fnfe.printStackTrace();
	    	 System.exit(0);
	     }
	    finally{
	    	
	    }
	    
	}
}