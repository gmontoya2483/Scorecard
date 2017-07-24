package com.montoya.gabi.scorecard;

import android.database.Cursor;
import android.test.AndroidTestCase;

import com.montoya.gabi.scorecard.model.Scorecard;

/**
 * Created by Gabriel on 23/07/2017.
 */

public class TestScorecard extends AndroidTestCase {


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


    public void testNewScorecard_OK() {

        TestUtils.deleteAllRecords(mContext);

        long _id;
        long date=123456789L;
        int handicap=25;

        long golfField_id=125L;
        String golfFieldName="Fake Name";
        int golfFieldTotalLength=4562;
        int golfFieldTotalPar=72;
        int golfFieldOutLength=2100;
        int golfFieldOutPar=37;
        int golfFieldInLength=2150;
        int golfFieldInPar=35;

        int outScore=45;
        int outDif=6;
        int inScore=40;
        int inDif=-2;
        int grossScore=85;
        int grossDif=4;
        int netScore=60;
        int netDif=3;

        Scorecard scorecard_1=new Scorecard(date,
                handicap,
                golfField_id,
                golfFieldName,
                golfFieldTotalLength,
                golfFieldTotalPar,
                golfFieldOutLength,
                golfFieldOutPar,
                golfFieldInLength,
                golfFieldInPar,
                outScore,
                outDif,
                inScore,
                inDif,
                grossScore,
                grossDif,
                netScore,
                netDif);


        //Verify the scorecard was inserted correctly
        assertTrue("The scorecard was not inserted correctly",scorecard_1.insertScorecard(mContext));

        // Verify the the inserted scorecard stored correctly
        Scorecard scorecard_2=new Scorecard(mContext,scorecard_1.get_id());

        //Verify the ids were saved correctly
        assertEquals("Scorecard ids are not equal",scorecard_1.get_id(),scorecard_2.get_id());

        //Verify scorecard date
        assertEquals("Scorecard date are not equal",scorecard_1.getDate(),scorecard_2.getDate());

        //Verify the handicap
        assertEquals("Scorecard handicaps are not equal",scorecard_1.getHandicap(),scorecard_2.getHandicap());

        //Verify the golf field ids were saved correctly
        assertEquals("Golf field ids are not equal",scorecard_1.getGolfField_id(),scorecard_2.getGolfField_id());

        //Verify the golf field names were saved correctly
        assertEquals("Golf Names are not equal",scorecard_1.getGolfFieldName(),scorecard_2.getGolfFieldName());

        //Verify the golf field total lengths were saved correctly
        assertEquals("Golf field total length are not equal",scorecard_1.getGolfFieldTotalLength(),scorecard_2.getGolfFieldTotalLength());

        //Verify the golf field total pars were saved correctly
        assertEquals("Golf field total par are not equal",scorecard_1.getGolfFieldTotalPar(),scorecard_2.getGolfFieldTotalPar());

        //Verify the golf field Out lengths were saved correctly
        assertEquals("Golf field Out length are not equal",scorecard_1.getGolfFieldOutLength(),scorecard_2.getGolfFieldOutLength());

        //Verify the golf field out pars were saved correctly
        assertEquals("Golf field out pars are not equal",scorecard_1.getGolfFieldOutPar(),scorecard_2.getGolfFieldOutPar());

        //Verify the golf field In lengths were saved correctly
        assertEquals("Golf field In length are not equal",scorecard_1.getGolfFieldInLength(),scorecard_2.getGolfFieldInLength());

        //Verify the golf field In pars were saved correctly
        assertEquals("Golf field In par are not equal",scorecard_1.getGolfFieldInPar(),scorecard_2.getGolfFieldInPar());


        //Verify the out scores were saved correctly
        assertEquals("Golf field Out scores are not equal",scorecard_1.getOutScore(),scorecard_2.getOutScore());

        //Verify the out Dif were saved correctly
        assertEquals("Golf field Out Dif are not equal",scorecard_1.getOutDif(),scorecard_2.getOutDif());

        //Verify the In scores were saved correctly
        assertEquals("Golf field In scores are not equal",scorecard_1.getInScore(),scorecard_2.getInScore());

        //Verify the In Dif were saved correctly
        assertEquals("Golf field In Dif are not equal",scorecard_1.getInDif(),scorecard_2.getInDif());

        //Verify the gross scores were saved correctly
        assertEquals("Golf field gross scores are not equal",scorecard_1.getGrossScore(),scorecard_2.getGrossScore());

        //Verify the In gross were saved correctly
        assertEquals("Golf field gross Dif are not equal",scorecard_1.getGrossDif(),scorecard_2.getGrossDif());

        //Verify the Net scores were saved correctly
        assertEquals("Golf field Net scores are not equal",scorecard_1.getNetScore(),scorecard_2.getNetScore());

        //Verify the Net Dif were saved correctly
        assertEquals("Golf field Net Dif are not equal",scorecard_1.getNetDif(),scorecard_2.getNetDif());


        TestUtils.deleteAllRecords(mContext);

    }



