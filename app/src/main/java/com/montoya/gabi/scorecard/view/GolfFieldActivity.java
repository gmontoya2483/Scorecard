package com.montoya.gabi.scorecard.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.GolfField;

import static com.montoya.gabi.scorecard.view.GolfFieldActivityFragment.ACTION_LABEL;
import static com.montoya.gabi.scorecard.view.GolfFieldActivityFragment.ACTION_NEW;
import static com.montoya.gabi.scorecard.view.GolfFieldActivityFragment.ACTION_VIEW;
import static com.montoya.gabi.scorecard.view.GolfFieldActivityFragment.GOLF_FIELD_ID_LABEL;

public class GolfFieldActivity extends AppCompatActivity {

    String mAction;
    long mGolfField_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golf_field);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Show the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        retrieveArguments();

        displayGolfFieldFragment();


    }


    private void retrieveArguments(){

        Bundle args;
        args=getIntent().getExtras();

        if (args!=null){

            mAction=args.containsKey(ACTION_LABEL)?args.getString(ACTION_LABEL):ACTION_NEW;

            if (mAction.equals(ACTION_VIEW)){
                if (args.containsKey(GOLF_FIELD_ID_LABEL)){
                    mGolfField_id= args.getLong(GOLF_FIELD_ID_LABEL);

                }else{
                    mAction=ACTION_NEW;
                    mGolfField_id= GolfField.NOT_SAVED_GOLF_FIELD_ID;

                }

            }else{
                mGolfField_id=GolfField.NOT_SAVED_GOLF_FIELD_ID;
            }


        }else{

            mAction=ACTION_NEW;
            mGolfField_id=GolfField.NOT_SAVED_GOLF_FIELD_ID;

        }


    }



    private void displayGolfFieldFragment(){

        Fragment fragment=null;
        Bundle args=new Bundle();
        fragment=new GolfFieldActivityFragment();


        switch(mAction) {

            case  ACTION_NEW:
                args.putString(ACTION_LABEL,ACTION_NEW);


                break;
            case ACTION_VIEW:
                args.putString(ACTION_LABEL,ACTION_VIEW);
                args.putLong(GOLF_FIELD_ID_LABEL,mGolfField_id);

                break;
            default:
                args.putString(ACTION_LABEL,ACTION_NEW);
                break;

        }


        fragment.setArguments(args);


        getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_golf_field,fragment)
                    .commit();




    }






}
