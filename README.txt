CS542 Design Patterns
Fall 2016
Assignment 4 README FILE

Due Date: Wednesday, November 23, 2016
Submission Date: Wednesday, November 23, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): ANKUSH ARORA
e-mail(s): aarora3@binghamton.edu


PURPOSE:

  To implement word count with Visitor, Prototype, and Observer.

PERCENT COMPLETE:

  100%

PARTS THAT ARE NOT COMPLETE:

  None

BUGS:

  None

FILES:

  List of the files that are necessary for the project to run:

arora_ankush_assign4
   ---wordCount
     ----- README.txt
     ----- build.xml
     ----- src
        -----wordCount
     	   ----------driver
	        	   ----------Driver.java

				    (1) Validate that command line inputs for input and output file names.
			   	    (2) Create the element(s)
			        (3) Create the two visitor instances
				    (4) Use the performance measurement loop given above.
					(5) Create backup and test visitors to test observer and prototype pattern.

			 
           ----------util
	              ----------FileProcessor.java
					[methods to read a line and write to a file]
				  ----------Logger.java
           ----------dsForStrings
					[Classes for data structures]
				  ----------Node.java
				  ----------TreeI.java
				  ----------BST.java
           ----------visitors
	              ----------PopulateVisitor.java
					[Visitor class that reads words from a file and populates a data structure]
	              ----------WordCountVisitor.java
					[Visitor that determines the total number of words, total number of unique words, and characters stored in the data structure]
	              ----------TreeProcessingVisitorI.java
					[visitor interface]
				  ----------BackupVisitor.java
					[Visitor that backs up the original tree using prototype pattern]
				  ----------ChangeCountTestVisitor.java
					[Visitor that makes changes to node counts and then write 2 files to show observer pattern worked]
           ----------observer
				  ----------SubjectI.java
					[subject interface]
				  ----------ObserverI.java		
					[observer/listener interface]

SAMPLE OUTPUT:

	output.txt:

		Total word count: 1312
		Total distinct word count: 640
		Total character count: 6148
	
	Console:

		Total time= 8 milliseconds.


TO COMPILE:

  Extract the tarball using command:

	tar -xvf arora_ankush_assign4.tar.gz

  Next, go to directory arora_ankush_assign4/wordCount/src and run the following command:

	ant

TO RUN:

  Go to directory, arora_ankush_assign4/wordCount/src and run the following command:

	ant -buildfile build.xml -Darg0=input.txt -Darg1=output.txt -Darg2=10 -Darg3=0 run

		where	
			arg0 is input file in arora_ankush_assign4/wordCount
			arg1 is output file
			arg2 is NUM_ITERATIONS (greater than or equal to 1)
			arg3 is DEBUG_VALUE (0-3)

	DEBUG_VALUEs defined:
		0 - NOTHING
		1 - RESULTS (when data written to file)
		2 - CONSTR (whenever any constructor called)
		3 - VISITOR (when each VISITOR called)
			
DATA STRUCTURES USED:

  Data structure used is a BST (Binary Search Tree).
  

COMPLEXITY:

  Time complexity:
	Average case: O(log N)
	Worst case: O(N)
  Space complexity: O(N)
  
	where N is the number of nodes.

EXTRA CREDIT:

  N/A


BIBLIOGRAPHY:

  This serves as evidence that we are in no way intending Academic Dishonesty.
  Ankush Arora


ACKNOWLEDGEMENT:

  None