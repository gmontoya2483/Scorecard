package com.montoya.gabi.scorecard.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.montoya.gabi.scorecard.R;

public class GolfFieldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golf_field);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Show the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Fragment fragment=null;
        boolean fragmentTransaction=false;
        Bundle args=new Bundle();



        //TODO Muestra arreglarlo!!! para recicir el bundle y mandar la info al fragment.
        fragment=new GolfFieldActivityFragment();
        args.putString("ACTION","New");
        fragment.setArguments(args);
        fragmentTransaction=true;


        if (fragmentTransaction){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_golf_field,fragment)
                    .commit();

            //item.setChecked(true);
            //getSupportActionBar().setTitle(item.getTitle());

        }


    }

}
