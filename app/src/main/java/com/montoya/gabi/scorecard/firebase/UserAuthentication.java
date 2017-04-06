package com.montoya.gabi.scorecard.firebase;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

/**
 * Created by montoya on 06.04.2017.
 */

public class UserAuthentication {

    private final int RC_SIGN_IN = 1;


    //FireBaseUI Member Variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private Context mContext;


    public UserAuthentication(final Activity activity) {

        mContext=activity.getApplicationContext();

        //Initialize Firebase components
        mFirebaseAuth=FirebaseAuth.getInstance();


        //Initialize Authentication StateListener
        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user=firebaseAuth.getCurrentUser();
                if (user!=null){
                    //user is signed in
                    Toast.makeText(mContext, "You are now signed in ... Welcome",Toast.LENGTH_SHORT).show();


                }else {
                    // user is signed out
                    activity.startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()))
                                    .build(),
                            RC_SIGN_IN);

                }

            }
        };

    }



    public void AddAuthStateListener(){
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }



    public void RemoveAuthStateListener(){
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }



    public int getRC_SIGN_IN(){
        return RC_SIGN_IN;
    }





}
