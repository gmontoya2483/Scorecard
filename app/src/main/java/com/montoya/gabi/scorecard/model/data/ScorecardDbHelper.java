package com.montoya.gabi.scorecard.model.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.GolfFieldHole;
import com.montoya.gabi.scorecard.model.Hole;

import static com.montoya.gabi.scorecard.model.GolfField.NOT_SAVED_GOLF_FIELD_ID;
import static com.montoya.gabi.scorecard.model.data.ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME;

/**
 * Created by montoya on 10.04.2017.
 */

public class ScorecardDbHelper extends SQLiteOpenHelper{

    public static final String LOG_TAG=ScorecardDbHelper.class.getSimpleName();

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME="scorecard.db";

    private Context mContext;


    public ScorecardDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        final String SQL_CREATE_GOLF_FILED_TABLE=
                "CREATE TABLE "+ ScorecardContract.GolfFieldEntry.TABLE_NAME +
                        " ("+
                        ScorecardContract.GolfFieldEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                        COLUMN_GOLF_FIELD_NAME+" TEXT UNIQUE NOT NULL, "+
                        ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE + " INTEGER NOT NULL, "+
                        ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_ACTIVE + " INTEGER NOT NULL "+
                        ") ";


        final String SQL_CREATE_GOLF_FILED_HOLE_TABLE=
                "CREATE TABLE "+ ScorecardContract.GolfFieldHoleEntry.TABLE_NAME +
                        " ("+
                        ScorecardContract.GolfFieldHoleEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                        ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_NUMBER +" INTEGER NOT NULL, "+
                        ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_LENGTH +" INTEGER NOT NULL, "+
                        ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_PAR +" INTEGER NOT NULL, "+
                        ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_GF_ID +" INTEGER NOT NULL, "+
                        "FOREIGN KEY("+ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_GF_ID+") REFERENCES "+ScorecardContract.GolfFieldEntry.TABLE_NAME+"("+ScorecardContract.GolfFieldEntry._ID+")"+
                        ") ";



        db.execSQL(SQL_CREATE_GOLF_FILED_TABLE);
        db.execSQL(SQL_CREATE_GOLF_FILED_HOLE_TABLE);


       // GeneratePreLoadedGolfFields();
        //db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(LOG_TAG, "Upgrading database from version "+ oldVersion + " to "+newVersion+". OLD DATA WILL BE DESTROYED");


        //DROP TABLES
        db.execSQL("DROP TABLE IF EXISTS " + ScorecardContract.GolfFieldHoleEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ScorecardContract.GolfFieldEntry.TABLE_NAME);


        //RESET TABLES COUNTERS
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '"+ScorecardContract.GolfFieldHoleEntry.TABLE_NAME+"'");
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '"+ScorecardContract.GolfFieldEntry.TABLE_NAME+"'");


        onCreate(db);

//        db.close();

    }



}
