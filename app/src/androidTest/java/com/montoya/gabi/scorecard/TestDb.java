package com.montoya.gabi.scorecard;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.runner.AndroidJUnit4;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardDbHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by montoya on 11.04.2017.
 */



@RunWith(AndroidJUnit4.class)
public class TestDb {

    public static final String LOG_TAG = TestDb.class.getSimpleName();
    MainActivity mMainActivity;
    Context mContext;


    @Before
    public void setup(){




    }





    @Test
    public void CreateDB(){


        MainActivity mainActivity=new MainActivity();
        mContext=mainActivity.getApplicationContext();

        deleteTheDatabase(mContext);


        // Add the table names within the HashSet
        final HashSet<String> tablenameHasSet= new HashSet<String>();
        tablenameHasSet.add(ScorecardContract.GolfFieldEntry.TABLE_NAME);



        //Check if the database is created and Opened correctly
        mContext.deleteDatabase(ScorecardDbHelper.DATABASE_NAME);
        SQLiteDatabase db=new ScorecardDbHelper(this.mContext).getWritableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());


        //have we created the tables we want?
        Cursor c= db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'",null);
        assertTrue("Error: Database is not created correctly - No tables created",c.moveToFirst());



        // verify that the tables have been created
        // we remove from the hash table all the records in the cursos which has all the table names, if at the end the hashtable is not empty that means that not all tables were created.
        do {
            tablenameHasSet.remove(c.getString(0));
        }while (c.moveToNext());

        assertTrue("Error: Database is not created correctly - Some tables were created wrongly",tablenameHasSet.isEmpty());


        c.close();
        db.close();

    }




    @Test
    public void tableGolfFieldStructure(){


        MainActivity mainActivity=new MainActivity();
        mContext=mainActivity.getApplicationContext();

        final HashSet<String> moviesColumnHashSet=new HashSet<String>();
        moviesColumnHashSet.add(ScorecardContract.GolfFieldEntry._ID);
        moviesColumnHashSet.add(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME);
        moviesColumnHashSet.add(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE);


        SQLiteDatabase db=new ScorecardDbHelper(this.mContext).getReadableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());

        Cursor cursor=db.rawQuery("PRAGMA table_info("+ ScorecardContract.GolfFieldEntry.TABLE_NAME+")",null);
        assertTrue("Error: This means that we were unable to query the database for table information.",
                cursor.moveToFirst());

        int columnNameIndex= cursor.getColumnIndex("name");

        do {
            String columnName = cursor.getString(columnNameIndex);
            moviesColumnHashSet.remove(columnName);
        } while(cursor.moveToNext());

        assertTrue("Error: The table "+ScorecardContract.GolfFieldEntry.TABLE_NAME +" doesn't contain all of the required  columns",moviesColumnHashSet.isEmpty());

        cursor.close();
        db.close();

    }






    @After
    public void tearDown(){

    }


    // Since we want each test to start with a clean slate
    void deleteTheDatabase(Context context) {

        context.deleteDatabase(ScorecardDbHelper.DATABASE_NAME);
    }








}
