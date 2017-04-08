package com.montoya.gabi.scorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.montoya.gabi.scorecard.firebase.UserAuthentication;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    //Bind Views
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.toolbar) Toolbar toolbar;


    //Bind Events
    @OnClick(R.id.fab)
    public void click(View view){
        Snackbar.make(view, "Replace with your own action - BUTTER KNIFE", Snackbar.LENGTH_LONG).setAction("Action", null).show();

    }


    private UserAuthentication mUserAuthentication;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Initialize the UserAuthentication class and the listener for log in
        mUserAuthentication=new UserAuthentication(this);
        mUserAuthentication.initializeAuthenticationStateListener();


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                return true;
            case R.id.action_sign_out:
                //sign out
                mUserAuthentication.signOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==mUserAuthentication.getRC_SIGN_IN()){
            if (resultCode==RESULT_OK){

                onSignedIn();

                //TODO remove the toast after verifying that everything works as expected.
                Toast.makeText(this,"Signed in!",Toast.LENGTH_SHORT).show();

            }else if (resultCode==RESULT_CANCELED){

                //TODO remove the toast after verifying that everything works as expected.
                Toast.makeText(this,"Sign in canceled!",Toast.LENGTH_SHORT).show();
                finish();

            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mUserAuthentication.attachAuthStateListener();//attach the Authorization StateListener
    }

    @Override
    protected void onPause() {
        super.onPause();
        mUserAuthentication.detachAuthStateListener(); //dettach the Authorization StateListener

    }

    private void onSignedIn(){

        //TODO add functionality what to do if the user is logged (for example get the user name, show the log out action, etc.... TBD)

    }
}
