package com.montoya.gabi.scorecard;

import android.database.Cursor;
import android.test.AndroidTestCase;

import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.GolfFieldHole;
import com.montoya.gabi.scorecard.model.Hole;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;

import static com.montoya.gabi.scorecard.model.GolfField.INVALID_GOLF_FIELD_ID;
import static com.montoya.gabi.scorecard.model.GolfField.NOT_SAVED_GOLF_FIELD_ID;

/**
 * Created by montoya on 20.04.2017.
 */

public class TestGolfFielAandHoleClasses extends AndroidTestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        TestUtils.deleteAllRecords(mContext);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        TestUtils.deleteAllRecords(mContext);
    }






    public void testNewGolfField_OK() {

        TestUtils.deleteAllRecords(mContext);



        String gf_name="GolfField Test";
        ScorecardContract.ScorecardBoolean gf_favorite= ScorecardContract.ScorecardBoolean.FALSE;
        ScorecardContract.ScorecardBoolean gf_active= ScorecardContract.ScorecardBoolean.TRUE;

        GolfFieldHole itemHole;


        //Create the golf field Object
        GolfField golfField=new GolfField(gf_name,gf_favorite,gf_active);

        //Verify that the Golf field ID was set to NOT_SAVED at first time
        assertEquals("Golf Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, golfField.get_id());



        /*
        * Add the Holes
         */

        //Hole 1:
        GolfFieldHole hole_1=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3);
        golfField.AddHole(hole_1);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_1);

        assertEquals("HOLE 1: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 1: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 1: Hole number must be equal to HOLE_1", Hole.HoleNumber.HOLE_1, itemHole.getNumber());
        assertEquals("HOLE 1: Length must be equal to 120", 120, itemHole.getLength());
        assertEquals("HOLE 1: Par must be equal to PAR_3", Hole.Par.PAR_3, itemHole.getPar());


        //Hole 2:
        GolfFieldHole hole_2=new GolfFieldHole(235L, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_2);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_2);

        assertEquals("HOLE 2: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 2: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 2: Hole number must be equal to HOLE_2", Hole.HoleNumber.HOLE_2, itemHole.getNumber());
        assertEquals("HOLE 2: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 2: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 3:
        GolfFieldHole hole_3=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_3);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_3);

        assertEquals("HOLE 3: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 3: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 3: Hole number must be equal to HOLE_3", Hole.HoleNumber.HOLE_3, itemHole.getNumber());
        assertEquals("HOLE 3: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 3: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 4:
        GolfFieldHole hole_4=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_4);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_4);

        assertEquals("HOLE 4: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 4: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 4: Hole number must be equal to HOLE_4", Hole.HoleNumber.HOLE_4, itemHole.getNumber());
        assertEquals("HOLE 4: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 4: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 5:
        GolfFieldHole hole_5=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,370, Hole.Par.PAR_5);
        golfField.AddHole(hole_5);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_5);

        assertEquals("HOLE 5: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 5: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 5: Hole number must be equal to HOLE_5", Hole.HoleNumber.HOLE_5, itemHole.getNumber());
        assertEquals("HOLE 5: Length must be equal to 370", 370, itemHole.getLength());
        assertEquals("HOLE 5: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 6:
        GolfFieldHole hole_6=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_6);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_6);

        assertEquals("HOLE 6: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 6: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 6: Hole number must be equal to HOLE_6", Hole.HoleNumber.HOLE_6, itemHole.getNumber());
        assertEquals("HOLE 6: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 6: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 7:
        GolfFieldHole hole_7=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_7);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_7);

        assertEquals("HOLE 7: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 7: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 7: Hole number must be equal to HOLE_7", Hole.HoleNumber.HOLE_7, itemHole.getNumber());
        assertEquals("HOLE 7: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 7: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 8:
        GolfFieldHole hole_8=new GolfFieldHole(235L, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_8);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_8);

        assertEquals("HOLE 8: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 8: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 8: Hole number must be equal to HOLE_8", Hole.HoleNumber.HOLE_8, itemHole.getNumber());
        assertEquals("HOLE 8: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 8: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 9:
        GolfFieldHole hole_9=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_9);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_9);

        assertEquals("HOLE 9: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 9: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 9: Hole number must be equal to HOLE_9", Hole.HoleNumber.HOLE_9, itemHole.getNumber());
        assertEquals("HOLE 9: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 9: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 10:
        GolfFieldHole hole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 11:
        GolfFieldHole hole_11=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_11);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_11);

        assertEquals("HOLE 11: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 11: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 11: Hole number must be equal to HOLE_11", Hole.HoleNumber.HOLE_11, itemHole.getNumber());
        assertEquals("HOLE 11: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 11: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 12:
        GolfFieldHole hole_12=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_12);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_12);

        assertEquals("HOLE 12: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 12: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 12: Hole number must be equal to HOLE_12", Hole.HoleNumber.HOLE_12, itemHole.getNumber());
        assertEquals("HOLE 12: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 12: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 13:
        GolfFieldHole hole_13=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_13);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_13);

        assertEquals("HOLE 13: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 13: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 13: Hole number must be equal to HOLE_13", Hole.HoleNumber.HOLE_13, itemHole.getNumber());
        assertEquals("HOLE 13: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 13: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 14:
        GolfFieldHole hole_14=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_14);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_14);

        assertEquals("HOLE 14: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 14: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 14: Hole number must be equal to HOLE_14", Hole.HoleNumber.HOLE_14, itemHole.getNumber());
        assertEquals("HOLE 14: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 14: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 15:
        GolfFieldHole hole_15=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_15);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_15);

        assertEquals("HOLE 15: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 15: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 15: Hole number must be equal to HOLE_15", Hole.HoleNumber.HOLE_15, itemHole.getNumber());
        assertEquals("HOLE 15: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 15: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 16:
        GolfFieldHole hole_16=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_16);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_16);

        assertEquals("HOLE 16: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 16: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 16: Hole number must be equal to HOLE_16", Hole.HoleNumber.HOLE_16, itemHole.getNumber());
        assertEquals("HOLE 16: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 16: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 17:
        GolfFieldHole hole_17=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_17);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_17);

        assertEquals("HOLE 17: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 17: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 17: Hole number must be equal to HOLE_17", Hole.HoleNumber.HOLE_17, itemHole.getNumber());
        assertEquals("HOLE 17: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 17: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 18:
        GolfFieldHole hole_18=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_18);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_18);

        assertEquals("HOLE 18: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 18: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 18: Hole number must be equal to HOLE_18", Hole.HoleNumber.HOLE_18, itemHole.getNumber());
        assertEquals("HOLE 18: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 18: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Insert the golf Field and its holes into the database
        boolean insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",insertedOK);


        Cursor GFcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",1, GFcursor.getCount());

        TestUtils.VerifyExpectedGolfFieldQueryResult(golfField,GFcursor);


        Cursor GFHcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",18, GFHcursor.getCount());


        TestUtils.deleteAllRecords(mContext);


    }



    public void testNewGolfField_NameNULL() {

        TestUtils.deleteAllRecords(mContext);



        String gf_name=null;
        ScorecardContract.ScorecardBoolean gf_favorite= ScorecardContract.ScorecardBoolean.FALSE;
        ScorecardContract.ScorecardBoolean gf_active= ScorecardContract.ScorecardBoolean.TRUE;

        GolfFieldHole itemHole;


        //Create the golf field Object
        GolfField golfField=new GolfField(gf_name,gf_favorite,gf_active);

        //Verify that the Golf field ID was set to NOT_SAVED at first time
        assertEquals("Golf Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, golfField.get_id());



        /*
        * Add the Holes
         */

        //Hole 1:
        GolfFieldHole hole_1=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3);
        golfField.AddHole(hole_1);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_1);

        assertEquals("HOLE 1: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 1: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 1: Hole number must be equal to HOLE_1", Hole.HoleNumber.HOLE_1, itemHole.getNumber());
        assertEquals("HOLE 1: Length must be equal to 120", 120, itemHole.getLength());
        assertEquals("HOLE 1: Par must be equal to PAR_3", Hole.Par.PAR_3, itemHole.getPar());


        //Hole 2:
        GolfFieldHole hole_2=new GolfFieldHole(235L, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_2);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_2);

        assertEquals("HOLE 2: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 2: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 2: Hole number must be equal to HOLE_2", Hole.HoleNumber.HOLE_2, itemHole.getNumber());
        assertEquals("HOLE 2: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 2: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 3:
        GolfFieldHole hole_3=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_3);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_3);

        assertEquals("HOLE 3: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 3: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 3: Hole number must be equal to HOLE_3", Hole.HoleNumber.HOLE_3, itemHole.getNumber());
        assertEquals("HOLE 3: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 3: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 4:
        GolfFieldHole hole_4=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_4);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_4);

        assertEquals("HOLE 4: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 4: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 4: Hole number must be equal to HOLE_4", Hole.HoleNumber.HOLE_4, itemHole.getNumber());
        assertEquals("HOLE 4: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 4: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 5:
        GolfFieldHole hole_5=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,370, Hole.Par.PAR_5);
        golfField.AddHole(hole_5);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_5);

        assertEquals("HOLE 5: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 5: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 5: Hole number must be equal to HOLE_5", Hole.HoleNumber.HOLE_5, itemHole.getNumber());
        assertEquals("HOLE 5: Length must be equal to 370", 370, itemHole.getLength());
        assertEquals("HOLE 5: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 6:
        GolfFieldHole hole_6=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_6);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_6);

        assertEquals("HOLE 6: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 6: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 6: Hole number must be equal to HOLE_6", Hole.HoleNumber.HOLE_6, itemHole.getNumber());
        assertEquals("HOLE 6: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 6: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 7:
        GolfFieldHole hole_7=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_7);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_7);

        assertEquals("HOLE 7: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 7: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 7: Hole number must be equal to HOLE_7", Hole.HoleNumber.HOLE_7, itemHole.getNumber());
        assertEquals("HOLE 7: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 7: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 8:
        GolfFieldHole hole_8=new GolfFieldHole(235L, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_8);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_8);

        assertEquals("HOLE 8: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 8: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 8: Hole number must be equal to HOLE_8", Hole.HoleNumber.HOLE_8, itemHole.getNumber());
        assertEquals("HOLE 8: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 8: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 9:
        GolfFieldHole hole_9=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_9);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_9);

        assertEquals("HOLE 9: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 9: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 9: Hole number must be equal to HOLE_9", Hole.HoleNumber.HOLE_9, itemHole.getNumber());
        assertEquals("HOLE 9: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 9: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 10:
        GolfFieldHole hole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 11:
        GolfFieldHole hole_11=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_11);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_11);

        assertEquals("HOLE 11: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 11: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 11: Hole number must be equal to HOLE_11", Hole.HoleNumber.HOLE_11, itemHole.getNumber());
        assertEquals("HOLE 11: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 11: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 12:
        GolfFieldHole hole_12=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_12);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_12);

        assertEquals("HOLE 12: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 12: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 12: Hole number must be equal to HOLE_12", Hole.HoleNumber.HOLE_12, itemHole.getNumber());
        assertEquals("HOLE 12: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 12: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 13:
        GolfFieldHole hole_13=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_13);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_13);

        assertEquals("HOLE 13: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 13: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 13: Hole number must be equal to HOLE_13", Hole.HoleNumber.HOLE_13, itemHole.getNumber());
        assertEquals("HOLE 13: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 13: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 14:
        GolfFieldHole hole_14=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_14);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_14);

        assertEquals("HOLE 14: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 14: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 14: Hole number must be equal to HOLE_14", Hole.HoleNumber.HOLE_14, itemHole.getNumber());
        assertEquals("HOLE 14: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 14: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 15:
        GolfFieldHole hole_15=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_15);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_15);

        assertEquals("HOLE 15: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 15: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 15: Hole number must be equal to HOLE_15", Hole.HoleNumber.HOLE_15, itemHole.getNumber());
        assertEquals("HOLE 15: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 15: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 16:
        GolfFieldHole hole_16=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_16);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_16);

        assertEquals("HOLE 16: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 16: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 16: Hole number must be equal to HOLE_16", Hole.HoleNumber.HOLE_16, itemHole.getNumber());
        assertEquals("HOLE 16: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 16: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 17:
        GolfFieldHole hole_17=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_17);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_17);

        assertEquals("HOLE 17: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 17: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 17: Hole number must be equal to HOLE_17", Hole.HoleNumber.HOLE_17, itemHole.getNumber());
        assertEquals("HOLE 17: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 17: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 18:
        GolfFieldHole hole_18=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_18);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_18);

        assertEquals("HOLE 18: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 18: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 18: Hole number must be equal to HOLE_18", Hole.HoleNumber.HOLE_18, itemHole.getNumber());
        assertEquals("HOLE 18: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 18: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Insert the golf Field and its holes into the database
        boolean insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",!insertedOK);


        assertEquals("Golf field id is not INVALID_GOLF_FIELD_ID",(long) INVALID_GOLF_FIELD_ID,golfField.get_id());


        //Verify that no golf field records were inserted
        Cursor AllGFCursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",0, AllGFCursor.getCount());


        //Verify that no golf field hole records were inserted
        Cursor AllGFHCursor=TestUtils.getAllGolfFieldHoles(mContext);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",0, AllGFHCursor.getCount());




        //The problem is fixed
        golfField.setName("This is the new Name");

        //Insert again the golffield with a correct name
        insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",insertedOK);


        //Verify the golffield was inserted correctly
        Cursor GFcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",1, GFcursor.getCount());

        TestUtils.VerifyExpectedGolfFieldQueryResult(golfField,GFcursor);

        //Verify the golffield holes  were inserted correctly
        Cursor GFHcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",18, GFHcursor.getCount());

        GFcursor.close();
        GFHcursor.close();
        AllGFHCursor.close();
        AllGFCursor.close();

        TestUtils.deleteAllRecords(mContext);

    }


    public void testNewGolfField_InvalidLengthNegative() {

        TestUtils.deleteAllRecords(mContext);



        String gf_name="Fake golf field name";
        ScorecardContract.ScorecardBoolean gf_favorite= ScorecardContract.ScorecardBoolean.FALSE;
        ScorecardContract.ScorecardBoolean gf_active= ScorecardContract.ScorecardBoolean.TRUE;

        GolfFieldHole itemHole;


        //Create the golf field Object
        GolfField golfField=new GolfField(gf_name,gf_favorite,gf_active);

        //Verify that the Golf field ID was set to NOT_SAVED at first time
        assertEquals("Golf Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, golfField.get_id());



        /*
        * Add the Holes
         */

        //Hole 1:
        GolfFieldHole hole_1=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3);
        golfField.AddHole(hole_1);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_1);

        assertEquals("HOLE 1: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 1: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 1: Hole number must be equal to HOLE_1", Hole.HoleNumber.HOLE_1, itemHole.getNumber());
        assertEquals("HOLE 1: Length must be equal to 120", 120, itemHole.getLength());
        assertEquals("HOLE 1: Par must be equal to PAR_3", Hole.Par.PAR_3, itemHole.getPar());


        //Hole 2:
        GolfFieldHole hole_2=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_2);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_2);

        assertEquals("HOLE 2: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 2: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 2: Hole number must be equal to HOLE_2", Hole.HoleNumber.HOLE_2, itemHole.getNumber());
        assertEquals("HOLE 2: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 2: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 3:
        GolfFieldHole hole_3=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_3);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_3);

        assertEquals("HOLE 3: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 3: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 3: Hole number must be equal to HOLE_3", Hole.HoleNumber.HOLE_3, itemHole.getNumber());
        assertEquals("HOLE 3: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 3: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 4:
        GolfFieldHole hole_4=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_4);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_4);

        assertEquals("HOLE 4: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 4: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 4: Hole number must be equal to HOLE_4", Hole.HoleNumber.HOLE_4, itemHole.getNumber());
        assertEquals("HOLE 4: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 4: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 5:
        GolfFieldHole hole_5=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,370, Hole.Par.PAR_5);
        golfField.AddHole(hole_5);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_5);

        assertEquals("HOLE 5: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 5: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 5: Hole number must be equal to HOLE_5", Hole.HoleNumber.HOLE_5, itemHole.getNumber());
        assertEquals("HOLE 5: Length must be equal to 370", 370, itemHole.getLength());
        assertEquals("HOLE 5: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 6:
        GolfFieldHole hole_6=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_6);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_6);

        assertEquals("HOLE 6: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 6: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 6: Hole number must be equal to HOLE_6", Hole.HoleNumber.HOLE_6, itemHole.getNumber());
        assertEquals("HOLE 6: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 6: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 7:
        GolfFieldHole hole_7=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_7);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_7);

        assertEquals("HOLE 7: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 7: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 7: Hole number must be equal to HOLE_7", Hole.HoleNumber.HOLE_7, itemHole.getNumber());
        assertEquals("HOLE 7: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 7: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 8:
        GolfFieldHole hole_8=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_8);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_8);

        assertEquals("HOLE 8: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 8: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 8: Hole number must be equal to HOLE_8", Hole.HoleNumber.HOLE_8, itemHole.getNumber());
        assertEquals("HOLE 8: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 8: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 9:
        GolfFieldHole hole_9=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_9);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_9);

        assertEquals("HOLE 9: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 9: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 9: Hole number must be equal to HOLE_9", Hole.HoleNumber.HOLE_9, itemHole.getNumber());
        assertEquals("HOLE 9: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 9: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 10:  HAS A NEGATIVE LENGTH!!!!!!!
        GolfFieldHole hole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,-350, Hole.Par.PAR_5);
        golfField.AddHole(hole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to INVALID", Hole.INVALID_HOLE_LENGTH, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 11:
        GolfFieldHole hole_11=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_11);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_11);

        assertEquals("HOLE 11: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 11: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 11: Hole number must be equal to HOLE_11", Hole.HoleNumber.HOLE_11, itemHole.getNumber());
        assertEquals("HOLE 11: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 11: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 12:
        GolfFieldHole hole_12=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_12);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_12);

        assertEquals("HOLE 12: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 12: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 12: Hole number must be equal to HOLE_12", Hole.HoleNumber.HOLE_12, itemHole.getNumber());
        assertEquals("HOLE 12: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 12: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 13:
        GolfFieldHole hole_13=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_13);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_13);

        assertEquals("HOLE 13: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 13: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 13: Hole number must be equal to HOLE_13", Hole.HoleNumber.HOLE_13, itemHole.getNumber());
        assertEquals("HOLE 13: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 13: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 14:
        GolfFieldHole hole_14=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_14);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_14);

        assertEquals("HOLE 14: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 14: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 14: Hole number must be equal to HOLE_14", Hole.HoleNumber.HOLE_14, itemHole.getNumber());
        assertEquals("HOLE 14: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 14: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 15:
        GolfFieldHole hole_15=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_15);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_15);

        assertEquals("HOLE 15: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 15: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 15: Hole number must be equal to HOLE_15", Hole.HoleNumber.HOLE_15, itemHole.getNumber());
        assertEquals("HOLE 15: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 15: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 16:
        GolfFieldHole hole_16=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_16);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_16);

        assertEquals("HOLE 16: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 16: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 16: Hole number must be equal to HOLE_16", Hole.HoleNumber.HOLE_16, itemHole.getNumber());
        assertEquals("HOLE 16: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 16: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 17:
        GolfFieldHole hole_17=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_17);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_17);

        assertEquals("HOLE 17: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 17: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 17: Hole number must be equal to HOLE_17", Hole.HoleNumber.HOLE_17, itemHole.getNumber());
        assertEquals("HOLE 17: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 17: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 18:
        GolfFieldHole hole_18=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_18);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_18);

        assertEquals("HOLE 18: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 18: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 18: Hole number must be equal to HOLE_18", Hole.HoleNumber.HOLE_18, itemHole.getNumber());
        assertEquals("HOLE 18: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 18: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Insert the golf Field and its holes into the database
        boolean insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",!insertedOK);


        assertEquals("Golf field id is not INVALID_GOLF_FIELD_ID",(long) INVALID_GOLF_FIELD_ID,golfField.get_id());


        //Verify that no golf field records were inserted
        Cursor AllGFCursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",0, AllGFCursor.getCount());


        //Verify that no golf field hole records were inserted
        Cursor AllGFHCursor=TestUtils.getAllGolfFieldHoles(mContext);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",0, AllGFHCursor.getCount());




        //The problem is fixed
        //Hole 10:
        GolfFieldHole fixedHole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,350, Hole.Par.PAR_5);
        golfField.AddHole(fixedHole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) INVALID_GOLF_FIELD_ID, itemHole.getGolfField_id());// ONCE IT WAS TRIED TO BE SAVED THE ID IS CHANGED TO INVALID!!!!!
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());



        //Insert again the golffield with a correct name
        insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",insertedOK);


        //Verify the golffield was inserted correctly
        Cursor GFcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",1, GFcursor.getCount());

        TestUtils.VerifyExpectedGolfFieldQueryResult(golfField,GFcursor);

        //Verify the golffield holes  were inserted correctly
        Cursor GFHcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",18, GFHcursor.getCount());

        GFcursor.close();
        GFHcursor.close();
        AllGFHCursor.close();
        AllGFCursor.close();

        TestUtils.deleteAllRecords(mContext);

    }


    public void testNewGolfField_InvalidLengthIsZero() {

        TestUtils.deleteAllRecords(mContext);



        String gf_name="Fake golf field name";
        ScorecardContract.ScorecardBoolean gf_favorite= ScorecardContract.ScorecardBoolean.FALSE;
        ScorecardContract.ScorecardBoolean gf_active= ScorecardContract.ScorecardBoolean.TRUE;

        GolfFieldHole itemHole;


        //Create the golf field Object
        GolfField golfField=new GolfField(gf_name,gf_favorite,gf_active);

        //Verify that the Golf field ID was set to NOT_SAVED at first time
        assertEquals("Golf Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, golfField.get_id());



        /*
        * Add the Holes
         */

        //Hole 1:
        GolfFieldHole hole_1=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3);
        golfField.AddHole(hole_1);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_1);

        assertEquals("HOLE 1: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 1: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 1: Hole number must be equal to HOLE_1", Hole.HoleNumber.HOLE_1, itemHole.getNumber());
        assertEquals("HOLE 1: Length must be equal to 120", 120, itemHole.getLength());
        assertEquals("HOLE 1: Par must be equal to PAR_3", Hole.Par.PAR_3, itemHole.getPar());


        //Hole 2:
        GolfFieldHole hole_2=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_2);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_2);

        assertEquals("HOLE 2: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 2: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 2: Hole number must be equal to HOLE_2", Hole.HoleNumber.HOLE_2, itemHole.getNumber());
        assertEquals("HOLE 2: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 2: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 3:
        GolfFieldHole hole_3=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_3);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_3);

        assertEquals("HOLE 3: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 3: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 3: Hole number must be equal to HOLE_3", Hole.HoleNumber.HOLE_3, itemHole.getNumber());
        assertEquals("HOLE 3: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 3: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 4:
        GolfFieldHole hole_4=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_4);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_4);

        assertEquals("HOLE 4: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 4: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 4: Hole number must be equal to HOLE_4", Hole.HoleNumber.HOLE_4, itemHole.getNumber());
        assertEquals("HOLE 4: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 4: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 5:
        GolfFieldHole hole_5=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,370, Hole.Par.PAR_5);
        golfField.AddHole(hole_5);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_5);

        assertEquals("HOLE 5: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 5: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 5: Hole number must be equal to HOLE_5", Hole.HoleNumber.HOLE_5, itemHole.getNumber());
        assertEquals("HOLE 5: Length must be equal to 370", 370, itemHole.getLength());
        assertEquals("HOLE 5: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 6:
        GolfFieldHole hole_6=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_6);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_6);

        assertEquals("HOLE 6: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 6: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 6: Hole number must be equal to HOLE_6", Hole.HoleNumber.HOLE_6, itemHole.getNumber());
        assertEquals("HOLE 6: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 6: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 7:
        GolfFieldHole hole_7=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_7);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_7);

        assertEquals("HOLE 7: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 7: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 7: Hole number must be equal to HOLE_7", Hole.HoleNumber.HOLE_7, itemHole.getNumber());
        assertEquals("HOLE 7: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 7: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 8:
        GolfFieldHole hole_8=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_8);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_8);

        assertEquals("HOLE 8: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 8: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 8: Hole number must be equal to HOLE_8", Hole.HoleNumber.HOLE_8, itemHole.getNumber());
        assertEquals("HOLE 8: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 8: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 9:
        GolfFieldHole hole_9=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_9);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_9);

        assertEquals("HOLE 9: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 9: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 9: Hole number must be equal to HOLE_9", Hole.HoleNumber.HOLE_9, itemHole.getNumber());
        assertEquals("HOLE 9: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 9: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 10:  HAS A 0 LENGTH!!!!!!!
        GolfFieldHole hole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,0, Hole.Par.PAR_5);
        golfField.AddHole(hole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 0", Hole.NOT_DEFINED_HOLE_LENGTH, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 11:
        GolfFieldHole hole_11=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_11);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_11);

        assertEquals("HOLE 11: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 11: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 11: Hole number must be equal to HOLE_11", Hole.HoleNumber.HOLE_11, itemHole.getNumber());
        assertEquals("HOLE 11: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 11: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 12:
        GolfFieldHole hole_12=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_12);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_12);

        assertEquals("HOLE 12: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 12: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 12: Hole number must be equal to HOLE_12", Hole.HoleNumber.HOLE_12, itemHole.getNumber());
        assertEquals("HOLE 12: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 12: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 13:
        GolfFieldHole hole_13=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_13);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_13);

        assertEquals("HOLE 13: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 13: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 13: Hole number must be equal to HOLE_13", Hole.HoleNumber.HOLE_13, itemHole.getNumber());
        assertEquals("HOLE 13: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 13: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 14:
        GolfFieldHole hole_14=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_14);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_14);

        assertEquals("HOLE 14: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 14: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 14: Hole number must be equal to HOLE_14", Hole.HoleNumber.HOLE_14, itemHole.getNumber());
        assertEquals("HOLE 14: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 14: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 15:
        GolfFieldHole hole_15=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_15);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_15);

        assertEquals("HOLE 15: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 15: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 15: Hole number must be equal to HOLE_15", Hole.HoleNumber.HOLE_15, itemHole.getNumber());
        assertEquals("HOLE 15: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 15: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 16:
        GolfFieldHole hole_16=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_16);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_16);

        assertEquals("HOLE 16: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 16: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 16: Hole number must be equal to HOLE_16", Hole.HoleNumber.HOLE_16, itemHole.getNumber());
        assertEquals("HOLE 16: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 16: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 17:
        GolfFieldHole hole_17=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_17);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_17);

        assertEquals("HOLE 17: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 17: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 17: Hole number must be equal to HOLE_17", Hole.HoleNumber.HOLE_17, itemHole.getNumber());
        assertEquals("HOLE 17: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 17: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 18:
        GolfFieldHole hole_18=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_18);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_18);

        assertEquals("HOLE 18: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 18: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 18: Hole number must be equal to HOLE_18", Hole.HoleNumber.HOLE_18, itemHole.getNumber());
        assertEquals("HOLE 18: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 18: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Insert the golf Field and its holes into the database
        boolean insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",!insertedOK);


        assertEquals("Golf field id is not INVALID_GOLF_FIELD_ID",(long) INVALID_GOLF_FIELD_ID,golfField.get_id());


        //Verify that no golf field records were inserted
        Cursor AllGFCursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",0, AllGFCursor.getCount());


        //Verify that no golf field hole records were inserted
        Cursor AllGFHCursor=TestUtils.getAllGolfFieldHoles(mContext);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",0, AllGFHCursor.getCount());




        //The problem is fixed
        //Hole 10:
        GolfFieldHole fixedHole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,350, Hole.Par.PAR_5);
        golfField.AddHole(fixedHole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) INVALID_GOLF_FIELD_ID, itemHole.getGolfField_id());// ONCE IT WAS TRIED TO BE SAVED THE ID IS CHANGED TO INVALID!!!!!
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());



        //Insert again the golffield with a correct name
        insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",insertedOK);


        //Verify the golffield was inserted correctly
        Cursor GFcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",1, GFcursor.getCount());

        TestUtils.VerifyExpectedGolfFieldQueryResult(golfField,GFcursor);

        //Verify the golffield holes  were inserted correctly
        Cursor GFHcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",18, GFHcursor.getCount());

        GFcursor.close();
        GFHcursor.close();
        AllGFHCursor.close();
        AllGFCursor.close();

        TestUtils.deleteAllRecords(mContext);

    }



    public void testNewGolfField_InvalidLengthLonger() {

        TestUtils.deleteAllRecords(mContext);



        String gf_name="Fake golf field name";
        ScorecardContract.ScorecardBoolean gf_favorite= ScorecardContract.ScorecardBoolean.FALSE;
        ScorecardContract.ScorecardBoolean gf_active= ScorecardContract.ScorecardBoolean.TRUE;

        GolfFieldHole itemHole;


        //Create the golf field Object
        GolfField golfField=new GolfField(gf_name,gf_favorite,gf_active);

        //Verify that the Golf field ID was set to NOT_SAVED at first time
        assertEquals("Golf Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, golfField.get_id());



        /*
        * Add the Holes
         */

        //Hole 1:
        GolfFieldHole hole_1=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3);
        golfField.AddHole(hole_1);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_1);

        assertEquals("HOLE 1: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 1: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 1: Hole number must be equal to HOLE_1", Hole.HoleNumber.HOLE_1, itemHole.getNumber());
        assertEquals("HOLE 1: Length must be equal to 120", 120, itemHole.getLength());
        assertEquals("HOLE 1: Par must be equal to PAR_3", Hole.Par.PAR_3, itemHole.getPar());


        //Hole 2:
        GolfFieldHole hole_2=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_2);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_2);

        assertEquals("HOLE 2: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 2: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 2: Hole number must be equal to HOLE_2", Hole.HoleNumber.HOLE_2, itemHole.getNumber());
        assertEquals("HOLE 2: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 2: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 3:
        GolfFieldHole hole_3=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_3);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_3);

        assertEquals("HOLE 3: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 3: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 3: Hole number must be equal to HOLE_3", Hole.HoleNumber.HOLE_3, itemHole.getNumber());
        assertEquals("HOLE 3: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 3: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 4:
        GolfFieldHole hole_4=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_4);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_4);

        assertEquals("HOLE 4: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 4: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 4: Hole number must be equal to HOLE_4", Hole.HoleNumber.HOLE_4, itemHole.getNumber());
        assertEquals("HOLE 4: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 4: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 5:
        GolfFieldHole hole_5=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,370, Hole.Par.PAR_5);
        golfField.AddHole(hole_5);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_5);

        assertEquals("HOLE 5: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 5: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 5: Hole number must be equal to HOLE_5", Hole.HoleNumber.HOLE_5, itemHole.getNumber());
        assertEquals("HOLE 5: Length must be equal to 370", 370, itemHole.getLength());
        assertEquals("HOLE 5: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 6:
        GolfFieldHole hole_6=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_6);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_6);

        assertEquals("HOLE 6: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 6: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 6: Hole number must be equal to HOLE_6", Hole.HoleNumber.HOLE_6, itemHole.getNumber());
        assertEquals("HOLE 6: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 6: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 7:
        GolfFieldHole hole_7=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_7);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_7);

        assertEquals("HOLE 7: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 7: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 7: Hole number must be equal to HOLE_7", Hole.HoleNumber.HOLE_7, itemHole.getNumber());
        assertEquals("HOLE 7: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 7: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 8:
        GolfFieldHole hole_8=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_8);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_8);

        assertEquals("HOLE 8: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 8: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 8: Hole number must be equal to HOLE_8", Hole.HoleNumber.HOLE_8, itemHole.getNumber());
        assertEquals("HOLE 8: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 8: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 9:
        GolfFieldHole hole_9=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_9);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_9);

        assertEquals("HOLE 9: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 9: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 9: Hole number must be equal to HOLE_9", Hole.HoleNumber.HOLE_9, itemHole.getNumber());
        assertEquals("HOLE 9: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 9: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 10:  HAS A LONGER LENGTH!!!!!!!
        GolfFieldHole hole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,660, Hole.Par.PAR_5);
        golfField.AddHole(hole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to INVALID", Hole.INVALID_HOLE_LENGTH, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 11:
        GolfFieldHole hole_11=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_11);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_11);

        assertEquals("HOLE 11: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 11: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 11: Hole number must be equal to HOLE_11", Hole.HoleNumber.HOLE_11, itemHole.getNumber());
        assertEquals("HOLE 11: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 11: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 12:
        GolfFieldHole hole_12=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_12);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_12);

        assertEquals("HOLE 12: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 12: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 12: Hole number must be equal to HOLE_12", Hole.HoleNumber.HOLE_12, itemHole.getNumber());
        assertEquals("HOLE 12: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 12: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 13:
        GolfFieldHole hole_13=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_13);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_13);

        assertEquals("HOLE 13: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 13: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 13: Hole number must be equal to HOLE_13", Hole.HoleNumber.HOLE_13, itemHole.getNumber());
        assertEquals("HOLE 13: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 13: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 14:
        GolfFieldHole hole_14=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_14);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_14);

        assertEquals("HOLE 14: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 14: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 14: Hole number must be equal to HOLE_14", Hole.HoleNumber.HOLE_14, itemHole.getNumber());
        assertEquals("HOLE 14: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 14: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 15:
        GolfFieldHole hole_15=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_15);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_15);

        assertEquals("HOLE 15: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 15: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 15: Hole number must be equal to HOLE_15", Hole.HoleNumber.HOLE_15, itemHole.getNumber());
        assertEquals("HOLE 15: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 15: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 16:
        GolfFieldHole hole_16=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_16);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_16);

        assertEquals("HOLE 16: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 16: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 16: Hole number must be equal to HOLE_16", Hole.HoleNumber.HOLE_16, itemHole.getNumber());
        assertEquals("HOLE 16: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 16: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 17:
        GolfFieldHole hole_17=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_17);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_17);

        assertEquals("HOLE 17: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 17: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 17: Hole number must be equal to HOLE_17", Hole.HoleNumber.HOLE_17, itemHole.getNumber());
        assertEquals("HOLE 17: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 17: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 18:
        GolfFieldHole hole_18=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_18);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_18);

        assertEquals("HOLE 18: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 18: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 18: Hole number must be equal to HOLE_18", Hole.HoleNumber.HOLE_18, itemHole.getNumber());
        assertEquals("HOLE 18: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 18: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Insert the golf Field and its holes into the database
        boolean insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",!insertedOK);


        assertEquals("Golf field id is not INVALID_GOLF_FIELD_ID",(long) INVALID_GOLF_FIELD_ID,golfField.get_id());


        //Verify that no golf field records were inserted
        Cursor AllGFCursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",0, AllGFCursor.getCount());


        //Verify that no golf field hole records were inserted
        Cursor AllGFHCursor=TestUtils.getAllGolfFieldHoles(mContext);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",0, AllGFHCursor.getCount());




        //The problem is fixed
        //Hole 10:
        GolfFieldHole fixedHole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,648, Hole.Par.PAR_5);
        golfField.AddHole(fixedHole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) INVALID_GOLF_FIELD_ID, itemHole.getGolfField_id());// ONCE IT WAS TRIED TO BE SAVED THE ID IS CHANGED TO INVALID!!!!!
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 648", 648, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());



        //Insert again the golffield with a correct name
        insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",insertedOK);


        //Verify the golffield was inserted correctly
        Cursor GFcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",1, GFcursor.getCount());

        TestUtils.VerifyExpectedGolfFieldQueryResult(golfField,GFcursor);

        //Verify the golffield holes  were inserted correctly
        Cursor GFHcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",18, GFHcursor.getCount());

        GFcursor.close();
        GFHcursor.close();
        AllGFHCursor.close();
        AllGFCursor.close();

        TestUtils.deleteAllRecords(mContext);

    }




    public void testNewGolfField_InvalidLengthShorter() {

        TestUtils.deleteAllRecords(mContext);



        String gf_name="Fake golf field name";
        ScorecardContract.ScorecardBoolean gf_favorite= ScorecardContract.ScorecardBoolean.FALSE;
        ScorecardContract.ScorecardBoolean gf_active= ScorecardContract.ScorecardBoolean.TRUE;

        GolfFieldHole itemHole;


        //Create the golf field Object
        GolfField golfField=new GolfField(gf_name,gf_favorite,gf_active);

        //Verify that the Golf field ID was set to NOT_SAVED at first time
        assertEquals("Golf Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, golfField.get_id());



        /*
        * Add the Holes
         */

        //Hole 1:
        GolfFieldHole hole_1=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3);
        golfField.AddHole(hole_1);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_1);

        assertEquals("HOLE 1: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 1: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 1: Hole number must be equal to HOLE_1", Hole.HoleNumber.HOLE_1, itemHole.getNumber());
        assertEquals("HOLE 1: Length must be equal to 120", 120, itemHole.getLength());
        assertEquals("HOLE 1: Par must be equal to PAR_3", Hole.Par.PAR_3, itemHole.getPar());


        //Hole 2:
        GolfFieldHole hole_2=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_2);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_2);

        assertEquals("HOLE 2: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 2: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 2: Hole number must be equal to HOLE_2", Hole.HoleNumber.HOLE_2, itemHole.getNumber());
        assertEquals("HOLE 2: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 2: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 3:
        GolfFieldHole hole_3=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_3);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_3);

        assertEquals("HOLE 3: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 3: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 3: Hole number must be equal to HOLE_3", Hole.HoleNumber.HOLE_3, itemHole.getNumber());
        assertEquals("HOLE 3: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 3: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 4:
        GolfFieldHole hole_4=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_4);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_4);

        assertEquals("HOLE 4: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 4: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 4: Hole number must be equal to HOLE_4", Hole.HoleNumber.HOLE_4, itemHole.getNumber());
        assertEquals("HOLE 4: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 4: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 5:
        GolfFieldHole hole_5=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,370, Hole.Par.PAR_5);
        golfField.AddHole(hole_5);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_5);

        assertEquals("HOLE 5: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 5: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 5: Hole number must be equal to HOLE_5", Hole.HoleNumber.HOLE_5, itemHole.getNumber());
        assertEquals("HOLE 5: Length must be equal to 370", 370, itemHole.getLength());
        assertEquals("HOLE 5: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 6:
        GolfFieldHole hole_6=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_6);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_6);

        assertEquals("HOLE 6: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 6: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 6: Hole number must be equal to HOLE_6", Hole.HoleNumber.HOLE_6, itemHole.getNumber());
        assertEquals("HOLE 6: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 6: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 7:
        GolfFieldHole hole_7=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_7);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_7);

        assertEquals("HOLE 7: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 7: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 7: Hole number must be equal to HOLE_7", Hole.HoleNumber.HOLE_7, itemHole.getNumber());
        assertEquals("HOLE 7: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 7: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 8:
        GolfFieldHole hole_8=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_8);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_8);

        assertEquals("HOLE 8: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 8: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 8: Hole number must be equal to HOLE_8", Hole.HoleNumber.HOLE_8, itemHole.getNumber());
        assertEquals("HOLE 8: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 8: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 9:
        GolfFieldHole hole_9=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_9);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_9);

        assertEquals("HOLE 9: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 9: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 9: Hole number must be equal to HOLE_9", Hole.HoleNumber.HOLE_9, itemHole.getNumber());
        assertEquals("HOLE 9: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 9: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 10:  HAS A SHORTER LENGTH!!!!!!!
        GolfFieldHole hole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,9, Hole.Par.PAR_5);
        golfField.AddHole(hole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to INVALID", Hole.INVALID_HOLE_LENGTH, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 11:
        GolfFieldHole hole_11=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_11);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_11);

        assertEquals("HOLE 11: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 11: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 11: Hole number must be equal to HOLE_11", Hole.HoleNumber.HOLE_11, itemHole.getNumber());
        assertEquals("HOLE 11: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 11: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 12:
        GolfFieldHole hole_12=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_12);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_12);

        assertEquals("HOLE 12: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 12: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 12: Hole number must be equal to HOLE_12", Hole.HoleNumber.HOLE_12, itemHole.getNumber());
        assertEquals("HOLE 12: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 12: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 13:
        GolfFieldHole hole_13=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_13);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_13);

        assertEquals("HOLE 13: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 13: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 13: Hole number must be equal to HOLE_13", Hole.HoleNumber.HOLE_13, itemHole.getNumber());
        assertEquals("HOLE 13: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 13: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 14:
        GolfFieldHole hole_14=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_14);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_14);

        assertEquals("HOLE 14: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 14: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 14: Hole number must be equal to HOLE_14", Hole.HoleNumber.HOLE_14, itemHole.getNumber());
        assertEquals("HOLE 14: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 14: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 15:
        GolfFieldHole hole_15=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_15);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_15);

        assertEquals("HOLE 15: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 15: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 15: Hole number must be equal to HOLE_15", Hole.HoleNumber.HOLE_15, itemHole.getNumber());
        assertEquals("HOLE 15: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 15: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 16:
        GolfFieldHole hole_16=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_16);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_16);

        assertEquals("HOLE 16: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 16: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 16: Hole number must be equal to HOLE_16", Hole.HoleNumber.HOLE_16, itemHole.getNumber());
        assertEquals("HOLE 16: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 16: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 17:
        GolfFieldHole hole_17=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_17);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_17);

        assertEquals("HOLE 17: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 17: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 17: Hole number must be equal to HOLE_17", Hole.HoleNumber.HOLE_17, itemHole.getNumber());
        assertEquals("HOLE 17: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 17: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 18:
        GolfFieldHole hole_18=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_18);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_18);

        assertEquals("HOLE 18: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 18: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 18: Hole number must be equal to HOLE_18", Hole.HoleNumber.HOLE_18, itemHole.getNumber());
        assertEquals("HOLE 18: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 18: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Insert the golf Field and its holes into the database
        boolean insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",!insertedOK);


        assertEquals("Golf field id is not INVALID_GOLF_FIELD_ID",(long) INVALID_GOLF_FIELD_ID,golfField.get_id());


        //Verify that no golf field records were inserted
        Cursor AllGFCursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",0, AllGFCursor.getCount());


        //Verify that no golf field hole records were inserted
        Cursor AllGFHCursor=TestUtils.getAllGolfFieldHoles(mContext);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",0, AllGFHCursor.getCount());




        //The problem is fixed
        //Hole 10:
        GolfFieldHole fixedHole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,15, Hole.Par.PAR_5);
        golfField.AddHole(fixedHole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) INVALID_GOLF_FIELD_ID, itemHole.getGolfField_id());// ONCE IT WAS TRIED TO BE SAVED THE ID IS CHANGED TO INVALID!!!!!
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 15", 15, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());



        //Insert again the golffield with a correct name
        insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",insertedOK);


        //Verify the golffield was inserted correctly
        Cursor GFcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",1, GFcursor.getCount());

        TestUtils.VerifyExpectedGolfFieldQueryResult(golfField,GFcursor);

        //Verify the golffield holes  were inserted correctly
        Cursor GFHcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",18, GFHcursor.getCount());

        GFcursor.close();
        GFHcursor.close();
        AllGFHCursor.close();
        AllGFCursor.close();

        TestUtils.deleteAllRecords(mContext);

    }








    public void testNewGolfField_InvalidNotAllHoles() {

        TestUtils.deleteAllRecords(mContext);



        String gf_name="Fake golf field name";
        ScorecardContract.ScorecardBoolean gf_favorite= ScorecardContract.ScorecardBoolean.FALSE;
        ScorecardContract.ScorecardBoolean gf_active= ScorecardContract.ScorecardBoolean.TRUE;

        GolfFieldHole itemHole;


        //Create the golf field Object
        GolfField golfField=new GolfField(gf_name,gf_favorite,gf_active);

        //Verify that the Golf field ID was set to NOT_SAVED at first time
        assertEquals("Golf Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, golfField.get_id());



        /*
        * Add the Holes
         */

        //Hole 1:
        GolfFieldHole hole_1=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3);
        golfField.AddHole(hole_1);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_1);

        assertEquals("HOLE 1: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 1: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 1: Hole number must be equal to HOLE_1", Hole.HoleNumber.HOLE_1, itemHole.getNumber());
        assertEquals("HOLE 1: Length must be equal to 120", 120, itemHole.getLength());
        assertEquals("HOLE 1: Par must be equal to PAR_3", Hole.Par.PAR_3, itemHole.getPar());


        //Hole 2:
        GolfFieldHole hole_2=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_2);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_2);

        assertEquals("HOLE 2: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 2: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 2: Hole number must be equal to HOLE_2", Hole.HoleNumber.HOLE_2, itemHole.getNumber());
        assertEquals("HOLE 2: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 2: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 3:
        GolfFieldHole hole_3=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_3);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_3);

        assertEquals("HOLE 3: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 3: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 3: Hole number must be equal to HOLE_3", Hole.HoleNumber.HOLE_3, itemHole.getNumber());
        assertEquals("HOLE 3: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 3: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 4:
        GolfFieldHole hole_4=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_4);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_4);

        assertEquals("HOLE 4: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 4: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 4: Hole number must be equal to HOLE_4", Hole.HoleNumber.HOLE_4, itemHole.getNumber());
        assertEquals("HOLE 4: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 4: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 5:
        GolfFieldHole hole_5=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,370, Hole.Par.PAR_5);
        golfField.AddHole(hole_5);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_5);

        assertEquals("HOLE 5: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 5: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 5: Hole number must be equal to HOLE_5", Hole.HoleNumber.HOLE_5, itemHole.getNumber());
        assertEquals("HOLE 5: Length must be equal to 370", 370, itemHole.getLength());
        assertEquals("HOLE 5: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 6:
        GolfFieldHole hole_6=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_6);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_6);

        assertEquals("HOLE 6: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 6: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 6: Hole number must be equal to HOLE_6", Hole.HoleNumber.HOLE_6, itemHole.getNumber());
        assertEquals("HOLE 6: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 6: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 7:
        GolfFieldHole hole_7=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_7);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_7);

        assertEquals("HOLE 7: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 7: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 7: Hole number must be equal to HOLE_7", Hole.HoleNumber.HOLE_7, itemHole.getNumber());
        assertEquals("HOLE 7: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 7: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 8:
        GolfFieldHole hole_8=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_8);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_8);

        assertEquals("HOLE 8: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 8: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 8: Hole number must be equal to HOLE_8", Hole.HoleNumber.HOLE_8, itemHole.getNumber());
        assertEquals("HOLE 8: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 8: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 9:
        GolfFieldHole hole_9=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_9);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_9);

        assertEquals("HOLE 9: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 9: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 9: Hole number must be equal to HOLE_9", Hole.HoleNumber.HOLE_9, itemHole.getNumber());
        assertEquals("HOLE 9: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 9: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 10:  HAS A HOLE 11 information it will be added in the 11 position and the 10 will remain in null!!!!!!!
        GolfFieldHole hole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_11);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 10: Hole number must be equal to HOLE_11", Hole.HoleNumber.HOLE_11, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 11:
        GolfFieldHole hole_11=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_11);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_11);

        assertEquals("HOLE 11: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 11: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 11: Hole number must be equal to HOLE_11", Hole.HoleNumber.HOLE_11, itemHole.getNumber());
        assertEquals("HOLE 11: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 11: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 12:
        GolfFieldHole hole_12=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_12);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_12);

        assertEquals("HOLE 12: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 12: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 12: Hole number must be equal to HOLE_12", Hole.HoleNumber.HOLE_12, itemHole.getNumber());
        assertEquals("HOLE 12: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 12: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 13:
        GolfFieldHole hole_13=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_13);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_13);

        assertEquals("HOLE 13: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 13: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 13: Hole number must be equal to HOLE_13", Hole.HoleNumber.HOLE_13, itemHole.getNumber());
        assertEquals("HOLE 13: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 13: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 14:
        GolfFieldHole hole_14=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_14);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_14);

        assertEquals("HOLE 14: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 14: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 14: Hole number must be equal to HOLE_14", Hole.HoleNumber.HOLE_14, itemHole.getNumber());
        assertEquals("HOLE 14: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 14: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 15:
        GolfFieldHole hole_15=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_15);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_15);

        assertEquals("HOLE 15: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 15: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 15: Hole number must be equal to HOLE_15", Hole.HoleNumber.HOLE_15, itemHole.getNumber());
        assertEquals("HOLE 15: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 15: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 16:
        GolfFieldHole hole_16=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_16);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_16);

        assertEquals("HOLE 16: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 16: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 16: Hole number must be equal to HOLE_16", Hole.HoleNumber.HOLE_16, itemHole.getNumber());
        assertEquals("HOLE 16: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 16: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 17:
        GolfFieldHole hole_17=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_17);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_17);

        assertEquals("HOLE 17: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 17: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 17: Hole number must be equal to HOLE_17", Hole.HoleNumber.HOLE_17, itemHole.getNumber());
        assertEquals("HOLE 17: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 17: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 18:
        GolfFieldHole hole_18=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_18);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_18);

        assertEquals("HOLE 18: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 18: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 18: Hole number must be equal to HOLE_18", Hole.HoleNumber.HOLE_18, itemHole.getNumber());
        assertEquals("HOLE 18: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 18: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Insert the golf Field and its holes into the database
        boolean insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",!insertedOK);


        assertEquals("Golf field id is not INVALID_GOLF_FIELD_ID",(long) INVALID_GOLF_FIELD_ID,golfField.get_id());


        //Verify that no golf field records were inserted
        Cursor AllGFCursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",0, AllGFCursor.getCount());


        //Verify that no golf field hole records were inserted
        Cursor AllGFHCursor=TestUtils.getAllGolfFieldHoles(mContext);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",0, AllGFHCursor.getCount());




        //The problem is fixed
        //Hole 10:
        GolfFieldHole fixedHole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,350, Hole.Par.PAR_5);
        golfField.AddHole(fixedHole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) INVALID_GOLF_FIELD_ID, itemHole.getGolfField_id());// ONCE IT WAS TRIED TO BE SAVED THE ID IS CHANGED TO INVALID!!!!!
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());



        //Insert again the golffield with a correct name
        insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",insertedOK);


        //Verify the golffield was inserted correctly
        Cursor GFcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",1, GFcursor.getCount());

        TestUtils.VerifyExpectedGolfFieldQueryResult(golfField,GFcursor);

        //Verify the golffield holes  were inserted correctly
        Cursor GFHcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",18, GFHcursor.getCount());

        GFcursor.close();
        GFHcursor.close();
        AllGFHCursor.close();
        AllGFCursor.close();

        TestUtils.deleteAllRecords(mContext);

    }



    public void testNewGolfField_InvalidPar() {

        TestUtils.deleteAllRecords(mContext);



        String gf_name="Fake golf field name";
        ScorecardContract.ScorecardBoolean gf_favorite= ScorecardContract.ScorecardBoolean.FALSE;
        ScorecardContract.ScorecardBoolean gf_active= ScorecardContract.ScorecardBoolean.TRUE;

        GolfFieldHole itemHole;


        //Create the golf field Object
        GolfField golfField=new GolfField(gf_name,gf_favorite,gf_active);

        //Verify that the Golf field ID was set to NOT_SAVED at first time
        assertEquals("Golf Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, golfField.get_id());



        /*
        * Add the Holes
         */

        //Hole 1:
        GolfFieldHole hole_1=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3);
        golfField.AddHole(hole_1);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_1);

        assertEquals("HOLE 1: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 1: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 1: Hole number must be equal to HOLE_1", Hole.HoleNumber.HOLE_1, itemHole.getNumber());
        assertEquals("HOLE 1: Length must be equal to 120", 120, itemHole.getLength());
        assertEquals("HOLE 1: Par must be equal to PAR_3", Hole.Par.PAR_3, itemHole.getPar());


        //Hole 2:
        GolfFieldHole hole_2=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_2);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_2);

        assertEquals("HOLE 2: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 2: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 2: Hole number must be equal to HOLE_2", Hole.HoleNumber.HOLE_2, itemHole.getNumber());
        assertEquals("HOLE 2: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 2: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 3:
        GolfFieldHole hole_3=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_3);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_3);

        assertEquals("HOLE 3: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 3: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 3: Hole number must be equal to HOLE_3", Hole.HoleNumber.HOLE_3, itemHole.getNumber());
        assertEquals("HOLE 3: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 3: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 4:
        GolfFieldHole hole_4=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_4);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_4);

        assertEquals("HOLE 4: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 4: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 4: Hole number must be equal to HOLE_4", Hole.HoleNumber.HOLE_4, itemHole.getNumber());
        assertEquals("HOLE 4: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 4: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 5:
        GolfFieldHole hole_5=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,370, Hole.Par.PAR_5);
        golfField.AddHole(hole_5);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_5);

        assertEquals("HOLE 5: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 5: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 5: Hole number must be equal to HOLE_5", Hole.HoleNumber.HOLE_5, itemHole.getNumber());
        assertEquals("HOLE 5: Length must be equal to 370", 370, itemHole.getLength());
        assertEquals("HOLE 5: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 6:
        GolfFieldHole hole_6=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_6);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_6);

        assertEquals("HOLE 6: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 6: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 6: Hole number must be equal to HOLE_6", Hole.HoleNumber.HOLE_6, itemHole.getNumber());
        assertEquals("HOLE 6: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 6: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 7:
        GolfFieldHole hole_7=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_7);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_7);

        assertEquals("HOLE 7: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 7: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 7: Hole number must be equal to HOLE_7", Hole.HoleNumber.HOLE_7, itemHole.getNumber());
        assertEquals("HOLE 7: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 7: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 8:
        GolfFieldHole hole_8=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_8);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_8);

        assertEquals("HOLE 8: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 8: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 8: Hole number must be equal to HOLE_8", Hole.HoleNumber.HOLE_8, itemHole.getNumber());
        assertEquals("HOLE 8: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 8: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 9:
        GolfFieldHole hole_9=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_9);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_9);

        assertEquals("HOLE 9: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 9: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 9: Hole number must be equal to HOLE_9", Hole.HoleNumber.HOLE_9, itemHole.getNumber());
        assertEquals("HOLE 9: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 9: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        ///Hole 10:  PAR INVALID will be rejected!!!!!!!
        GolfFieldHole hole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,350, Hole.Par.PAR_INVALID);
        golfField.AddHole(hole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_INVALID", Hole.Par.PAR_INVALID, itemHole.getPar());

        //Hole 11:
        GolfFieldHole hole_11=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_11);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_11);

        assertEquals("HOLE 11: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 11: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 11: Hole number must be equal to HOLE_11", Hole.HoleNumber.HOLE_11, itemHole.getNumber());
        assertEquals("HOLE 11: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 11: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 12:
        GolfFieldHole hole_12=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_12);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_12);

        assertEquals("HOLE 12: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 12: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 12: Hole number must be equal to HOLE_12", Hole.HoleNumber.HOLE_12, itemHole.getNumber());
        assertEquals("HOLE 12: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 12: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 13:
        GolfFieldHole hole_13=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_13);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_13);

        assertEquals("HOLE 13: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 13: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 13: Hole number must be equal to HOLE_13", Hole.HoleNumber.HOLE_13, itemHole.getNumber());
        assertEquals("HOLE 13: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 13: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 14:
        GolfFieldHole hole_14=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_14);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_14);

        assertEquals("HOLE 14: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 14: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 14: Hole number must be equal to HOLE_14", Hole.HoleNumber.HOLE_14, itemHole.getNumber());
        assertEquals("HOLE 14: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 14: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 15:
        GolfFieldHole hole_15=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_15);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_15);

        assertEquals("HOLE 15: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 15: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 15: Hole number must be equal to HOLE_15", Hole.HoleNumber.HOLE_15, itemHole.getNumber());
        assertEquals("HOLE 15: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 15: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 16:
        GolfFieldHole hole_16=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_16);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_16);

        assertEquals("HOLE 16: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 16: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 16: Hole number must be equal to HOLE_16", Hole.HoleNumber.HOLE_16, itemHole.getNumber());
        assertEquals("HOLE 16: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 16: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 17:
        GolfFieldHole hole_17=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_17);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_17);

        assertEquals("HOLE 17: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 17: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 17: Hole number must be equal to HOLE_17", Hole.HoleNumber.HOLE_17, itemHole.getNumber());
        assertEquals("HOLE 17: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 17: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 18:
        GolfFieldHole hole_18=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_18);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_18);

        assertEquals("HOLE 18: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 18: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 18: Hole number must be equal to HOLE_18", Hole.HoleNumber.HOLE_18, itemHole.getNumber());
        assertEquals("HOLE 18: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 18: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Insert the golf Field and its holes into the database
        boolean insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",!insertedOK);


        assertEquals("Golf field id is not INVALID_GOLF_FIELD_ID",(long) INVALID_GOLF_FIELD_ID,golfField.get_id());


        //Verify that no golf field records were inserted
        Cursor AllGFCursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",0, AllGFCursor.getCount());


        //Verify that no golf field hole records were inserted
        Cursor AllGFHCursor=TestUtils.getAllGolfFieldHoles(mContext);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",0, AllGFHCursor.getCount());




        //The problem is fixed
        //Hole 10:
        GolfFieldHole fixedHole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,350, Hole.Par.PAR_5);
        golfField.AddHole(fixedHole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) INVALID_GOLF_FIELD_ID, itemHole.getGolfField_id());// ONCE IT WAS TRIED TO BE SAVED THE ID IS CHANGED TO INVALID!!!!!
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());



        //Insert again the golffield with a correct name
        insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",insertedOK);


        //Verify the golffield was inserted correctly
        Cursor GFcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",1, GFcursor.getCount());

        TestUtils.VerifyExpectedGolfFieldQueryResult(golfField,GFcursor);

        //Verify the golffield holes  were inserted correctly
        Cursor GFHcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",18, GFHcursor.getCount());

        GFcursor.close();
        GFHcursor.close();
        AllGFHCursor.close();
        AllGFCursor.close();

        TestUtils.deleteAllRecords(mContext);

    }

    public void testNewGolfField_NotDefinedPar() {

        TestUtils.deleteAllRecords(mContext);



        String gf_name="Fake golf field name";
        ScorecardContract.ScorecardBoolean gf_favorite= ScorecardContract.ScorecardBoolean.FALSE;
        ScorecardContract.ScorecardBoolean gf_active= ScorecardContract.ScorecardBoolean.TRUE;

        GolfFieldHole itemHole;


        //Create the golf field Object
        GolfField golfField=new GolfField(gf_name,gf_favorite,gf_active);

        //Verify that the Golf field ID was set to NOT_SAVED at first time
        assertEquals("Golf Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, golfField.get_id());



        /*
        * Add the Holes
         */

        //Hole 1:
        GolfFieldHole hole_1=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3);
        golfField.AddHole(hole_1);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_1);

        assertEquals("HOLE 1: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 1: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 1: Hole number must be equal to HOLE_1", Hole.HoleNumber.HOLE_1, itemHole.getNumber());
        assertEquals("HOLE 1: Length must be equal to 120", 120, itemHole.getLength());
        assertEquals("HOLE 1: Par must be equal to PAR_3", Hole.Par.PAR_3, itemHole.getPar());


        //Hole 2:
        GolfFieldHole hole_2=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_2);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_2);

        assertEquals("HOLE 2: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 2: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 2: Hole number must be equal to HOLE_2", Hole.HoleNumber.HOLE_2, itemHole.getNumber());
        assertEquals("HOLE 2: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 2: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 3:
        GolfFieldHole hole_3=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_3);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_3);

        assertEquals("HOLE 3: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 3: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 3: Hole number must be equal to HOLE_3", Hole.HoleNumber.HOLE_3, itemHole.getNumber());
        assertEquals("HOLE 3: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 3: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 4:
        GolfFieldHole hole_4=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_4);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_4);

        assertEquals("HOLE 4: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 4: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 4: Hole number must be equal to HOLE_4", Hole.HoleNumber.HOLE_4, itemHole.getNumber());
        assertEquals("HOLE 4: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 4: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 5:
        GolfFieldHole hole_5=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,370, Hole.Par.PAR_5);
        golfField.AddHole(hole_5);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_5);

        assertEquals("HOLE 5: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 5: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 5: Hole number must be equal to HOLE_5", Hole.HoleNumber.HOLE_5, itemHole.getNumber());
        assertEquals("HOLE 5: Length must be equal to 370", 370, itemHole.getLength());
        assertEquals("HOLE 5: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Hole 6:
        GolfFieldHole hole_6=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_6);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_6);

        assertEquals("HOLE 6: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 6: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 6: Hole number must be equal to HOLE_6", Hole.HoleNumber.HOLE_6, itemHole.getNumber());
        assertEquals("HOLE 6: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 6: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 7:
        GolfFieldHole hole_7=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_7);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_7);

        assertEquals("HOLE 7: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 7: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 7: Hole number must be equal to HOLE_7", Hole.HoleNumber.HOLE_7, itemHole.getNumber());
        assertEquals("HOLE 7: Length must be equal to 265", 265, itemHole.getLength());
        assertEquals("HOLE 7: Par must be equal to PAR_5", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 8:
        GolfFieldHole hole_8=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_8);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_8);

        assertEquals("HOLE 8: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 8: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 8: Hole number must be equal to HOLE_8", Hole.HoleNumber.HOLE_8, itemHole.getNumber());
        assertEquals("HOLE 8: Length must be equal to 220", 220, itemHole.getLength());
        assertEquals("HOLE 8: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 9:
        GolfFieldHole hole_9=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_9);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_9);

        assertEquals("HOLE 9: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 9: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 9: Hole number must be equal to HOLE_9", Hole.HoleNumber.HOLE_9, itemHole.getNumber());
        assertEquals("HOLE 9: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 9: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 10:  PAR Not defined will be rejected!!!!!!!
        GolfFieldHole hole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,350, Hole.Par.PAR_NOT_DEFINED);
        golfField.AddHole(hole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_INVALID", Hole.Par.PAR_NOT_DEFINED, itemHole.getPar());

        //Hole 11:
        GolfFieldHole hole_11=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_11);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_11);

        assertEquals("HOLE 11: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 11: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 11: Hole number must be equal to HOLE_11", Hole.HoleNumber.HOLE_11, itemHole.getNumber());
        assertEquals("HOLE 11: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 11: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 12:
        GolfFieldHole hole_12=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_12);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_12);

        assertEquals("HOLE 12: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 12: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 12: Hole number must be equal to HOLE_12", Hole.HoleNumber.HOLE_12, itemHole.getNumber());
        assertEquals("HOLE 12: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 12: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 13:
        GolfFieldHole hole_13=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_13);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_13);

        assertEquals("HOLE 13: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 13: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 13: Hole number must be equal to HOLE_13", Hole.HoleNumber.HOLE_13, itemHole.getNumber());
        assertEquals("HOLE 13: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 13: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 14:
        GolfFieldHole hole_14=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_14);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_14);

        assertEquals("HOLE 14: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 14: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 14: Hole number must be equal to HOLE_14", Hole.HoleNumber.HOLE_14, itemHole.getNumber());
        assertEquals("HOLE 14: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 14: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 15:
        GolfFieldHole hole_15=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_15);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_15);

        assertEquals("HOLE 15: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 15: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 15: Hole number must be equal to HOLE_15", Hole.HoleNumber.HOLE_15, itemHole.getNumber());
        assertEquals("HOLE 15: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 15: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());

        //Hole 16:
        GolfFieldHole hole_16=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_16);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_16);

        assertEquals("HOLE 16: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 16: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 16: Hole number must be equal to HOLE_16", Hole.HoleNumber.HOLE_16, itemHole.getNumber());
        assertEquals("HOLE 16: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 16: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());

        //Hole 17:
        GolfFieldHole hole_17=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_17);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_17);

        assertEquals("HOLE 17: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 17: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 17: Hole number must be equal to HOLE_17", Hole.HoleNumber.HOLE_17, itemHole.getNumber());
        assertEquals("HOLE 17: Length must be equal to 250", 250, itemHole.getLength());
        assertEquals("HOLE 17: Par must be equal to PAR_4", Hole.Par.PAR_4, itemHole.getPar());


        //Hole 18:
        GolfFieldHole hole_18=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_18);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_18);

        assertEquals("HOLE 18: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 18: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) NOT_SAVED_GOLF_FIELD_ID, itemHole.getGolfField_id());
        assertEquals("HOLE 18: Hole number must be equal to HOLE_18", Hole.HoleNumber.HOLE_18, itemHole.getNumber());
        assertEquals("HOLE 18: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 18: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());


        //Insert the golf Field and its holes into the database
        boolean insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",!insertedOK);


        assertEquals("Golf field id is not INVALID_GOLF_FIELD_ID",(long) INVALID_GOLF_FIELD_ID,golfField.get_id());


        //Verify that no golf field records were inserted
        Cursor AllGFCursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",0, AllGFCursor.getCount());


        //Verify that no golf field hole records were inserted
        Cursor AllGFHCursor=TestUtils.getAllGolfFieldHoles(mContext);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",0, AllGFHCursor.getCount());




        //The problem is fixed
        //Hole 10:
        GolfFieldHole fixedHole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,350, Hole.Par.PAR_5);
        golfField.AddHole(fixedHole_10);

        //Verify the Added Hole
        itemHole=golfField.getHole(Hole.HoleNumber.HOLE_10);

        assertEquals("HOLE 10: Golf Field Hole id must be equal to Hole.NOT_SAVED_HOLE_ID", (long) Hole.NOT_SAVED_HOLE_ID, itemHole.get_id());
        assertEquals("HOLE 10: Field id must be equal to GolfField.NOT_SAVED_GOLF_FIELD_ID", (long) INVALID_GOLF_FIELD_ID, itemHole.getGolfField_id());// ONCE IT WAS TRIED TO BE SAVED THE ID IS CHANGED TO INVALID!!!!!
        assertEquals("HOLE 10: Hole number must be equal to HOLE_10", Hole.HoleNumber.HOLE_10, itemHole.getNumber());
        assertEquals("HOLE 10: Length must be equal to 350", 350, itemHole.getLength());
        assertEquals("HOLE 10: Par must be equal to PAR_5", Hole.Par.PAR_5, itemHole.getPar());



        //Insert again the golffield with a correct name
        insertedOK=golfField.InsertGolfField(mContext);
        assertTrue("Golf field was not inserted correctly",insertedOK);


        //Verify the golffield was inserted correctly
        Cursor GFcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields records doesn't match",1, GFcursor.getCount());

        TestUtils.VerifyExpectedGolfFieldQueryResult(golfField,GFcursor);

        //Verify the golffield holes  were inserted correctly
        Cursor GFHcursor=mContext.getContentResolver().query(ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(golfField.get_id()),null,null,null,null);
        assertEquals("The quantity of retrieved golf fields holes records doesn't match",18, GFHcursor.getCount());

        GFcursor.close();
        GFHcursor.close();
        AllGFHCursor.close();
        AllGFCursor.close();

        TestUtils.deleteAllRecords(mContext);

    }


    //TODO VERIFY THE UPDATE of A GOLF FIELD!!!!!!!!




}
