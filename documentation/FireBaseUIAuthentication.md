FirebaseUI - Authentication:
----------------------------



##Github

https://github.com/firebase/FirebaseUI-Android/tree/master/auth


## Steps to  Implement Authentication with FirebaseUI


1 - Add dependencies  

Add the FirebaseUI auth library dependency into the app Gradle:

```
dependencies {
    // ...
    compile 'com.firebaseui:firebase-ui-auth:1.2.0'
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

 

2 - Add AuthStateListener:

This lister is attached to the fire base off object. and it executes whenever the authentication state cahanges:

*  The listener is first attached to FireBaseAuth
*  User signs in
*  User sign out



   


3 - Send unauthenticated users to sign in flow  


4 - Sign in set up and sign out tear down





