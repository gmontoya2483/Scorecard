package com.montoya.gabi.scorecard;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.GolfFieldHole;
import com.montoya.gabi.scorecard.model.Hole;
import com.montoya.gabi.scorecard.model.Scorecard;
import com.montoya.gabi.scorecard.model.ScorecardHole;
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
        tablenameHasSet.add(ScorecardContract.ScorecardEntry.TABLE_NAME);
        tablenameHasSet.add(ScorecardContract.ScorecardHoleEntry.TABLE_NAME);



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
        GFColumnHashSet.add(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_ACTIVE);


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



    public void testTableScorecardStructure(){


        final HashSet<String> SCColumnHashSet=new HashSet<String>();
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry._ID);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_ID);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_NAME);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_TOTAL_LENGTH);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_TOTAL_PAR);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_OUT_LENGTH);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_OUT_PAR);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_IN_LENGTH);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_IN_PAR);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_DATE);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_HANDICAP);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_OUT_SCORE);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_OUT_DIF);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_IN_SCORE);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_IN_DIF);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_SCORE);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_DIF);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_SCORE);
        SCColumnHashSet.add(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_DIF);


        SQLiteDatabase db=new ScorecardDbHelper(mContext).getReadableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());

        Cursor cursor=db.rawQuery("PRAGMA table_info("+ ScorecardContract.ScorecardEntry.TABLE_NAME+")",null);
        assertTrue("Error: This means that we were unable to query the database for table information.",
                cursor.moveToFirst());

        int columnNameIndex= cursor.getColumnIndex("name");

        do {
            String columnName = cursor.getString(columnNameIndex);
            SCColumnHashSet.remove(columnName);
        } while(cursor.moveToNext());

        assertTrue("Error: The table "+ScorecardContract.ScorecardEntry.TABLE_NAME +" doesn't contain all of the required  columns",SCColumnHashSet.isEmpty());

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


    public void testTableScorecardHoleStructure(){


        final HashSet<String> SCHColumnHashSet=new HashSet<String>();
        SCHColumnHashSet.add(ScorecardContract.ScorecardHoleEntry._ID);
        SCHColumnHashSet.add(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_SC_ID);
        SCHColumnHashSet.add(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_NUMBER);
        SCHColumnHashSet.add(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_LENGTH);
        SCHColumnHashSet.add(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_PAR);
        SCHColumnHashSet.add(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_SCORE);
        SCHColumnHashSet.add(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_DIF);

        SQLiteDatabase db=new ScorecardDbHelper(mContext).getReadableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());

        Cursor cursor=db.rawQuery("PRAGMA table_info("+ ScorecardContract.ScorecardHoleEntry.TABLE_NAME+")",null);
        assertTrue("Error: This means that we were unable to query the database for table information.",
                cursor.moveToFirst());

        int columnNameIndex= cursor.getColumnIndex("name");

        do {
            String columnName = cursor.getString(columnNameIndex);
            SCHColumnHashSet.remove(columnName);
        } while(cursor.moveToNext());

        assertTrue("Error: The table "+ScorecardContract.ScorecardHoleEntry.TABLE_NAME +" doesn't contain all of the required  columns",SCHColumnHashSet.isEmpty());

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

        GolfField golfField =new GolfField("Fake name", ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);

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
        int indexActive=cursorGF.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_ACTIVE);


        assertEquals("Error: Golf Field ID doesn´t Match", GFRowId,cursorGF.getLong(indexGFId));
        assertEquals("Error: Golf Field Name doesn´t Match",golfField.getName(),cursorGF.getString(indexName));
        assertEquals("Error: Golf Field favorite doesn´t Match",golfField.getFavorite().getValue(),cursorGF.getInt(indexFavorite));
        assertEquals("Error: Golf Field favorite doesn´t Match",golfField.getFavorite().getValue(),cursorGF.getInt(indexFavorite));



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

    public void testInsertScoreCard(){

        long SCRowId;
        Cursor cursorSC;

        //Verify the is opened vorrectly
        SQLiteDatabase db=new ScorecardDbHelper(this.mContext).getWritableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());



        /*Score card test
        *
        * */

        Scorecard scorecard =new Scorecard(
                System.currentTimeMillis(), //date
                24,//handicap
                1L,//Golf field ID
                "Golfield fake",// GolfField name
                2356,//Total Length
                70, //Total Par
                1520, //out length
                36, //out par
                1542, //In Length
                34, //In Par
                42, //out score
                11, //out dif
                40, // in score
                9, //in dif
                82, //gross score
                20, // gross dif
                56, //Net score
                -11 //Net dif
                );



        SCRowId=db.insert(ScorecardContract.ScorecardEntry.TABLE_NAME,null,scorecard.getGolfFieldValues());

        //Verify that the Inserted GolfField has a correct ID
        assertTrue("Error: Expected Golf Field ID doesn´t match: ", SCRowId>0);



        cursorSC=db.rawQuery("SELECT * FROM "+ScorecardContract.ScorecardEntry.TABLE_NAME+"" +
                        " WHERE "+ ScorecardContract.ScorecardEntry._ID +"=?"
                , new String []{Long.toString(SCRowId)});


        // Verify if the query got records
        assertTrue( "Error: No Records returned from location query", cursorSC.moveToFirst() );


        // Verify each field
        int indexSCId=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry._ID);
        int indexSCDate=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_DATE);
        int indexSCHandicap=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_HANDICAP);
        int indexSCGFId=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_ID);
        int indexSCGFName=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_NAME);
        int indexSCGFTotalLength=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_TOTAL_LENGTH);
        int indexSCGFTotalPar=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_TOTAL_PAR);
        int indexSCGFOutlLength=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_OUT_LENGTH);
        int indexSCGFOutPar=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_OUT_PAR);
        int indexSCGFInLength=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_IN_LENGTH);
        int indexSCGFInPar=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_IN_PAR);
        int indexSCOutScore=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_OUT_SCORE);
        int indexSCOutDif=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_OUT_DIF);
        int indexSCInScore=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_IN_SCORE);
        int indexSCInDif=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_IN_DIF);
        int indexSCGrossScore=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_SCORE);
        int indexSCGrossDif=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_DIF);
        int indexSCNetScore=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_SCORE);
        int indexSCNetDif=cursorSC.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_DIF);


        assertEquals("Error: Scorecard ID doesn´t Match", SCRowId,cursorSC.getLong(indexSCId));
        assertEquals("Error: Field date doesn´t Match", scorecard.getDate(),cursorSC.getLong(indexSCDate));
        assertEquals("Error: Field handicap doesn´t Match", scorecard.getHandicap(),cursorSC.getInt(indexSCHandicap));
        assertEquals("Error: Golf Field ID doesn´t Match", scorecard.getGolfField_id(),cursorSC.getLong(indexSCGFId));
        assertEquals("Error: Golf Field Name doesn´t Match", scorecard.getGolfFieldName(),cursorSC.getString(indexSCGFName));
        assertEquals("Error: Golf Field total Length doesn´t Match", scorecard.getGolfFieldTotalLength(),cursorSC.getInt(indexSCGFTotalLength));
        assertEquals("Error: Golf Field total Par doesn´t Match", scorecard.getGolfFieldTotalPar(),cursorSC.getInt(indexSCGFTotalPar));
        assertEquals("Error: Golf Field out Length doesn´t Match", scorecard.getGolfFieldOutLength(),cursorSC.getInt(indexSCGFOutlLength));
        assertEquals("Error: Golf Field out Par doesn´t Match", scorecard.getGolfFieldOutPar(),cursorSC.getInt(indexSCGFOutPar));
        assertEquals("Error: Golf Field In Length doesn´t Match", scorecard.getGolfFieldInLength(),cursorSC.getInt(indexSCGFInLength));
        assertEquals("Error: Golf Field In Par doesn´t Match", scorecard.getGolfFieldInPar(),cursorSC.getInt(indexSCGFInPar));
        assertEquals("Error: Out score doesn´t Match", scorecard.getOutScore(),cursorSC.getInt(indexSCOutScore));
        assertEquals("Error: Out dif doesn´t Match", scorecard.getOutDif(),cursorSC.getInt(indexSCOutDif));
        assertEquals("Error: In score doesn´t Match", scorecard.getInScore(),cursorSC.getInt(indexSCInScore));
        assertEquals("Error: In dif doesn´t Match", scorecard.getInDif(),cursorSC.getInt(indexSCInDif));
        assertEquals("Error: Gross score doesn´t Match", scorecard.getGrossScore(),cursorSC.getInt(indexSCGrossScore));
        assertEquals("Error: Gross dif doesn´t Match", scorecard.getGrossDif(),cursorSC.getInt(indexSCGrossDif));
        assertEquals("Error: Net score doesn´t Match", scorecard.getNetScore(),cursorSC.getInt(indexSCNetScore));
        assertEquals("Error: Net dif doesn´t Match", scorecard.getNetDif(),cursorSC.getInt(indexSCNetDif));



        // Move the cursor to demonstrate that there is only one record in the database
        assertFalse( "Error: More than one record returned from location query",cursorSC.moveToNext() );


        //Verify that the inserted record is deleted correctly
        int qtyOfDeletedRecords=db.delete(ScorecardContract.ScorecardEntry.TABLE_NAME,ScorecardContract.ScorecardEntry._ID +"=?",new String []{Long.toString(SCRowId)});
        assertEquals("Error: record was not deleted correctly",1,qtyOfDeletedRecords);

        cursorSC=db.rawQuery("SELECT * FROM "+ScorecardContract.ScorecardEntry.TABLE_NAME+"" +
                        " WHERE "+ ScorecardContract.ScorecardEntry._ID +"=?"
                , new String []{Long.toString(SCRowId)});

        // Verify if the query got records
        assertFalse( "Error: The fake record was not deleted", cursorSC.moveToFirst() );

        cursorSC.close();
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
        GolfField golfField =new GolfField("Fake name", ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
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



    public void testInsertScorecardHole(){

        long SCRowId;
        long SCHRowId;
        Cursor cursorSCH;


        /*Golf field Hole test
        *
        * */

        //Verify the is opened correctly
        SQLiteDatabase db=new ScorecardDbHelper(this.mContext).getWritableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());


        //Insert a Score (FK on Golf field hole golf field ID)
        Scorecard scorecard =new Scorecard(
                System.currentTimeMillis(), //date
                24,//handicap
                1L,//Golf field ID
                "Golfield fake",// GolfField name
                2356,//Total Length
                70, //Total Par
                1520, //out length
                36, //out par
                1542, //In Length
                34, //In Par
                42, //out score
                11, //out dif
                40, // in score
                9, //in dif
                82, //gross score
                20, // gross dif
                56, //Net score
                -11 //Net dif
        );




        SCRowId=db.insert(ScorecardContract.ScorecardEntry.TABLE_NAME,null,scorecard.getGolfFieldValues());
        assertTrue("Error: Expected Scorecard ID doesn´t match: ", SCRowId>0);




        ScorecardHole scorecardHole =new ScorecardHole(SCRowId, Hole.HoleNumber.HOLE_3,170, Hole.Par.PAR_4,5,1);

        //Verify the enums
        assertEquals("Hole 3 value doesnßt match",3, Hole.HoleNumber.HOLE_3.getValue());
        assertEquals("Par 4 value doesnßt match",4, Hole.Par.PAR_4.getValue());


        SCHRowId=db.insert(ScorecardContract.ScorecardHoleEntry.TABLE_NAME,null,scorecardHole.getGolfFieldHoleValues());

        //Verify that the Inserted ScorecardHole has a correct ID
        assertTrue("Error: Expected Scorecard Hole ID doesn´t match: ", SCHRowId>0);


        cursorSCH=db.rawQuery("SELECT * FROM "+ScorecardContract.ScorecardHoleEntry.TABLE_NAME+"" +
                        " WHERE "+ ScorecardContract.ScorecardHoleEntry._ID +"=?"
                , new String []{Long.toString(SCHRowId)});


        // Verify if the query got records
        assertTrue( "Error: The fake record was not inserted", cursorSCH.moveToFirst() );


        // Verify each field
        int indexSCH_ID=cursorSCH.getColumnIndex(ScorecardContract.ScorecardHoleEntry._ID);
        int indexSCH_SC_ID=cursorSCH.getColumnIndex(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_SC_ID);
        int indexSCH_NUMBER=cursorSCH.getColumnIndex(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_NUMBER);
        int indexSCH_LENGTH=cursorSCH.getColumnIndex(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_LENGTH);
        int indexSCH_PAR=cursorSCH.getColumnIndex(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_PAR);
        int indexSCH_SCORE=cursorSCH.getColumnIndex(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_SCORE);
        int indexSCH_DIF=cursorSCH.getColumnIndex(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_DIF);


        assertEquals("Error: Scorecard Hole ID doesn´t Match", SCHRowId,cursorSCH.getLong(indexSCH_ID));
        assertEquals("Error: Scorecard Hole SC ID doesn´t Match", scorecardHole.getScorecard_Id(),cursorSCH.getLong(indexSCH_SC_ID));
        assertEquals("Error: Scorecard Hole Number doesn´t Match", scorecardHole.getNumber().getValue(),cursorSCH.getInt(indexSCH_NUMBER));
        assertEquals("Error: Scorecard Hole Length doesn´t Match", scorecardHole.getLength(),cursorSCH.getInt(indexSCH_LENGTH));
        assertEquals("Error: Scorecard Hole Par doesn´t Match", scorecardHole.getPar().getValue(),cursorSCH.getInt(indexSCH_PAR));
        assertEquals("Error: Scorecard Hole score doesn´t Match", scorecardHole.getScore(),cursorSCH.getInt(indexSCH_SCORE));
        assertEquals("Error: Scorecard Hole Dif doesn´t Match", scorecardHole.getDif(),cursorSCH.getInt(indexSCH_DIF));

        // Move the cursor to demonstrate that there is only one record in the database
        assertFalse( "Error: More than one record returned from location query",cursorSCH.moveToNext() );




        //Verify that the inserted record is deleted correctly
        int qtyOfGFHDeletedRecords=db.delete(ScorecardContract.ScorecardHoleEntry.TABLE_NAME,ScorecardContract.ScorecardHoleEntry._ID +"=?",new String []{Long.toString(SCHRowId)});
        assertEquals("Error: record was not deleted correctly",1,qtyOfGFHDeletedRecords);

        cursorSCH=db.rawQuery("SELECT * FROM "+ScorecardContract.ScorecardHoleEntry.TABLE_NAME+"" +
                        " WHERE "+ ScorecardContract.ScorecardHoleEntry._ID +"=?"
                , new String []{Long.toString(SCHRowId)});

        // Verify if the query got records
        assertFalse( "Error: The fake record was not deleted", cursorSCH.moveToFirst() );




        //Verify the FK between GolfField and GolfFieldHole
        int qtyOfGFDeletedRecords=db.delete(ScorecardContract.ScorecardEntry.TABLE_NAME,ScorecardContract.ScorecardEntry._ID +"=?",new String []{Long.toString(SCRowId)});
        assertEquals("Error: record was not deleted correctly",1,qtyOfGFDeletedRecords);


        cursorSCH.close();
        db.close();


    }













}
