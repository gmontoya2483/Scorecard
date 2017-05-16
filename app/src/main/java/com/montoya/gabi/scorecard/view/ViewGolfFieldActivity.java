package com.montoya.gabi.scorecard.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.GolfField;

public class ViewGolfFieldActivity extends AppCompatActivity {


    String mAction;
    long mGolfField_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_golf_field_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Show the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        if (savedInstanceState==null){
            retrieveArguments();
            displayGolfFieldFragment();

        }

    }



    private void retrieveArguments() {

        Bundle args;
        args = getIntent().getExtras();

        if (args != null && args.containsKey(ViewGolfFieldActivityFragment.GOLF_FIELD_ID_LABEL)) {

            mGolfField_id = args.getLong(ViewGolfFieldActivityFragment.GOLF_FIELD_ID_LABEL, mGolfField_id = GolfField.INVALID_GOLF_FIELD_ID);


        } else {

            mGolfField_id = GolfField.INVALID_GOLF_FIELD_ID;

        }

    }



    private void displayGolfFieldFragment(){


        if (mGolfField_id!=GolfField.INVALID_GOLF_FIELD_ID){

            Fragment fragment=null;
            Bundle args=new Bundle();
            fragment=new ViewGolfFieldActivityFragment();

            args.putLong(ViewGolfFieldActivityFragment.GOLF_FIELD_ID_LABEL,mGolfField_id);

            fragment.setArguments(args);


            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_view_golf_field,fragment)
                    .commit();


        }else{
            Toast.makeText(this, R.string.view_golf_field_invalid_id,Toast.LENGTH_LONG).show();
            this.finish();

        }

    }










}
