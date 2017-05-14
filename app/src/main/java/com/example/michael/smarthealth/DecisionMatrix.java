package com.example.michael.smarthealth;

/**
 * Created by Robin on 4/15/2017.
 */

import java.util.Arrays;

/******************************************************************************
 * Create a DecisionMatrix for each exercise
 * i.e.  DecisionMatrix pushup = new DecisionMatrix(int userID, int exerciseID)
 *
 * Decision Matrix:
 * --------------------------------------------------------------------------
 * factors # of positive/week Average success Scores Weights 0.4 0.6
 *
 * Levels(1) y z 0.4*x + 0.6*y Badges(2) y z 0.4*x + 0.6*y Facts(3) y z
 * 0.4*x + 0.6*y Friends(4) y z 0.4*x + 0.6*y Competition(5) y z 0.4*x +
 * 0.6*y
 * --------------------------------------------------------------------------
 * percentages for each = their Total/(sum of all Totals)
 *
 * Exercise IDs
 * 1. push ups
 * 2. sit ups
 * 3. pull ups
 * 4. squats
 *
 * Gamification IDs
 * 1. Level
 * 2. Badge
 * 3. Fact
 * 4. Friend
 * 5. Competition
 *******************************************************************************/

public class DecisionMatrix {

    private int userID; // user ID
    private int exerciseID; // exercise ID

    private double[] totalSR; // Running total of success rates
    private int[] numTimes; // count of how many of each was done;
    private double[] avgSR; // average success rates

    private double[][] weekSR; // Keep track of last 7 success rates
    private int[] weekNumSuccess; // # of weekly successes

    private double[] scores; // scores
    private double sum; // Sum of Totals
    private double[] weights; // Weights

    private int gameId;
    private double currentSR;       //

    public DecisionMatrix(int user, int exercise) {
        userID = user;
        exerciseID = exercise;
        totalSR = new double[5];
        numTimes = new int[5];
        avgSR = new double[5];
        weekSR = new double[5][7];
        weekNumSuccess = new int[5];
        scores = new double[5];
        sum = 0.0;
        weights = new double[5];

        // default scores for decision matrix
        for (int i = 0; i < 5; i++) {
            scores[i] = 1;
        }

        // default weekly successes
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                weekSR[i][j] = 0.1;
            }
        }

        // default weights
        calcWeights();

        currentSR = 0;
    }

    /********************************************
     * private tool for class
     ********************************************/
    // calculate weights
    private void calcWeights() {
        sum = 0.0;
        // calculate the sum of scores
        for (int i = 0; i < 5; i++) {
            sum += scores[i];
        }

        // calculate weight for each game method
        for (int i = 0; i < 5; i++) {
            weights[i] = scores[i] / sum;
        }
    }

    /********************************************
     * public methods
     ********************************************/
    public int chooseMethod() {
        // choose a random number and see which method gets chosen depending on
        // weights
        double num = Math.random(); // random # between 0 and 1
        double limit = weights[0]; // first limit is up to levelsWeight
        int i = 0; // weights array index

        while (num > limit)
        // instead of 0
        {
            limit += weights[i];
            i++;
        }

        return i;
    }

	/*  this is to be called after a new entry has been added to db progress table
	public void update() {

		***********NEED DB STUFF HERE************
		get the last entry of database for this userID and exerciseID
		gameID = ??; //gamification id from database
		successRate = ??; //success rate from database

		//take off oldest success rate and add newest success rate
		for (int i=0; i<6; i++)
		{
		 	weekSR[gameID-1][i] = weekSR[gameID-1][i+1];
		}
		weekSR[gameID-1][6] = successRate;

		//count # of successes past week and put into weekNumSuccess
		weekNumSuccess[gameID-1] = 0;
		for (int i=0; i<7; i++)
		{
		 	if(weekSR[gameID-1][i] == 1)
			{
				weekNumSuccess[gameID-1]++;
			}
		}

		//update avg success rate
		totalSR[gameID-1] += successRate;		//add to success rate running total
		numTimes[gameID-1]++; 					//increment # of times game method used
		avgSR[gameID-1] = totalSR[gameID-1] / numTimes[gameID-1]; 		//total success / num times used

		//calculate new scores for this game method
		scores[gameID-1] = 0.4*weekNumSuccess[gameID-1] + 0.6*avgSR[gameID-1];

		//calculate new weights
		calcWeights();

	}
	 */


    /********************************************
     *********FOR TESTING PURPOSES**********
     ********************************************/
    public void update(int gameID, double successRate) {
        gameId = gameID;
        currentSR = successRate;
        //take off oldest success rate and add newest success rate
        for (int i=0; i<6; i++)
        {
            weekSR[gameID-1][i] = weekSR[gameID-1][i+1];
        }
        weekSR[gameID-1][6] = successRate;

        //count # of successes past week and put into weekNumSuccess
        weekNumSuccess[gameID-1] = 0;
        for (int i=0; i<7; i++)
        {
            if(weekSR[gameID-1][i] == 1)
            {
                weekNumSuccess[gameID-1]++;
            }
        }

        //update avg success rate
        totalSR[gameID-1] += successRate;		//add to success rate running total
        numTimes[gameID-1]++; 					//increment # of times game method used
        avgSR[gameID-1] = totalSR[gameID-1] / numTimes[gameID-1]; 		//total success / num times used

        //calculate new scores for this game method
        scores[gameID-1] = 0.4*weekNumSuccess[gameID-1] + 0.6*avgSR[gameID-1];

        //calculate new weights
        calcWeights();
    }
    /********************************************
     *********END TESTING METHOD**********
     ********************************************/




    /********************************************
     * getters, setters, toString
     ********************************************/

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    public double[] getTotalSR() {
        return totalSR;
    }

    public void setTotalSR(double[] totalSR) {
        this.totalSR = totalSR;
    }

    public int[] getNumTimes() {
        return numTimes;
    }

    public void setNumTimes(int[] numTimes) {
        this.numTimes = numTimes;
    }

    public double[] getAvgSR() {
        return avgSR;
    }

    public void setAvgSR(double[] avgSR) {
        this.avgSR = avgSR;
    }

    public double[][] getWeekSR() {
        return weekSR;
    }

    public void setWeekSR(double[][] weekSR) {
        this.weekSR = weekSR;
    }

    public int[] getWeekNumSuccess() {
        return weekNumSuccess;
    }

    public void setWeekNumSuccess(int[] weekNumSuccess) {
        this.weekNumSuccess = weekNumSuccess;
    }

    public double[] getScores() {
        return scores;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double[] getWeights() { return weights; }

    public void setWeights(double[] weights) { this.weights = weights; }

    public double getCurrentSR() { return currentSR; }

    public void setCurrentSR(double sr) { this.currentSR = sr; }

    @Override
    public String toString() {
        String weekSRString = "";
        for (int i=0; i<5; i++)
        {
            weekSRString += "\n"+ Arrays.toString(weekSR[i]);
        }
        return "DecisionMatrix \n"
                + "userID=" + userID + "\n"
                + "exerciseID=" + exerciseID + "\n"
                + "totalSR=" + Arrays.toString(totalSR) + "\n"
                + "numTimes=" + Arrays.toString(numTimes) + "\n"
                + "avgSR=" + Arrays.toString(avgSR) + "\n"
                + "weekSR=" + weekSRString + "\n"
                + "weekNumSuccess=" + Arrays.toString(weekNumSuccess) + "\n"
                + "scores=" + Arrays.toString(scores) + "\n"
                + "sum=" + sum + "\n"
                + "weights=" + Arrays.toString(weights);
    }



}