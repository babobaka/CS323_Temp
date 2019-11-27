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
	    int results;
	    for (int i = 1; i <= possibleSpeeds; i++) {
	    	results = Math.max(runTrialsRecur(i-1,days-i), runTrialsRecur(possibleSpeeds-i,days));
	    	if (results < minTests)
	    		minTests = results;
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
    int[][] runTrials = new int[days+1][possibleSpeeds + 1];
    int results;
    for (int i = 1; i <= days; i++){
      runTrials[i][1] = 1;
      runTrials[i][0] = 0;
    }
    for (int i = 1; i <= possibleSpeeds; i++){
      runTrials[1][i] = i;
    }
    for (int i = 2; i <= days; i++){
      for (int j = 2; j <= possibleSpeeds; j++){
        runTrials[i][j] = Integer.MAX_VALUE;
        for (int k = 1; k <= j; k++){
          results = 1 + Math.max(runTrials[i-1][k-1],runTrials[i][j-k]);
          if(results < runTrials[i][j])
          runTrials[i][j] = results;
         }
      }
    }
    minTests = runTrials[days][possibleSpeeds];
    return minTests;
  }

  public static void main(String args[]){
      RunningTrials running = new RunningTrials();

      // Do not touch the below lines of code, your output will automatically be formatted
      int minTrials1Recur = running.runTrialsRecur(6,2);
      int minTrials1Bottom = running.runTrialsBottomUp(6, 2);
      int minTrials2Recur = running.runTrialsRecur(20, 8);
      int minTrials2Bottom = running.runTrialsBottomUp(20, 8);
      System.out.println("6 speeds, 2 days: " + minTrials1Recur + " " + minTrials1Bottom);
      System.out.println("20 speeds, 8 days: " + minTrials2Recur + " " + minTrials2Bottom);

  }
}
