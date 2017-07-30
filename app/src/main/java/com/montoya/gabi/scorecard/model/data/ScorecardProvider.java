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

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.Scorecard;

/**
 * Created by montoya on 10.04.2017.
 */

public class ScorecardProvider extends ContentProvider{


    private static final String LOG_TAG=ScorecardProvider.class.getSimpleName();
    private static final UriMatcher mUriMatcher=buildUriMatcher();
    private ScorecardDbHelper mScorecardDbHelper;



    //Codes for the UriMatcher
    public static final int GOLF_FIELD=100;
    public static final int GOLF_FIELD_WITH_ID=110;
    public static final int GOLF_FIELD_ACTIVE=120;
    public static final int GOLF_FIELD_FAVORITE=130;//200

    public static final int GOLF_FIELD_HOLE=300;
    public static final int GOLF_FIELD_HOLE_WITH_ID=310;
    public static final int GOLF_FIELD_HOLE_WITH_GF=320;//400

    public static final int SCORECARD=400; //List all the scorecards
    public static final int SCORECARD_WITH_ID=410; //Retrieve the scorecard by ID
    public static final int SCORECARD_WITH_GF_ID=420; //Retrieve all the scorecards for a specific GF ID


    public static final int SCORECARD_BEST_GROSS_DIF=500;  //Retrieve the best GROSS Dif Score
    public static final int SCORECARD_BEST_GROSS_DIF_WITH_GF_ID=510; //Retrieve the best GROSS Dif Score for a particular golf field
    public static final int SCORECARD_BEST_NET_DIF=520;  //Retrieve the best NET Dif Score
    public static final int SCORECARD_BEST_NET_DIF_WITH_GF_ID=530; //Retrieve the best NET Dif Score for a particular Golf Field

    public static final int SCORECARD_HOLE=600;
    public static final int SCORECARD_HOLE_WITH_ID=610;
    public static final int SCORECARD_HOLE_WITH_GF=620;




