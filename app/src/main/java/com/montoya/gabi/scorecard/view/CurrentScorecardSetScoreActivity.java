package com.montoya.gabi.scorecard.view;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.CurrentScorecard;
import com.montoya.gabi.scorecard.model.Hole;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentScorecardSetScoreActivity extends AppCompatActivity {


    public static final String HOLE_NUMBER_PARAMETER_KEY="current_scorecard_Score_hole_key";
    Hole.HoleNumber mHole;
    CurrentScorecard mCurrentScorecard;

    @BindView(R.id.set_score_hole_text)
    TextView mHoleText;

    @BindView(R.id.set_score_length_text)
    TextView mLengthText;

    @BindView(R.id.set_score_par_text)
    TextView mParText;

    @BindView(R.id.set_score_score_edit)
    TextView mScoreEditText;

    @BindView(R.id.set_score_confirm_button)
    TextView mConfirmButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_scorecard_set_score_activity);

        //Bind the View
        ButterKnife.bind(this);

        getIntentParameter();

        mCurrentScorecard=new CurrentScorecard(getApplicationContext());

        setActivityLayout();

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setHoleScore();
                finish();
            }
        });





    }

    private void getIntentParameter(){

        mHole=Hole.convertIntToHoleNumber(getIntent().getExtras().getInt(HOLE_NUMBER_PARAMETER_KEY,Hole.HoleNumber.HOLE_INVALID.getValue()));

    }

    private void setActivityLayout(){

        setTitle(null);


        String hole_length= ScorecardUtils.getFormattedLength(getApplicationContext(),mCurrentScorecard.getHoleLength(mHole));
        String hole_par= ScorecardUtils.getFormattedPar(getApplicationContext(),mCurrentScorecard.getHolePar(mHole).getValue());
        String hole_score= ScorecardUtils.getFormattedScore(mCurrentScorecard.getHoleScore(mHole));


        mLengthText.setText(hole_length);
        mParText.setText(hole_par);
        mScoreEditText.setText(hole_score);
        mHoleText.setText(ScorecardUtils.getFormattedHoleNumber(getApplicationContext(),mHole));




    }


    private void setHoleScore(){

        int score;

        if (mScoreEditText.length()==0){
            score=CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE;
        }else{
            score= Integer.parseInt(mScoreEditText.getText().toString());
        }

         mCurrentScorecard.setHoleScore(mHole,score);

    }





}
