package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds 6 points to Team A's score
     */
    public void touchdownA(View view){
        TextView scoreView = (TextView) findViewById(R.id.game_over_message);
        scoreView.setText("");
        scoreTeamA += 6;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Adds 1 points to Team A's score
     */
    public void extraPointA(View view){
        TextView scoreView = (TextView) findViewById(R.id.game_over_message);
        scoreView.setText("");

        scoreTeamA++;
        displayForTeamA(scoreTeamA);
}

    /**
     * Adds 3 point to Team A's score
     */
    public void fieldGoalA(View view){
        TextView scoreView = (TextView) findViewById(R.id.game_over_message);
        scoreView.setText("");

        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Adds 2 point to Team A's score
     */
    public void safetyA(View view){
        TextView scoreView = (TextView) findViewById(R.id.game_over_message);
        scoreView.setText("");

        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds 6 points to Team B's score
     */
    public void touchdownB(View view){
        TextView scoreView = (TextView) findViewById(R.id.game_over_message);
        scoreView.setText("");

        scoreTeamB += 6;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Adds 1 points to Team B's score
     */
    public void extraPointB(View view){
        TextView scoreView = (TextView) findViewById(R.id.game_over_message);
        scoreView.setText("");

        scoreTeamB++;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Adds 3 point to Team B's score
     */
    public void fieldGoalB(View view){
        TextView scoreView = (TextView) findViewById(R.id.game_over_message);
        scoreView.setText("");

        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Adds 2 point to Team B's score
     */
    public void safetyB(View view){
        TextView scoreView = (TextView) findViewById(R.id.game_over_message);
        scoreView.setText("");

        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Resets scores
     */
    public void reset(View view){
        TextView scoreView = (TextView) findViewById(R.id.game_over_message);
        if(scoreTeamA > scoreTeamB)
            scoreView.setText("Team A Wins!");
        else if(scoreTeamA < scoreTeamB){
            scoreView.setText("Team B Wins!");
        }
        else
            scoreView.setText("Tie Game!");

        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
