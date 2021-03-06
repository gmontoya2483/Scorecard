package com.montoya.gabi.scorecard.firebase;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import java.util.Arrays;

import retrofit2.http.Url;

/**
 * Created by montoya on 06.04.2017.
 */

public class UserAuthentication {

    private final int RC_SIGN_IN = 1000;
    public static final String ANONYMOUS = "anonymous";
    public static final String NO_EMAIL = "no_email";







    //FireBaseUI Member Variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private Context mContext;
    private final Activity mActivity;


    private String mUserDisplayName;
    private String mUserEmail;
    private Uri mUserPhotoUri;



    public UserAuthentication(Activity activity) {
        mActivity=activity;
        mContext=activity.getApplicationContext();

        //Initialize Firebase components
        mFirebaseAuth=FirebaseAuth.getInstance();
        if (mFirebaseAuth.getCurrentUser()!=null){
            this.mUserDisplayName=mFirebaseAuth.getCurrentUser().getDisplayName();
            this.mUserEmail=mFirebaseAuth.getCurrentUser().getEmail();
            this.mUserPhotoUri=mFirebaseAuth.getCurrentUser().getPhotoUrl();
        }

    }


    /*This method is used to initialize the authentication State listener
    * mAuthStateListener private variable
    * this method triggers either the onSignedIn or onSignedOut methods*/
    public void initializeAuthenticationStateListener(){

        if (mAuthStateListener==null){

            mAuthStateListener=new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                    mFirebaseAuth=firebaseAuth;
                    if (mFirebaseAuth.getCurrentUser()!=null){
                        //user is signed in
                        onSignedIn();

                    }else {
                        // user is signed out
                        onSignedOut();
                    }

                }
            };

        }

    }



    /*This method is used to attach the authentication State listener into the FirebaseAuth instance
    */
    public void attachAuthStateListener(){

        if (mAuthStateListener!=null){
            mFirebaseAuth.addAuthStateListener(mAuthStateListener);
        }

    }


    /*This method is used to detach the authentication State listener from the FirebaseAuth instance
    */
    public void detachAuthStateListener(){
        if (mAuthStateListener!=null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }


    /*Getter method which return the current FirebaseUser (mUser)*/
    //public FirebaseUser getUser(){
    //    return mUser;
    //}


    public FirebaseAuth getFirebaseAuth() {
        return mFirebaseAuth;
    }

    /*Getter method which return the value of request Sign In constant*/
    public int getRC_SIGN_IN(){
        return RC_SIGN_IN;
    }


    /*Getter method which return Display Name as String it will return ANONYMOUS in case the user is logged out*/
    public String getUserDisplayName(){
        String displayName;
        if (mFirebaseAuth.getCurrentUser()!=null){
            displayName=mFirebaseAuth.getCurrentUser().getDisplayName();
        }else {
            displayName=ANONYMOUS;
        }

        return displayName;
    }


    /*Getter method which return Display Name as String it will return NO_EMAIL in case the user is logged out*/
    public String getUserEmail(){
        String email;
        if (mFirebaseAuth.getCurrentUser()!=null){
            email=mFirebaseAuth.getCurrentUser().getEmail();
        }else {
            email=NO_EMAIL;
        }

        return email;
    }



    /*Actions that are performed if the user is logged in*/
    private void onSignedIn(){




    }


    /*Actions that are performed if the user is logged out
    * It triggers a log in screen by using the FirebaseUI library*/
    private void onSignedOut(){


        mActivity.startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setTheme(R.style.LogInTheme)
                        .setLogo(R.drawable.logo)
                        .setIsSmartLockEnabled(false)
                        .setProviders(Arrays.asList(
                                new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                        .build(),
                RC_SIGN_IN);
    }


    /*Method for signing out from the application*/
    public void signOut(){

        AuthUI.getInstance().signOut(mActivity);

    }




}
