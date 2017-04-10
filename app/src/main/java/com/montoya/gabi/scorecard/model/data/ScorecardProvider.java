package com.montoya.gabi.scorecard.model.data;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by montoya on 10.04.2017.
 */

public class ScorecardProvider extends ContentProvider{


    private static final String LOG_TAG=ScorecardProvider.class.getSimpleName();
    private static final UriMatcher mUriMatcher=buildUriMatcher();
    private ScorecardDbHelper mScorecardDbHelper;



    //Codes for the UriMatcher
    //TODO Define the codes
    /*
    public static final int MOVIE=100;
    public static final int MOVIE_WITH_ID=110;
    public static final int FAVORITE=200;
    public static final int FAVORITE_WITH_ID=210;
    public static final int VIDEO=300;
    public static final int VIDEO_WITH_MOVIE_ID=320;
    public static final int VIDEO_WITH_KEY=330;
    public static final int REVIEW=400;
    public static final int REVIEW_WITH_ID=410;
    public static final int REVIEW_WITH_MOVIE_ID=420;
    */


    public static UriMatcher buildUriMatcher() {
        // I know what you're thinking.  Why create a UriMatcher when you can use regular
        // expressions instead?  Because you're not crazy, that's why.

        // All paths added to the UriMatcher have a corresponding code to return when a match is
        // found.  The code passed into the constructor represents the code to return for the root
        // URI.  It's common to use NO_MATCH as the code for this case.
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = ScorecardContract.CONTENT_AUTHORITY;

        // For each type of URI you want to add, create a corresponding code.

        //TODO add the matchers
        /*
        matcher.addURI(authority, PopularMoviesContract.PATH_MOVIES + "/#", MOVIE_WITH_ID);
        matcher.addURI(authority, PopularMoviesContract.PATH_MOVIES, MOVIE);

        matcher.addURI(authority, PopularMoviesContract.PATH_FAVORITES + "/#",FAVORITE_WITH_ID);
        matcher.addURI(authority, PopularMoviesContract.PATH_FAVORITES, FAVORITE);

        matcher.addURI(authority, PopularMoviesContract.PATH_VIDEOS + "/*",VIDEO_WITH_KEY);
        matcher.addURI(authority, PopularMoviesContract.PATH_VIDEOS, VIDEO);
        matcher.addURI(authority, PopularMoviesContract.PATH_VIDEOS +"_"+PopularMoviesContract.PATH_MOVIES+"/#",VIDEO_WITH_MOVIE_ID);

        matcher.addURI(authority, PopularMoviesContract.PATH_REVIEWS, REVIEW);
        matcher.addURI(authority, PopularMoviesContract.PATH_REVIEWS +"_"+PopularMoviesContract.PATH_MOVIES+"/#",REVIEW_WITH_MOVIE_ID);
        matcher.addURI(authority, PopularMoviesContract.PATH_REVIEWS + "/#",REVIEW_WITH_ID);
        */




        return matcher;

    }




    @Override
    public boolean onCreate() {

        mScorecardDbHelper=new ScorecardDbHelper(getContext());
        return true;
    }


    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }



    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        return super.bulkInsert(uri, values);
    }


    //TODO check if it is necessary.
    @Override
    @TargetApi(11)
    public void shutdown() {
        mScorecardDbHelper.close();
        super.shutdown();
    }

}
