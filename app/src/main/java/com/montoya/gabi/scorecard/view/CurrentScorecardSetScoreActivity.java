package com.montoya.gabi.scorecard.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.CurrentScorecard;
import com.montoya.gabi.scorecard.model.Hole;

public class CurrentScorecardSetScoreActivity extends AppCompatActivity {


    public static final String HOLE_NUMBER_PARAMETER_KEY="current_scorecard_Score_hole_key";
    Hole.HoleNumber mHole;
    CurrentScorecard mCurrentScorecard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_scorecard_set_score_activity);

        getIntentParameter();



        mCurrentScorecard=new CurrentScorecard(getApplicationContext());

        setTitle("Hole 1");



    }

    private void getIntentParameter(){



        mHole=Hole.convertIntToHoleNumber(getIntent().getExtras().getInt(HOLE_NUMBER_PARAMETER_KEY,Hole.HoleNumber.HOLE_INVALID.getValue()));

    }


}