    public void testAllScorecardsEmptyTable(){

        Cursor cursor;

        TestUtils.deleteAllRecords(mContext);

        cursor=Scorecard.getAllScorecards(mContext);
        assertEquals("Cursor is not empty",cursor.getCount(),0);

        TestUtils.deleteAllRecords(mContext);
        cursor.close();

    }

    public void testScorecardsNotEmptyTable(){

        Cursor cursor;

        TestUtils.deleteAllRecords(mContext);


        Scorecard scorecard_1=new Scorecard(123456, 25, 119L, "fake name", 1234, 70, 456,33,800,37,45,12,47,13,92,17,74,4);
       //Verify the scorecard was inserted correctly
        assertTrue("The scorecard was not inserted correctly",scorecard_1.insertScorecard(mContext));


        Scorecard scorecard_2=new Scorecard(123456, 25, 120L, "fake name", 1234, 70, 456,33,800,37,45,12,47,13,15,15,74,-4);
        //Verify the scorecard was inserted correctly
        assertTrue("The scorecard was not inserted correctly",scorecard_2.insertScorecard(mContext));

        Scorecard scorecard_3=new Scorecard(123456, 25, 121L, "fake name", 1234, 70, 456,33,800,37,45,12,47,13,73,18,74,2);
        //Verify the scorecard was inserted correctly
        assertTrue("The scorecard was not inserted correctly",scorecard_3.insertScorecard(mContext));

        Scorecard scorecard_4=new Scorecard(123456, 25, 121L, "fake name", 1234, 70, 456,33,800,37,45,12,47,13,78,20,74,-1);
        //Verify the scorecard was inserted correctly
        assertTrue("The scorecard was not inserted correctly",scorecard_4.insertScorecard(mContext));


        //Check all the scorecards
        cursor=Scorecard.getAllScorecards(mContext);
        assertEquals("All Scorecards qty of records doesn't match",cursor.getCount(),4);

        //Check all the scorecards for a particular golf Field
        cursor=Scorecard.getAllScorecardsByGolfField(mContext,121L);
        assertEquals("All Scorecards qty of records doesn't match",cursor.getCount(),2);

        //Check all the scorecards for a particular golf Field (the golf field has no scorecards)
        cursor=Scorecard.getAllScorecardsByGolfField(mContext,130L);
        assertEquals("All Scorecards qty of records should be 0",cursor.getCount(),0);


        //Check the best gross score dif
        assertEquals("Best gross score doesn´t match",15,Scorecard.getBestGrossScoreDif(mContext));

        //Check the best gross score dif
        assertEquals("Best gross score by golf field id doesn´t match",18,Scorecard.getBestGrossScoreDif(mContext,121L));


        //Check the best Net score dif
        assertEquals("Best Net score doesn´t match",-4,Scorecard.getBestNetScoreDif(mContext));

        //Check the best gross score dif
        assertEquals("Best net score by golf field id doesn´t match",-1,Scorecard.getBestNetScoreDif(mContext,121L));



        TestUtils.deleteAllRecords(mContext);
        cursor.close();



    }








}