    public static UriMatcher buildUriMatcher() {

        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = ScorecardContract.CONTENT_AUTHORITY;

        // For each type of URI you want to add, create a corresponding code.
        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD, GOLF_FIELD);
        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD_ACTIVE, GOLF_FIELD_ACTIVE);
        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD + "/#", GOLF_FIELD_WITH_ID);
        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD_FAVORITE, GOLF_FIELD_FAVORITE);

        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD_HOLE, GOLF_FIELD_HOLE);
        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD_HOLE + "/#", GOLF_FIELD_HOLE_WITH_ID);
        matcher.addURI(authority, ScorecardContract.PATH_GOLF_FIELD_HOLE_FIELD + "/#", GOLF_FIELD_HOLE_WITH_GF);

        matcher.addURI(authority, ScorecardContract.PATH_SCORECARD, SCORECARD);
        matcher.addURI(authority, ScorecardContract.PATH_SCORECARD+"/#", SCORECARD_WITH_ID);
        matcher.addURI(authority, ScorecardContract.PATH_SCORECARD_GOLF_FIELD+"/#", SCORECARD_WITH_GF_ID);

        matcher.addURI(authority, ScorecardContract.PATH_SCORECARD_BEST_GROSS_DIF, SCORECARD_BEST_GROSS_DIF);
        matcher.addURI(authority, ScorecardContract.PATH_SCORECARD_BEST_GROSS_DIF+"/#", SCORECARD_BEST_GROSS_DIF_WITH_GF_ID);
        matcher.addURI(authority, ScorecardContract.PATH_SCORECARD_BEST_NET_DIF, SCORECARD_BEST_NET_DIF);
        matcher.addURI(authority, ScorecardContract.PATH_SCORECARD_BEST_NET_DIF+"/#", SCORECARD_BEST_NET_DIF_WITH_GF_ID);

        matcher.addURI(authority, ScorecardContract.PATH_SCORECARD_HOLE, SCORECARD_HOLE);
        matcher.addURI(authority, ScorecardContract.PATH_SCORECARD_HOLE + "/#", SCORECARD_HOLE_WITH_ID);
        matcher.addURI(authority, ScorecardContract.PATH_SCORECARD_HOLE_FIELD + "/#", GOLF_FIELD_HOLE_WITH_GF);

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

            case GOLF_FIELD_ACTIVE:
                return ScorecardContract.GolfFieldEntry.CONTENT_DIR_TYPE_ACTIVE;

            case GOLF_FIELD_FAVORITE:
                return ScorecardContract.GolfFieldEntry.CONTENT_DIR_TYPE_FAVORITE;

            case GOLF_FIELD_HOLE:
                return ScorecardContract.GolfFieldHoleEntry.CONTENT_DIR_TYPE;

            case GOLF_FIELD_HOLE_WITH_ID:
                return ScorecardContract.GolfFieldHoleEntry.CONTENT_ITEM_TYPE;

            case GOLF_FIELD_HOLE_WITH_GF:
                return ScorecardContract.GolfFieldHoleEntry.CONTENT_DIR_TYPE_FIELD;

            case SCORECARD:
                return ScorecardContract.ScorecardEntry.CONTENT_DIR_TYPE;

            case SCORECARD_WITH_ID:
                return ScorecardContract.ScorecardEntry.CONTENT_ITEM_TYPE;

            case SCORECARD_WITH_GF_ID:
                return ScorecardContract.ScorecardEntry.CONTENT_DIR_TYPE_GOLF_FIELD;

            case SCORECARD_BEST_GROSS_DIF:
                return ScorecardContract.ScorecardEntry.CONTENT_ITEM_TYPE_BEST_GROSS_DIF;

            case SCORECARD_BEST_GROSS_DIF_WITH_GF_ID:
                return ScorecardContract.ScorecardEntry.CONTENT_ITEM_TYPE_BEST_GROSS_DIF_GOLF_FIELD;

            case SCORECARD_BEST_NET_DIF:
                return ScorecardContract.ScorecardEntry.CONTENT_ITEM_TYPE_BEST_NET_DIF;

            case SCORECARD_BEST_NET_DIF_WITH_GF_ID:
                return ScorecardContract.ScorecardEntry.CONTENT_ITEM_TYPE_BEST_NET_DIF_GOLF_FIELD;

            case SCORECARD_HOLE:
                return ScorecardContract.ScorecardHoleEntry.CONTENT_DIR_TYPE;

            case SCORECARD_HOLE_WITH_ID:
                return ScorecardContract.ScorecardHoleEntry.CONTENT_ITEM_TYPE;

            case SCORECARD_HOLE_WITH_GF:
                return ScorecardContract.ScorecardHoleEntry.CONTENT_DIR_TYPE_FIELD;

            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.provider_error_unknow_uri) + uri);
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

            case GOLF_FIELD_ACTIVE: {
                selection = ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_ACTIVE + "=?";
                String args[] = {String.valueOf(ScorecardContract.ScorecardBoolean.TRUE.getValue())};

                retCursor = mScorecardDbHelper.getReadableDatabase().query(
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



            case GOLF_FIELD_FAVORITE:
            {
                selection= ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE+"=?" +
                        " AND "+ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_ACTIVE+"=?";
                String args[]={String.valueOf(ScorecardContract.ScorecardBoolean.TRUE.getValue()),String.valueOf(ScorecardContract.ScorecardBoolean.TRUE.getValue())};

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

            /*
            Golf field holes section
            */

            case GOLF_FIELD_HOLE_WITH_ID:
            {
                String GFH_id= String.valueOf(ContentUris.parseId(uri));
                retCursor=queryGolfFieldHoleById(GFH_id);
                break;
            }

            case GOLF_FIELD_HOLE_WITH_GF:
            {
                String GFH_GF_id= String.valueOf(ContentUris.parseId(uri));
                retCursor=queryGolfFieldHoleByGolfFieldId(GFH_GF_id);
                break;
            }
            /*
            Scorecard Section
             */

            case SCORECARD:
            {
                retCursor=mScorecardDbHelper.getReadableDatabase().query(
                        ScorecardContract.ScorecardEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );

                break;
            }

            case SCORECARD_WITH_ID:
            {
                String Scorecard_id= String.valueOf(ContentUris.parseId(uri));
                retCursor=queryScorecardById(Scorecard_id);
                break;
            }

            case SCORECARD_WITH_GF_ID:
            {
                String Scorecard_id= String.valueOf(ContentUris.parseId(uri));
                retCursor=queryScorecardByGolfFieldId(Scorecard_id);
                break;

            }

            case SCORECARD_BEST_GROSS_DIF:
            {
                retCursor=queryScorecardBestGrossDif();
                break;
            }
            case SCORECARD_BEST_GROSS_DIF_WITH_GF_ID:
            {
                String Scorecard_id= String.valueOf(ContentUris.parseId(uri));
                retCursor=queryScorecardBestGrossDifByGolfFieldId(Scorecard_id);
                break;
            }
            case SCORECARD_BEST_NET_DIF:
            {
                retCursor=queryScorecardBestNetDif();
                break;
            }
            case SCORECARD_BEST_NET_DIF_WITH_GF_ID:
            {
                String Scorecard_id= String.valueOf(ContentUris.parseId(uri));
                retCursor=queryScorecardBestNetDifByGolfFieldId(Scorecard_id);
                break;
            }

            /*
            Default section
            */
            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.provider_error_unknow_uri) + uri);

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
            case GOLF_FIELD_HOLE:
                insertedUri=insertGolfFieldHole(values);
                break;
            case SCORECARD:
                insertedUri=insertScorecard(values);
                break;
            case SCORECARD_HOLE:
                insertedUri=insertScorecardHole(values);




            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.provider_error_unknow_uri)+uri);

        }

        //Notify changes to the registered observers !!
        if (insertedUri!=null){
            getContext().getContentResolver().notifyChange(uri, null);
        }


       return insertedUri;
    }




    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {

        final SQLiteDatabase db=mScorecardDbHelper.getWritableDatabase();
        final int match=mUriMatcher.match(uri);
        int rowsDeleted=0;

        switch (match){

            case GOLF_FIELD_WITH_ID:
                String GF_id= String.valueOf(ContentUris.parseId(uri));
                rowsDeleted=deleteGolfField(GF_id);
                break;


            case GOLF_FIELD_HOLE_WITH_GF:
                String GFH_GF_id= String.valueOf(ContentUris.parseId(uri));
                rowsDeleted=deleteGolfFieldHoles(GFH_GF_id);
                break;




            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.provider_error_unknow_uri) + uri);

        }

        if (rowsDeleted>0){
            getContext().getContentResolver().notifyChange(uri, null);

        }
        //getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }


    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int rowsUpdated= 0;
        final int match=mUriMatcher.match(uri);
        switch (match){
            case GOLF_FIELD:
                rowsUpdated=mScorecardDbHelper.getWritableDatabase().update(
                        ScorecardContract.GolfFieldEntry.TABLE_NAME,
                        values,
                        selection,
                        selectionArgs);

                break;

            case GOLF_FIELD_HOLE:
                rowsUpdated=mScorecardDbHelper.getWritableDatabase().update(
                        ScorecardContract.GolfFieldHoleEntry.TABLE_NAME,
                        values,
                        selection,
                        selectionArgs);

                break;

            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.provider_error_unknow_uri) + uri);



        }

        if (rowsUpdated>0){
            getContext().getContentResolver().notifyChange(uri, null);

        }


        return rowsUpdated;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        final int match=mUriMatcher.match(uri);
        int rowsInserted = 0;

        switch (match){
            case GOLF_FIELD_HOLE:
                rowsInserted=bulkInsertGolfFieldHoles(values);
                break;
            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.provider_error_unknow_uri) + uri);
        }


        getContext().getContentResolver().notifyChange(uri, null);
        return rowsInserted;

    }



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

        SQLiteDatabase db = mScorecardDbHelper.getWritableDatabase();
        if (db.isOpen()){
            insertedGolfFieldId=db.insert(ScorecardContract.GolfFieldEntry.TABLE_NAME,null,values);
            if(insertedGolfFieldId!=-1){

                insertedGolfFieldUri=ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(insertedGolfFieldId);


            }else{
                insertedGolfFieldUri=null;
                Log.e(LOG_TAG,getContext().getString(R.string.provider_golf_field_not_inserted));
            }


        }else{
            insertedGolfFieldUri=null;
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }


        db.close();

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
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }
        return cursor;
    }



    private Cursor queryGolfFieldHoleById(String id){
        Cursor cursor;

        SQLiteDatabase db=mScorecardDbHelper.getReadableDatabase();
        if (db.isOpen()){

            String SQLStatment="SELECT * from "+ScorecardContract.GolfFieldHoleEntry.TABLE_NAME+
                    " WHERE "+ScorecardContract.GolfFieldHoleEntry._ID + "=?";

            cursor=db.rawQuery(SQLStatment,new String[]{id});

        }else{
            cursor=null;
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }
        return cursor;

    }


    private Cursor queryGolfFieldHoleByGolfFieldId (String id){
        Cursor cursor;

        SQLiteDatabase db=mScorecardDbHelper.getReadableDatabase();
        if (db.isOpen()){

            String SQLStatment="SELECT * from "+ScorecardContract.GolfFieldHoleEntry.TABLE_NAME+" WHERE "+
                    ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_GF_ID+"=?";
            cursor=db.rawQuery(SQLStatment,new String[]{id});

        }else{
            cursor=null;
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }
        return cursor;

    }




    //Helper Method to insert a new Golf Field in the database
    private Uri insertGolfFieldHole(ContentValues values) {
        Uri insertedGolfFieldHoleUri=null;
        Long insertedGolfFieldHoleId;

        final SQLiteDatabase db = mScorecardDbHelper.getWritableDatabase();
        if (db.isOpen()){
            insertedGolfFieldHoleId=db.insert(ScorecardContract.GolfFieldHoleEntry.TABLE_NAME,null,values);
            if(insertedGolfFieldHoleId!=-1){

                insertedGolfFieldHoleUri=ScorecardContract.GolfFieldHoleEntry.buildGolfFieldHoleByIdUri(insertedGolfFieldHoleId);

            }else{
                insertedGolfFieldHoleUri=null;
                Log.e(LOG_TAG,getContext().getString(R.string.provider_golf_field_hole_not_inserted));
            }


        }else{
            insertedGolfFieldHoleUri=null;
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }


        return insertedGolfFieldHoleUri;
    }


    //Helper method to bulkinsert the Golf field Holes Records
    private int bulkInsertGolfFieldHoles(ContentValues[] values){

        int rowsInserted = 0;
        final SQLiteDatabase db = mScorecardDbHelper.getWritableDatabase();
        db.beginTransaction();
        try{
            for (ContentValues value : values) {

                long _id=db.insert(ScorecardContract.GolfFieldHoleEntry.TABLE_NAME,null,value);
                if (_id!=-1){
                    rowsInserted++;
                }
            }
            db.setTransactionSuccessful();

        }finally {
            db.endTransaction();
        }

        return rowsInserted;

    }


    //Delete GOlf Fields
    private int deleteGolfField(String id){
        int deletedRecords=-1;

        final SQLiteDatabase db = mScorecardDbHelper.getWritableDatabase();
        if (db.isOpen()){

            deletedRecords=db.delete(ScorecardContract.GolfFieldEntry.TABLE_NAME, ScorecardContract.GolfFieldEntry._ID+"=?",new String[]{id});


            if(deletedRecords!=1){

                Log.e(LOG_TAG,getContext().getString(R.string.provider_log_golf_field_delete_problem));


            }
        }else{
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }



        return  deletedRecords;

    }



    //Delete GOlf Fields
    private int deleteGolfFieldHoles(String id){
        int deletedRecords=-1;

        final SQLiteDatabase db = mScorecardDbHelper.getWritableDatabase();
        if (db.isOpen()){

            deletedRecords=db.delete(ScorecardContract.GolfFieldHoleEntry.TABLE_NAME, ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_GF_ID+"=?",new String[]{id});


            if(deletedRecords!=1){

                Log.e(LOG_TAG,getContext().getString(R.string.provider_log_golf_field_hole_delete_problem));


            }
        }else{
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }



        return  deletedRecords;

    }



    // Helper method to insert a new Scorecard
    private Uri insertScorecard(ContentValues values) {

        Uri insertedScorecardUri=null;
        Long insertedScorecardId;

        SQLiteDatabase db = mScorecardDbHelper.getWritableDatabase();
        if (db.isOpen()){
            insertedScorecardId=db.insert(ScorecardContract.ScorecardEntry.TABLE_NAME,null,values);
            if(insertedScorecardId!=-1){

                insertedScorecardUri=ScorecardContract.ScorecardEntry.buildScoreCardByIdUri(insertedScorecardId);


            }else{
                insertedScorecardUri=null;
                Log.e(LOG_TAG,getContext().getString(R.string.provider_log_scorecard_not_inserted));
            }


        }else{
            insertedScorecardUri=null;
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }


        db.close();

        return insertedScorecardUri;
    }


   // Helper method to retrieve a Scorecard by ID
    private Cursor queryScorecardById(String id){

        Cursor cursor;

        SQLiteDatabase db=mScorecardDbHelper.getReadableDatabase();
        if (db.isOpen()){

            String SQLStatment="SELECT * from "+ScorecardContract.ScorecardEntry.TABLE_NAME+" WHERE "+ScorecardContract.ScorecardEntry._ID+"="+id;

            cursor=db.rawQuery(SQLStatment,null);

        }else{
            cursor=null;
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }
        return cursor;
    }



    // Helper method to retrieve the Scorecards by GF
    private Cursor queryScorecardByGolfFieldId(String id){

        Cursor cursor;

        SQLiteDatabase db=mScorecardDbHelper.getReadableDatabase();
        if (db.isOpen()){

            String SQLStatment="SELECT * from "+ScorecardContract.ScorecardEntry.TABLE_NAME+" WHERE "+ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_ID+"="+id;

            cursor=db.rawQuery(SQLStatment,null);

        }else{
            cursor=null;
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }
        return cursor;
    }


    private Cursor queryScorecardBestGrossDif(){

        Cursor cursor;

        SQLiteDatabase db=mScorecardDbHelper.getReadableDatabase();
        if (db.isOpen()){

            String SQLStatment="SELECT MIN ("+ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_DIF+") AS "+ScorecardContract.ScorecardEntry.ALIAS_SCORECARD_BEST_GROSS_DIF+" from "+ScorecardContract.ScorecardEntry.TABLE_NAME;
            cursor=db.rawQuery(SQLStatment,null);

        }else{
            cursor=null;
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }
        return cursor;

    }

    private Cursor queryScorecardBestGrossDifByGolfFieldId(String id){

        Cursor cursor;

        SQLiteDatabase db=mScorecardDbHelper.getReadableDatabase();
        if (db.isOpen()){

            String SQLStatment="SELECT MIN ("+ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_DIF+") AS "+ScorecardContract.ScorecardEntry.ALIAS_SCORECARD_BEST_GROSS_DIF
                    +" from "+ScorecardContract.ScorecardEntry.TABLE_NAME+
                    " WHERE "+ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_ID+"="+id;

            cursor=db.rawQuery(SQLStatment,null);

        }else{
            cursor=null;
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }
        return cursor;

    }



    private Cursor queryScorecardBestNetDif(){

        Cursor cursor;

        SQLiteDatabase db=mScorecardDbHelper.getReadableDatabase();
        if (db.isOpen()){

            String SQLStatment="SELECT MIN ("+ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_DIF+") AS "+ScorecardContract.ScorecardEntry.ALIAS_SCORECARD_BEST_NET_DIF+" from "+ScorecardContract.ScorecardEntry.TABLE_NAME;
            cursor=db.rawQuery(SQLStatment,null);

        }else{
            cursor=null;
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }
        return cursor;

    }



    private Cursor queryScorecardBestNetDifByGolfFieldId(String id){

        Cursor cursor;

        SQLiteDatabase db=mScorecardDbHelper.getReadableDatabase();
        if (db.isOpen()){

            String SQLStatment="SELECT MIN ("+ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_DIF+") AS "+ScorecardContract.ScorecardEntry.ALIAS_SCORECARD_BEST_NET_DIF
                    +" from "+ScorecardContract.ScorecardEntry.TABLE_NAME+
                    " WHERE "+ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_ID+"="+id;

            cursor=db.rawQuery(SQLStatment,null);

        }else{
            cursor=null;
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }
        return cursor;

    }


    //Helper Method to insert a new Scorecard hole in the database
    private Uri insertScorecardHole(ContentValues values) {
        Uri insertedScorecardHoleUri=null;
        Long insertedScorecardHoleId;

        final SQLiteDatabase db = mScorecardDbHelper.getWritableDatabase();
        if (db.isOpen()){
            insertedScorecardHoleId=db.insert(ScorecardContract.ScorecardHoleEntry.TABLE_NAME,null,values);
            if(insertedScorecardHoleId!=-1){

                insertedScorecardHoleUri=ScorecardContract.GolfFieldHoleEntry.buildGolfFieldHoleByIdUri(insertedScorecardHoleId);

            }else{
                insertedScorecardHoleUri=null;
                Log.e(LOG_TAG,getContext().getString(R.string.provider_scorecard_hole_not_inserted));
            }


        }else{
            insertedScorecardHoleUri=null;
            Log.e(LOG_TAG,getContext().getString(R.string.provider_log_database_not_opnened));
        }


        return insertedScorecardHoleUri;
    }



}
