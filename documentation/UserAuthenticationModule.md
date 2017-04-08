UserAuthentication Module
-------------------------

* [Overview](#overview)
* [Setup the UserAuthentication Module](#setup-the-userauthentication-module)
* [firebase.UserAuthentication class](#firebaseuserauthentication-class)
* [How to implement it](#how-to-implement-it)
* [To do](#to-do)
* [Reference Documentation](#reference-documentation)




## Overview
This module is in charge of managing the Firebase user authentication by using FirebaseAuthentication and FirebaseUI library.


## Setup the UserAuthentication Module


1 - Add dependencies  

Add the both the Firebase and FirebaseUI auth libraries dependency into the app Gradle:

```
dependencies {
    // ...

    // /Adding the FireBase core and Authentication and Ads
    compile 'com.google.firebase:firebase-core:10.0.1'
    compile 'com.google.firebase:firebase-auth:10.0.1'

    //Adding the FireBaseUI library - Only Authentication
    compile 'com.firebaseui:firebase-ui-auth:1.0.1'
}
```

and add the fabric repository into the project Gradle:

```
allprojects {
    repositories {
        // ...
        maven { url 'https://maven.fabric.io/public' }
    }
}
```


## firebase.UserAuthentication class

### Public constructors:

```java
    public UserAuthentication(Activity activity)
```

It creates an UserAuthentication instance and initialize member Variables.


### Public constants:

Type     | Description
    --------------------- | ---------------------
    ```String``` | ```ANONYMOUS```<P>The user is not logged in.
    ```String``` | ```NO_EMAIL```<P>The user has not a registered email.

### Public methods:
Return     | Description
    --------------------- | ---------------------
    ```void``` | ```initializeAuthenticationStateListener()```<P>This method is used to initialize the authentication State listener and triggers either the ```onSignedIn()``` or ```onSignedOut()``` private methods.
    ```void``` | ```attachAuthStateListener()```<P>This method is used to attach the authentication State listener into the FirebaseAuth instance.
    ```void``` | ```detachAuthStateListener()```<P>This method is used to dettach the authentication State listener into the FirebaseAuth instance.
    ```FirebaseUser``` | ```getUser()```<P>Getter method which return the current FirebaseUser (```mUser```).
    ```int``` | ```getRC_SIGN_IN()```<P>Getter method which return the value of request Sign In constant (```RC_SIGN_IN```).
    ```String``` | ```getUserDisplayName()```<P>Getter method which return Display Name as String. In case the user is logged out, it will return the ```ANONYMOUS``` constant.
    ```String``` | ```getUserEmail()```<P>Getter method which return the user email. In case the user has not a registered email, it will return the ```NO_EMAIL``` constant.

## How to implement it

1 - Define in the FireBase console the Authentication methods that are allowed.


<img src="Scorecard/documentation/documentation_images/firebase_auth_methods.png" height="400" alt="Authentication Methods"/>
    

2 - Add within the ```onSignedOut()``` the selected Authentication methods.

```java

    private void onSignedOut(){

        //...


        mActivity.startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setLogo(R.drawable.logo)
                        .setIsSmartLockEnabled(false)
                        .setProviders(Arrays.asList(
                                new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                        .build(),
                RC_SIGN_IN);
    }

```


3 - Add the following code lines in the ```MainActivity``` within the ```onCreate``` method.

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //...


        //Initialize the UserAuthentication class and the listener for log in
        mUserAuthentication=new UserAuthentication(this);
        mUserAuthentication.initializeAuthenticationStateListener();

        //...


    }
```


4 - Add the following code lines in the ```MainActivity``` within the ```onResume``` and ```onPause``` methods.

```java
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
```


5 - Add the following code lines in the ```MainActivity``` within the ```onActivityResult``` method.

```java
    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode==mUserAuthentication.getRC_SIGN_IN()){
                if (resultCode==RESULT_OK){

                    //TODO add any action when the user is signed in after the loggin screen.
                    Toast.makeText(this,"Signed in!",Toast.LENGTH_SHORT).show();

                }else if (resultCode==RESULT_CANCELED){

                    //TODO add any action weh the user cancels the log in and end this block with finish();.
                    Toast.makeText(this,"Sign in canceled!",Toast.LENGTH_SHORT).show();
                    finish();

                }
            }
        }
```



## To do

Add the sign out functionality.




## Reference Documentation
https://firebase.google.com/docs/auth/
https://github.com/firebase/FirebaseUI-Android
https://github.com/firebase/FirebaseUI-Android/tree/master/auth
