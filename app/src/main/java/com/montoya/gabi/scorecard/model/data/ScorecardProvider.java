package com.montoya.gabi.scorecard.model.data;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.montoya.gabi.scorecard.model.Scorecard;

/**
 * Created by montoya on 10.04.2017.
 */

public class ScorecardProvider extends ContentProvider{


    private static final String LOG_TAG=ScorecardProvider.class.getSimpleName();
    private static final UriMatcher mUriMatcher=buildUriMatcher();
    private ScorecardDbHelper mScorecardDbHelper;



    //Codes for the UriMatcher
    //TODO Define the codes
    public static final int GOLF_FIELD=100;
    public static final int GOLF_FIELD_WITH_ID=110;
    public static final int GOLF_FIELD_FAVORITE=200;
    public static final int GOLF_FIELD_HOLE=300;
    public static final int GOLF_FIELD_HOLE_WITH_ID=310;
    public static final int GOLF_FIELD_HOLE_WITH_GF=400;





    public static UriMatcher buildUriMatcher() {

        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = ScorecardContract.CONTENT_AUTHORITY;

        // For each type of URI you want to add, create a corresponding code.
        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD, GOLF_FIELD);
        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD + "/#", GOLF_FIELD_WITH_ID);
        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD_FAVORITE, GOLF_FIELD_FAVORITE);

        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD_HOLE, GOLF_FIELD_HOLE);
        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD_HOLE + "/#", GOLF_FIELD_HOLE_WITH_ID);
        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD_HOLE_FIELD + "/#", GOLF_FIELD_HOLE_WITH_GF);



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
        final int match = mUriMatcher.match(uri);

        switch (match) {

            case GOLF_FIELD:
                return ScorecardContract.GolfFieldEntry.CONTENT_DIR_TYPE;

            case GOLF_FIELD_WITH_ID:
                return ScorecardContract.GolfFieldEntry.CONTENT_ITEM_TYPE;

            case GOLF_FIELD_FAVORITE:
                return ScorecardContract.GolfFieldEntry.CONTENT_DIR_TYPE_FAVORITE;

            case GOLF_FIELD_HOLE:
                return ScorecardContract.GolfFieldHoleEntry.CONTENT_DIR_TYPE;

            case GOLF_FIELD_HOLE_WITH_ID:
                return ScorecardContract.GolfFieldHoleEntry.CONTENT_ITEM_TYPE;

            case GOLF_FIELD_HOLE_WITH_GF:
                return ScorecardContract.GolfFieldHoleEntry.CONTENT_DIR_TYPE_FIELD;

            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

    }



    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        Cursor retCursor=null;
        final int match=mUriMatcher.match(uri);

        switch(match){
            case GOLF_FIELD:
            {
                retCursor=mScorecardDbHelper.getReadableDatabase().query(
                        ScorecardContract.GolfFieldEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );

                break;

            }
            case GOLF_FIELD_WITH_ID:
            {
                String GF_id= String.valueOf(ContentUris.parseId(uri));
                retCursor=queryGolfFieldById(GF_id);
                break;

            }
            case GOLF_FIELD_FAVORITE:
            {
                selection= ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE+"=?";
                String args[]={String.valueOf(ScorecardContract.TRUE_VALUE)};

                retCursor=mScorecardDbHelper.getReadableDatabase().query(
                        ScorecardContract.GolfFieldEntry.TABLE_NAME,
                        projection,
                        selection,
                        args,
                        null,
                        null,
                        sortOrder
                );

                break;

            }


            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);

        }
        //Set the notification URI for our Cursor and register a content observer to watch changes to the URI
        retCursor.setNotificationUri(getContext().getContentResolver(),uri);
        return retCursor;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Uri insertedUri=null;
        final int match=mUriMatcher.match(uri);
        switch (match){
            case GOLF_FIELD:
                insertedUri=insertGolfField(values);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: "+uri);

        }

        //Notify changes to the registered observers !!
        if (insertedUri!=null){
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return insertedUri;
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




    //Helper Method to insert a new Golf Field in the database
    private Uri insertGolfField(ContentValues values) {
        Uri insertedGolfFieldUri=null;
        Long insertedGolfFieldId;

        final SQLiteDatabase db = mScorecardDbHelper.getWritableDatabase();
        if (db.isOpen()){
            insertedGolfFieldId=db.insert(ScorecardContract.GolfFieldEntry.TABLE_NAME,null,values);
            if(insertedGolfFieldId!=-1){

                insertedGolfFieldUri=ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(insertedGolfFieldId);


            }else{
                insertedGolfFieldUri=null;
                Log.e(LOG_TAG,"Golf Field could not be inserted");
            }


        }else{
            insertedGolfFieldUri=null;
            Log.e(LOG_TAG,"database could not be opened");
        }


        return insertedGolfFieldUri;
    }


    //Helper Method to get an specific Golf Field by its ID
    private Cursor queryGolfFieldById(String id){

        Cursor cursor;

        SQLiteDatabase db=mScorecardDbHelper.getReadableDatabase();
        if (db.isOpen()){

            String SQLStatment="SELECT * from "+ScorecardContract.GolfFieldEntry.TABLE_NAME+" WHERE _id="+id;

            cursor=db.rawQuery(SQLStatment,null);

        }else{
            cursor=null;
            Log.e(LOG_TAG,"database could not be opened");
        }
        return cursor;
    }




}
