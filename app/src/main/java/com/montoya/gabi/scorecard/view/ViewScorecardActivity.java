package com.montoya.gabi.scorecard.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.Scorecard;

public class ViewScorecardActivity extends AppCompatActivity {

    long mScorecard_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_scorecard_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Show the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (savedInstanceState==null){
            retrieveArguments();
            displayScorecardFragment();

        }


    }


    private void retrieveArguments() {

        Bundle args;
        args = getIntent().getExtras();

        if (args != null && args.containsKey(ViewScorecardActivityFragment.SCORECARD_ID_LABEL)) {

            mScorecard_id = args.getLong(ViewScorecardActivityFragment.SCORECARD_ID_LABEL, mScorecard_id = Scorecard.SCORECARD_INVALID_ID);


        } else {
            mScorecard_id = Scorecard.SCORECARD_INVALID_ID;
        }

    }


    private void displayScorecardFragment(){


        if (mScorecard_id!=Scorecard.SCORECARD_INVALID_ID){

            Fragment fragment=null;
            Bundle args=new Bundle();
            fragment=new ViewScorecardActivityFragment();

            args.putLong(ViewScorecardActivityFragment.SCORECARD_ID_LABEL,mScorecard_id);

            fragment.setArguments(args);


            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_view_scorecard,fragment)
                    .commit();


        }else{
            Toast.makeText(this, R.string.view_scorecard_invalid_id,Toast.LENGTH_LONG).show();
            this.finish();

        }

    }




}
