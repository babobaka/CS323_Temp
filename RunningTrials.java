/**
 * Running Trials
 * Author: Carolyn Yao, Students: Choun H. Lee, Divya Samaroo, Kenneth Hill, Mohammed Rahat
 * Does this compile or finish running within 5 seconds? Y/N Yes
 */
// Test
public class RunningTrials {

  // Do not change the parameters!
  public int runTrialsRecur(int possibleSpeeds, int days) {
	  	int minTests = 0;
	  	//*******************************************************************************************************
	  	// Beginning of our code
	  	if (possibleSpeeds == 0 || possibleSpeeds == 1)
	  		return possibleSpeeds;
	  	if (days == 1)
	  		return possibleSpeeds;
	    minTests = Integer.MAX_VALUE;
	    int res;
	    for (int i = 1; i <= possibleSpeeds; i++) {
	    	res = Math.max(runTrialsRecur(i-1,days-i), runTrialsRecur(possibleSpeeds-i,days));
	    	if (res < minTests)
	    		minTests = res;
	    }
	    return minTests + 1;
	  
	  // End of our code
	  //*******************************************************************************************************
  }
  
  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int runTrialsMemoized() {
    int minTests = 0;
    // Your optional code here
    return minTests;
  }

  // Do not change the parameters!
  public int runTrialsBottomUp(int possibleSpeeds, int days) {
    int minTests = 0;
    // Your code here
    //*******************************************************************************************************
  	// Beginning of our code
    
    int tests[][] = new int[possibleSpeeds + 1][days + 1];
    
    // Initialization of our Dynamic programming table, 0 for 0th day and 1 for 1st day
    for(int i = 1; i <= possibleSpeeds; i++)
    {
    	tests[i][0] = 0;
    	tests[i][1] = 1;
    }
    // Filling up for the case when days = 1, and have to run full number of tests.
    for(int i = 1; i <= days; i++)
    {
    	tests[1][i] = i;
    }
    // temp variable for max comparison
    int result = 0;
    // DP code. Two outer nested loops goes through the DP table of 2D array
    for (int i = 2; i <= possibleSpeeds; i++) 
    { 
        for (int j = 2; j <= days; j++) 
        { 
        	// Max Integer to avoid problems with below comparison set up
            tests[i][j] = Integer.MAX_VALUE; 
            // Same optimal substructure of the recursion code above
            for (int k = 1; k <= j; k++) 
            { 
                 result = 1 + Math.max(tests[i - 1][k - 1], tests[i][j - k]); 
                 if (result < tests[i][j])
                    tests[i][j] = result; 
            } 
        } 
    } 
    minTests = tests[possibleSpeeds][days];
	// End of our code
	//*******************************************************************************************************

    return minTests;
  }

  public static void main(String args[]){
      RunningTrials running = new RunningTrials();

      // Do not touch the below lines of code, your output will automatically be formatted
      int minTrials1Recur = running.runTrialsRecur(6,1);
      int minTrials1Bottom = running.runTrialsBottomUp(6, 2);
      int minTrials2Recur = running.runTrialsRecur(20, 8);
      int minTrials2Bottom = running.runTrialsBottomUp(20, 8);
      System.out.println("6 speeds, 2 days: " + minTrials1Recur + " " + minTrials1Bottom);
      System.out.println("20 speeds, 8 days: " + minTrials2Recur + " " + minTrials2Bottom);
      
  }
}
