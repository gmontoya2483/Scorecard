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
import static com.montoya.gabi.scorecard.model.data.ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_NAME;

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



        final String SQL_CREATE_SCORECARD_TABLE=
                "CREATE TABLE "+ ScorecardContract.ScorecardEntry.TABLE_NAME +
                        " ("+
                        ScorecardContract.ScorecardEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_ID+"  INTEGER NOT NULL,"+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_NAME+" TEXT NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_TOTAL_LENGTH+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_TOTAL_PAR+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_OUT_LENGTH+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_OUT_PAR+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_IN_LENGTH+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_IN_PAR+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_HANDICAP+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_DATE+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_OUT_SCORE+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_OUT_DIF+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_IN_SCORE+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_IN_DIF+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_SCORE+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_DIF+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_SCORE+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_DIF+" INTEGER NOT NULL "+
                        ") ";


        final String SQL_CREATE_SCORECARD_HOLE_TABLE=
                "CREATE TABLE "+ ScorecardContract.ScorecardHoleEntry.TABLE_NAME +
                        " ("+
                        ScorecardContract.ScorecardHoleEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                        ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_NUMBER+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_LENGTH+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_PAR+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_SCORE+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_DIF+" INTEGER NOT NULL, "+
                        ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_SC_ID +" INTEGER NOT NULL, "+
                        "FOREIGN KEY("+ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_SC_ID+") REFERENCES "+ScorecardContract.ScorecardEntry.TABLE_NAME+"("+ScorecardContract.ScorecardEntry._ID+")"+
                        ") ";


        db.execSQL(SQL_CREATE_GOLF_FILED_TABLE);
        db.execSQL(SQL_CREATE_GOLF_FILED_HOLE_TABLE);
        db.execSQL(SQL_CREATE_SCORECARD_TABLE);
        db.execSQL(SQL_CREATE_SCORECARD_HOLE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(LOG_TAG, "Upgrading database from version "+ oldVersion + " to "+newVersion+". OLD DATA WILL BE DESTROYED");


        //DROP TABLES
        db.execSQL("DROP TABLE IF EXISTS " + ScorecardContract.GolfFieldHoleEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ScorecardContract.GolfFieldEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ScorecardContract.ScorecardHoleEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ScorecardContract.ScorecardEntry.TABLE_NAME);


        //RESET TABLES COUNTERS
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '"+ScorecardContract.GolfFieldHoleEntry.TABLE_NAME+"'");
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '"+ScorecardContract.GolfFieldEntry.TABLE_NAME+"'");
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '"+ScorecardContract.ScorecardHoleEntry.TABLE_NAME+"'");
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '"+ScorecardContract.ScorecardEntry.TABLE_NAME+"'");

       onCreate(db);

//        db.close();

    }



}
