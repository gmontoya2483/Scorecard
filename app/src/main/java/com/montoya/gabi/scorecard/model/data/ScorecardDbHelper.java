package com.montoya.gabi.scorecard.model.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by montoya on 10.04.2017.
 */

public class ScorecardDbHelper extends SQLiteOpenHelper{

    public static final String LOG_TAG=ScorecardDbHelper.class.getSimpleName();

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME="scorecard.db";


    public ScorecardDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        final String SQL_CREATE_GOLF_FILED_TABLE=
                "CREATE TABLE "+ ScorecardContract.GolfFieldEntry.TABLE_NAME +
                        " ("+
                        ScorecardContract.GolfFieldEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                        ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME+" TEXT UNIQUE NOT NULL, "+
                        ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE + " INTEGER NOT NULL"+
                        ") ";



        db.execSQL(SQL_CREATE_GOLF_FILED_TABLE);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(LOG_TAG, "Upgrading database from version "+ oldVersion + " to "+newVersion+". OLD DATA WILL BE DESTROYED");


        //DROP TABLES
        db.execSQL("DROP TABLE IF EXISTS " + ScorecardContract.GolfFieldEntry.TABLE_NAME);



        //RESET TABLES COUNTERS
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '"+ScorecardContract.GolfFieldEntry.TABLE_NAME+"'");



        onCreate(db);




    }
}
