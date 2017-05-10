package com.montoya.gabi.scorecard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.montoya.gabi.scorecard.firebase.UserAuthentication;
import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;
import com.montoya.gabi.scorecard.view.FragmentCamera;
import com.montoya.gabi.scorecard.view.FragmentGaleria;
import com.montoya.gabi.scorecard.view.GolfFieldsFragment;
import com.montoya.gabi.scorecard.view.PlayerFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, GolfFieldsFragment.OnFragmentInteractionListener, PlayerFragment.OnFragmentInteractionListener, FragmentCamera.OnFragmentInteractionListener, FragmentGaleria.OnFragmentInteractionListener{



    //Bind Views
    //@BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.toolbar) Toolbar toolbar;


    private UserAuthentication mUserAuthentication;

    private final String SELECTED_MENU_ITEM_LABEL="selected_menu_item_label";
    private int mSelectedItemMenu;

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    NavigationView navigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Verific si hay campos de golf cargados y los carga...//TODO borrar cuando se haya terminado de probsar
        if (GolfField.getQuantityOfGolfFields(getApplicationContext())==0){
       ScorecardContract.GolfFieldEntry.generatePreLoadedGolfFields(getApplicationContext());
        }

        //Initialize the UserAuthentication class and the listener for log in
        mUserAuthentication=new UserAuthentication(this);
        mUserAuthentication.initializeAuthenticationStateListener();


        //set the navigation to the last selected option  when comming back
        setNavigationInPreviousStatus();

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ScorecardUtils.RemoveKeyFromSharedPreferences(this,SELECTED_MENU_ITEM_LABEL);
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



            }else if (resultCode==RESULT_CANCELED){


                finish();

            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mUserAuthentication.attachAuthStateListener();//attach the Authorization StateListener
        setNavigationInPreviousStatus();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mUserAuthentication.detachAuthStateListener(); //dettach the Authorization StateListener
        ScorecardUtils.AddIntToSharedPreferences(this,SELECTED_MENU_ITEM_LABEL,mSelectedItemMenu);

    }

    private void onSignedIn(){

        //TODO add functionality what to do if the user is logged (for example get the user name, show the log out action, etc.... TBD)

    }



    //Navigation Bar interfase Methods
    //@Override
    //public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    //    return false;
    //}


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Bundle args=new Bundle();

        Fragment fragment=null;
        boolean fragmentTransaction=false;

        if (id == R.id.nav_player_handicap) {
            // Handle the camera action
            fragment=new PlayerFragment();
            fragmentTransaction=true;


        } else if (id == R.id.nav_scorecards) {
            fragment=new FragmentGaleria();
            fragmentTransaction=true;

        } else if (id == R.id.nav_current_scorecards) {

            Log.i("NavigationDrawer", "Option slideshow");

        } else if (id == R.id.nav_golf_fields) {

            fragment=new GolfFieldsFragment();
            args.putString(GolfFieldsFragment.TYPE_LABEL,GolfFieldsFragment.TYPE_ALL_GOLF_FIELDS);
            fragment.setArguments(args);
            fragmentTransaction=true;

        } else if (id == R.id.nav_favorite_golf_fields) {
            fragment=new GolfFieldsFragment();
            args.putString(GolfFieldsFragment.TYPE_LABEL,GolfFieldsFragment.TYPE_FAVORITE_GOLF_FIELDS);
            fragment.setArguments(args);
            fragmentTransaction=true;

        } else if (id == R.id.nav_settings) {





        }


        mSelectedItemMenu=id;


        //manejador de fragment

        if (fragmentTransaction){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_main,fragment)
                    .commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

        }




        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }




    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);




    }


    private void setNavigationInPreviousStatus(){

       int id=ScorecardUtils.RetrieveIntFromSharedPreferences(this,SELECTED_MENU_ITEM_LABEL);

       if (id==ScorecardUtils.PREFERENCES_INVALID_INT){
           id=R.id.nav_scorecards;
       }

       navigationView.setCheckedItem(id);
       navigationView.getMenu().performIdentifierAction(id,0);

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
