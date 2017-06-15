package wordCount.util;
/**
 * Logger class
 * @author Ankush
 *
 */
public class Logger {
	public static enum DebugLevel { 

		VISITOR,
    	CONSTR,
    	RESULTS,
    	NOTHING
                                   };
                                   
    private static DebugLevel debugLevel;
    private static volatile Logger UniqueInstance = null;   
    private Logger() { }  
    /**
     * Singleton pattern is implemented
     * @param none
     * @return UniqueInstance
     */
    public static Logger getUniqueInstance() 
    {
       if(UniqueInstance==null) { 
        synchronized (Logger.class) {
            if (UniqueInstance == null) {
                UniqueInstance = new Logger();
            }
        }
       }      
        return UniqueInstance;
    }

    public static void setDebugValue (int levelIn) {
		switch (levelIn) {
			case 0: debugLevel = DebugLevel.NOTHING; break;
			case 1: debugLevel = DebugLevel.RESULTS; break;
		  	case 2: debugLevel = DebugLevel.CONSTR; break;
		  	case 3: debugLevel = DebugLevel.VISITOR; break;
		}
    }

    public static void setDebugValue (DebugLevel levelIn) {
    	debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
