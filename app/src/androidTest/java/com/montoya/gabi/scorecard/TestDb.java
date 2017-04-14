package com.montoya.gabi.scorecard;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.GolfFieldHole;
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




    public void testInsertGolfField(){

        long GFRowId;
        Cursor cursorGF;

        //Verify the is opened vorrectly
        SQLiteDatabase db=new ScorecardDbHelper(this.mContext).getWritableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());



        /*Golf field test
        *
        * */

        GolfField golfField =new GolfField("Fake name",1);

        GFRowId=db.insert(ScorecardContract.GolfFieldEntry.TABLE_NAME,null,golfField.getGolfFieldValues());

        //Verify that the Inserted GolfField has a correct ID
        assertTrue("Error: Expected Golf Field ID doesn´t match: ", GFRowId>0);



        cursorGF=db.rawQuery("SELECT * FROM "+ScorecardContract.GolfFieldEntry.TABLE_NAME+"" +
                        " WHERE "+ ScorecardContract.GolfFieldEntry._ID +"=?"
                , new String []{Long.toString(GFRowId)});


        // Verify if the query got records
        assertTrue( "Error: No Records returned from location query", cursorGF.moveToFirst() );


        // Verify each field
        int indexGFId=cursorGF.getColumnIndex(ScorecardContract.GolfFieldEntry._ID);
        int indexName=cursorGF.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME);
        int indexFavorite=cursorGF.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE);


        assertEquals("Error: Golf Field ID doesn´t Match", GFRowId,cursorGF.getLong(indexGFId));
        assertEquals("Error: Golf Field Name doesn´t Match",golfField.getName(),cursorGF.getString(indexName));
        assertEquals("Error: Golf Field favorite doesn´t Match",golfField.getFavorite(),cursorGF.getInt(indexFavorite));



        // Move the cursor to demonstrate that there is only one record in the database
        assertFalse( "Error: More than one record returned from location query",cursorGF.moveToNext() );


        //Verify that the inserted record is deleted correctly
        int qtyOfDeletedRecords=db.delete(ScorecardContract.GolfFieldEntry.TABLE_NAME,ScorecardContract.GolfFieldEntry._ID +"=?",new String []{Long.toString(GFRowId)});
        assertEquals("Error: record was not deleted correctly",1,qtyOfDeletedRecords);

        cursorGF=db.rawQuery("SELECT * FROM "+ScorecardContract.GolfFieldEntry.TABLE_NAME+"" +
                        " WHERE "+ ScorecardContract.GolfFieldEntry._ID +"=?"
                , new String []{Long.toString(GFRowId)});

        // Verify if the query got records
        assertFalse( "Error: The fake record was not deleted", cursorGF.moveToFirst() );

        cursorGF.close();
        db.close();



    }



    public void testInsertGolfFieldHole(){

        long GFRowId;
        long GFHRowId;
        Cursor cursorGFH;


        /*Golf field Hole test
        *
        * */

        //Verify the is opened correctly
        SQLiteDatabase db=new ScorecardDbHelper(this.mContext).getWritableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());


        //Insert a Golf field (FK on Golf field hole golf field ID)
        GolfField golfField =new GolfField("Fake name",1);
        GFRowId=db.insert(ScorecardContract.GolfFieldEntry.TABLE_NAME,null,golfField.getGolfFieldValues());
        assertTrue("Error: Expected Golf Field ID doesn´t match: ", GFRowId>0);




        GolfFieldHole golfFieldHole =new GolfFieldHole(GFRowId, GolfFieldHole.HoleNumber.HOLE_3,170, GolfFieldHole.Par.PAR_4);

        //Verify the enums
        assertEquals("Hole 3 value doesnßt match",3, GolfFieldHole.HoleNumber.HOLE_3.getValue());
        assertEquals("Par 4 value doesnßt match",4, GolfFieldHole.Par.PAR_4.getValue());


        GFHRowId=db.insert(ScorecardContract.GolfFieldHoleEntry.TABLE_NAME,null,golfFieldHole.getGolfFieldHoleValues());

        //Verify that the Inserted GolfFieldHole has a correct ID
        assertTrue("Error: Expected GolfField Hole ID doesn´t match: ", GFHRowId>0);


        cursorGFH=db.rawQuery("SELECT * FROM "+ScorecardContract.GolfFieldHoleEntry.TABLE_NAME+"" +
                        " WHERE "+ ScorecardContract.GolfFieldHoleEntry._ID +"=?"
                , new String []{Long.toString(GFHRowId)});


        // Verify if the query got records
        assertTrue( "Error: The fake record was not deleted", cursorGFH.moveToFirst() );


        // Verify each field
        int indexGFHI_ID=cursorGFH.getColumnIndex(ScorecardContract.GolfFieldHoleEntry._ID);
        int indexGFH_GF_ID=cursorGFH.getColumnIndex(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_GF_ID);
        int indexGFH_NUMBER=cursorGFH.getColumnIndex(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_NUMBER);
        int indexGFH_LENGTH=cursorGFH.getColumnIndex(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_LENGTH);
        int indexGFH_PAR=cursorGFH.getColumnIndex(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_PAR);

        assertEquals("Error: Golf Field Hole ID doesn´t Match", GFHRowId,cursorGFH.getLong(indexGFHI_ID));
        assertEquals("Error: Golf Field Hole _ GF ID doesn´t Match", golfFieldHole.getGolfField_id(),cursorGFH.getLong(indexGFH_GF_ID));
        assertEquals("Error: Golf Field Hole Number doesn´t Match", golfFieldHole.getNumber().getValue(),cursorGFH.getInt(indexGFH_NUMBER));
        assertEquals("Error: Golf Field Length doesn´t Match", golfFieldHole.getLength(),cursorGFH.getInt(indexGFH_LENGTH));
        assertEquals("Error: Golf Field Par doesn´t Match", golfFieldHole.getPar().getValue(),cursorGFH.getInt(indexGFH_PAR));


        // Move the cursor to demonstrate that there is only one record in the database
        assertFalse( "Error: More than one record returned from location query",cursorGFH.moveToNext() );




        //Verify that the inserted record is deleted correctly
        int qtyOfGFHDeletedRecords=db.delete(ScorecardContract.GolfFieldHoleEntry.TABLE_NAME,ScorecardContract.GolfFieldHoleEntry._ID +"=?",new String []{Long.toString(GFHRowId)});
        assertEquals("Error: record was not deleted correctly",1,qtyOfGFHDeletedRecords);

        cursorGFH=db.rawQuery("SELECT * FROM "+ScorecardContract.GolfFieldHoleEntry.TABLE_NAME+"" +
                        " WHERE "+ ScorecardContract.GolfFieldHoleEntry._ID +"=?"
                , new String []{Long.toString(GFHRowId)});

        // Verify if the query got records
        assertFalse( "Error: The fake record was not deleted", cursorGFH.moveToFirst() );




        //Verify the FK between GolfField and GolfFieldHole
        int qtyOfGFDeletedRecords=db.delete(ScorecardContract.GolfFieldEntry.TABLE_NAME,ScorecardContract.GolfFieldEntry._ID +"=?",new String []{Long.toString(GFRowId)});
        assertEquals("Error: record was not deleted correctly",1,qtyOfGFDeletedRecords);


        cursorGFH.close();
        db.close();





    }








}
