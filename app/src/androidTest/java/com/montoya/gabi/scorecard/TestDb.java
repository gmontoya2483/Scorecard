package com.montoya.gabi.scorecard;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardDbHelper;

import java.util.HashSet;

/**
 * Created by Gabriel on 11/04/2017.
 */

public class TestDb extends AndroidTestCase {

    private TestUtils mTestUtils=new TestUtils();




    @Override
    protected void setUp() throws Exception {
        mTestUtils.deleteTheDatabase(mContext);

    }



    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    public void testCreateDB(){


        mTestUtils.deleteTheDatabase(mContext);


        // Add the table names within the HashSet
        final HashSet<String> tablenameHasSet= new HashSet<String>();
        tablenameHasSet.add(ScorecardContract.GolfFieldEntry.TABLE_NAME);
        tablenameHasSet.add(ScorecardContract.GolfFieldHoleEntry.TABLE_NAME);



        //Check if the database is created and Opened correctly
        mContext.deleteDatabase(ScorecardDbHelper.DATABASE_NAME);
        SQLiteDatabase db=new ScorecardDbHelper(mContext).getWritableDatabase();
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





    public void testTableGolfFieldStructure(){


        final HashSet<String> GFColumnHashSet=new HashSet<String>();
        GFColumnHashSet.add(ScorecardContract.GolfFieldEntry._ID);
        GFColumnHashSet.add(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME);
        GFColumnHashSet.add(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE);


        SQLiteDatabase db=new ScorecardDbHelper(mContext).getReadableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());

        Cursor cursor=db.rawQuery("PRAGMA table_info("+ ScorecardContract.GolfFieldEntry.TABLE_NAME+")",null);
        assertTrue("Error: This means that we were unable to query the database for table information.",
                cursor.moveToFirst());

        int columnNameIndex= cursor.getColumnIndex("name");

        do {
            String columnName = cursor.getString(columnNameIndex);
            GFColumnHashSet.remove(columnName);
        } while(cursor.moveToNext());

        assertTrue("Error: The table "+ScorecardContract.GolfFieldEntry.TABLE_NAME +" doesn't contain all of the required  columns",GFColumnHashSet.isEmpty());

        cursor.close();
        db.close();

    }



    public void testTableGolfFieldHoleStructure(){


        final HashSet<String> GFHColumnHashSet=new HashSet<String>();
        GFHColumnHashSet.add(ScorecardContract.GolfFieldHoleEntry._ID);
        GFHColumnHashSet.add(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_GF_ID);
        GFHColumnHashSet.add(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_LENGTH);
        GFHColumnHashSet.add(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_PAR);



        SQLiteDatabase db=new ScorecardDbHelper(mContext).getReadableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());

        Cursor cursor=db.rawQuery("PRAGMA table_info("+ ScorecardContract.GolfFieldHoleEntry.TABLE_NAME+")",null);
        assertTrue("Error: This means that we were unable to query the database for table information.",
                cursor.moveToFirst());

        int columnNameIndex= cursor.getColumnIndex("name");

        do {
            String columnName = cursor.getString(columnNameIndex);
            GFHColumnHashSet.remove(columnName);
        } while(cursor.moveToNext());

        assertTrue("Error: The table "+ScorecardContract.GolfFieldHoleEntry.TABLE_NAME +" doesn't contain all of the required  columns",GFHColumnHashSet.isEmpty());

        cursor.close();
        db.close();

    }




    public void testInsertGolfFieldandHole(){

        long GFRowId;



        GolfField golfField =new GolfField("Fake name",1);

        SQLiteDatabase db=new ScorecardDbHelper(this.mContext).getWritableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());

        GFRowId=db.insert(ScorecardContract.GolfFieldEntry.TABLE_NAME,null,golfField.getGolfFieldValues());

        //Verify that the Inserted movie matches with the expected id
        assertTrue("Error: Expected Movie ID doesn´t match: ", GFRowId>0);



        Cursor cursor=db.rawQuery("SELECT * FROM "+ScorecardContract.GolfFieldEntry.TABLE_NAME+"" +
                        " WHERE "+ ScorecardContract.GolfFieldEntry._ID +"=?"
                , new String []{Long.toString(GFRowId)});


        // Verify if the query got records
        assertTrue( "Error: No Records returned from location query", cursor.moveToFirst() );


        // Verify each field
        int indexId=cursor.getColumnIndex(ScorecardContract.GolfFieldEntry._ID);
        int indexName=cursor.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME);
        int indexFavorite=cursor.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE);


        assertEquals("Error: Golf Field ID doesn´t Match", GFRowId,cursor.getLong(indexId));
        assertEquals("Error: Golf Field Name doesn´t Match",golfField.getName(),cursor.getString(indexName));
        assertEquals("Error: Golf Field favorite doesn´t Match",golfField.getFavorite(),cursor.getInt(indexFavorite));



        // Move the cursor to demonstrate that there is only one record in the database
        assertFalse( "Error: More than one record returned from location query",cursor.moveToNext() );


        //Verify that the inserted record is deleted correctly
        int qtyOfDeletedRecords=db.delete(ScorecardContract.GolfFieldEntry.TABLE_NAME,ScorecardContract.GolfFieldEntry._ID +"=?",new String []{Long.toString(GFRowId)});
        assertEquals("Error: record was not deleted correctly",1,qtyOfDeletedRecords);

        cursor=db.rawQuery("SELECT * FROM "+ScorecardContract.GolfFieldEntry.TABLE_NAME+"" +
                        " WHERE "+ ScorecardContract.GolfFieldEntry._ID +"=?"
                , new String []{Long.toString(GFRowId)});

        // Verify if the query got records
        assertFalse( "Error: The fake record was not deleted", cursor.moveToFirst() );


        cursor.close();
        db.close();



    }



}
