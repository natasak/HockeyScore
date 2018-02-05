package com.example.android.hockeyscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int penaltyTeamA = 0;
    int penaltyTeamB = 0;

    //keys for saved states
    public static final String keyScoreTeamA = "keyScoreTeamA";
    public static final String keyScoreTeamB = "keyScoreTeamB";
    public static final String keyPenaltyTeamA = "keyPenaltyTeamA";
    public static final String keyPenaltyTeamB = "keyPenaltyTeamB";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Save states of variables, just before the screen is rotated.
     * @param outState saves the state of variables
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("keyScoreTeamA", scoreTeamA);
        outState.putInt("keyScoreTeamB", scoreTeamB);
        outState.putInt("keyPenaltyTeamA", penaltyTeamA);
        outState.putInt("keyPenaltyTeamB", penaltyTeamB);

        super.onSaveInstanceState(outState);
    }

    /**
     * When screen is rotated restore the variables from onSaveInstanceState.
     * @param savedInstanceState restores the previous state
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        int scoreTeamA = savedInstanceState.getInt("keyScoreTeamA");
        int scoreTeamB = savedInstanceState.getInt("keyScoreTeamB");
        int penaltyTeamA = savedInstanceState.getInt("keyPenaltyTeamA");
        int penaltyTeamB = savedInstanceState.getInt("keyPenaltyTeamB");

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayPenaltiesForTeamA(penaltyTeamA);
        displayPenaltiesForTeamB(penaltyTeamB);


        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the given score for 1 point for Team A.
     */
    public void goalA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the given score for 1 point for Team B.
     */
    public void goalB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given penalties for Team A.
     */
    public void displayPenaltiesForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_penalty);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given penalties for Team B.
     */
    public void displayPenaltiesForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_penalty);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the given penalties for +2 minutes for Team A.
     */
    public void add2forA(View view) {
        penaltyTeamA = penaltyTeamA + 2;
        displayPenaltiesForTeamA(penaltyTeamA);
    }

    /**
     * Increase the given penalties for +5 minutes for Team A.
     */
    public void add5forA(View view) {
        penaltyTeamA = penaltyTeamA + 5;
        displayPenaltiesForTeamA(penaltyTeamA);
    }

    /**
     * Increase the given penalties for +10 minutes for Team A.
     */
    public void add10forA(View view) {
        penaltyTeamA = penaltyTeamA + 10;
        displayPenaltiesForTeamA(penaltyTeamA);
    }

    /**
     * Increase the given penalties for +2 minutes for Team B.
     */
    public void add2forB(View view) {
        penaltyTeamB = penaltyTeamB + 2;
        displayPenaltiesForTeamB(penaltyTeamB);
    }

    /**
     * Increase the given penalties for +5 minutes for Team B.
     */
    public void add5forB(View view) {
        penaltyTeamB = penaltyTeamB + 5;
        displayPenaltiesForTeamB(penaltyTeamB);
    }

    /**
     * Increase the given penalties for +10 minutes for Team B.
     */
    public void add10forB(View view) {
        penaltyTeamB = penaltyTeamB + 10;
        displayPenaltiesForTeamB(penaltyTeamB);
    }

    /**
     * reset scores and penalties for Team A and B.
     */
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        penaltyTeamA = 0;
        penaltyTeamB = 0;
        displayForTeamA(scoreTeamB);
        displayForTeamB(scoreTeamB);
        displayPenaltiesForTeamA(penaltyTeamA);
        displayPenaltiesForTeamB(penaltyTeamB);
    }
}
