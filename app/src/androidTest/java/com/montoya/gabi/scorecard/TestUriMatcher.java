package com.montoya.gabi.scorecard;

import android.content.UriMatcher;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.util.Log;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardProvider;

/**
 * Created by montoya on 14.04.2017.
 */

public class TestUriMatcher extends AndroidTestCase {



    public void testGolfFieldUriMatcherAndTypes() {


        String type;

        final Uri TEST_GOLF_FIELD= ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri();
        final Uri TEST_GOLF_FIELD_WITH_ID= ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(456L);
        final Uri TEST_GOLF_FIELD_ACTIVE= ScorecardContract.GolfFieldEntry.buildAllGolfFieldsActiveUri();
        final Uri TEST_GOLF_FIELD_FAVORITE= ScorecardContract.GolfFieldEntry.buildAllGolfFieldsFavoriteUri();

        UriMatcher testMatcher = ScorecardProvider.buildUriMatcher();

        //Test all GolfFields
        assertEquals("Error: The ScoreCard URI was matched incorrectly.",testMatcher.match(TEST_GOLF_FIELD), ScorecardProvider.GOLF_FIELD);
        Log.i("GOLF_FIELD URI",TEST_GOLF_FIELD.toString());

        type = mContext.getContentResolver().getType(TEST_GOLF_FIELD);
        assertEquals("Error: the GOLF_FIELD CONTENT_URI should return GolfFieldEntry.CONTENT_DIR_TYPE", ScorecardContract.GolfFieldEntry.CONTENT_DIR_TYPE, type);
        Log.i("CONTENT_DIR_TYPE",type);


        //Test GolfField by GolfField ID
        assertEquals("Error: The ScoreCard URI was matched incorrectly.",testMatcher.match(TEST_GOLF_FIELD_WITH_ID), ScorecardProvider.GOLF_FIELD_WITH_ID);
        Log.i("GOLF_FIELD_WITH_ID URI",TEST_GOLF_FIELD_WITH_ID.toString());

        type = mContext.getContentResolver().getType(TEST_GOLF_FIELD_WITH_ID);
        assertEquals("Error: the TEST_GOLF_FIELD_WITH_ID CONTENT_URI should return GolfFieldEntry.CONTENT_ITEM_TYPE", ScorecardContract.GolfFieldEntry.CONTENT_ITEM_TYPE, type);
        Log.i("CONTENT_ITEM_TYPE",type);



        //Test all Favorite GolfFields
        assertEquals("Error: The ScoreCard URI was matched incorrectly.",testMatcher.match(TEST_GOLF_FIELD_FAVORITE), ScorecardProvider.GOLF_FIELD_FAVORITE);
        Log.i("GOLF_FIELD_FAVORITE URI",TEST_GOLF_FIELD_FAVORITE.toString());

        type = mContext.getContentResolver().getType(TEST_GOLF_FIELD_FAVORITE);
        assertEquals("Error: the GOLF_FIELD CONTENT_URI should return GolfFieldEntry.CONTENT_DIR_FIELD_FAVORITE", ScorecardContract.GolfFieldEntry.CONTENT_DIR_TYPE_FAVORITE, type);
        Log.i("CONTENT_DIR_FAVORITE",type);



        //Test all Active GolfFields
        assertEquals("Error: The ScoreCard URI was matched incorrectly.",testMatcher.match(TEST_GOLF_FIELD_ACTIVE), ScorecardProvider.GOLF_FIELD_ACTIVE);
        Log.i("GOLF_FIELD_ACTIVE URI",TEST_GOLF_FIELD_ACTIVE.toString());

        type = mContext.getContentResolver().getType(TEST_GOLF_FIELD_ACTIVE);
        assertEquals("Error: the GOLF_FIELD CONTENT_URI should return GolfFieldEntry.CONTENT_DIR_FIELD_ACTIVE", ScorecardContract.GolfFieldEntry.CONTENT_DIR_TYPE_ACTIVE, type);
        Log.i("CONTENT_DIR_ACTIVE",type);

    }

    public void testGolfFieldHoleUriMatcherAndTypes() {

        String type;

        final Uri TEST_GOLF_FIELD_HOLE= ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldHoleUri();
        final Uri TEST_GOLF_FIELD_HOLE_WITH_ID= ScorecardContract.GolfFieldHoleEntry.buildGolfFieldHoleByIdUri(456L);
        final Uri TEST_GOLF_FIELD_HOLE_WITH_GF= ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(564L);

        UriMatcher testMatcher = ScorecardProvider.buildUriMatcher();


        //Test all GolfFieldHoles
        assertEquals("Error: The ScoreCard URI was matched incorrectly.",testMatcher.match(TEST_GOLF_FIELD_HOLE), ScorecardProvider.GOLF_FIELD_HOLE);
        Log.i("GOLF_FIELD URI",TEST_GOLF_FIELD_HOLE.toString());

        type = mContext.getContentResolver().getType(TEST_GOLF_FIELD_HOLE);
        assertEquals("Error: the GOLF_FIELD_HOLE CONTENT_URI should return GolfFieldHoleEntry.CONTENT_DIR_TYPE", ScorecardContract.GolfFieldHoleEntry.CONTENT_DIR_TYPE, type);
        Log.i("CONTENT_DIR_TYPE",type);


        //Test all GolfFields with ID
        assertEquals("Error: The ScoreCard URI was matched incorrectly.",testMatcher.match(TEST_GOLF_FIELD_HOLE_WITH_ID), ScorecardProvider.GOLF_FIELD_HOLE_WITH_ID);
        Log.i("GOLF_FIELD URI",TEST_GOLF_FIELD_HOLE_WITH_ID.toString());

        type = mContext.getContentResolver().getType(TEST_GOLF_FIELD_HOLE_WITH_ID);
        assertEquals("Error: the GOLF_FIELD_HOLE CONTENT_URI should return GolfFieldHoleEntry.CONTENT_ITEM_TYPE", ScorecardContract.GolfFieldHoleEntry.CONTENT_ITEM_TYPE, type);
        Log.i("CONTENT_ITEM_TYPE",type);


        //Test all GolfFields with ID
        assertEquals("Error: The ScoreCard URI was matched incorrectly.",testMatcher.match(TEST_GOLF_FIELD_HOLE_WITH_GF), ScorecardProvider.GOLF_FIELD_HOLE_WITH_GF);
        Log.i("GOLF_FIELD URI",TEST_GOLF_FIELD_HOLE_WITH_GF.toString());

        type = mContext.getContentResolver().getType(TEST_GOLF_FIELD_HOLE_WITH_GF);
        assertEquals("Error: the GOLF_FIELD_HOLE CONTENT_URI should return GolfFieldHoleEntry.CONTENT_DIR_TYPE_FIELD", ScorecardContract.GolfFieldHoleEntry.CONTENT_DIR_TYPE_FIELD, type);
        Log.i("CONTENT_ITEM_TYPE",type);




    }


    public void testScorecardUriMatcherAndTypes(){

        String type;

        final Uri TEST_SCORECARD= ScorecardContract.ScorecardEntry.buildAllScoreCardUri();
        final Uri TEST_SCORECARD_WITH_ID= ScorecardContract.ScorecardEntry.buildScoreCardByIdUri(456L);
        final Uri TEST_SCORECARD_WITH_GOLF_FIELD_ID= ScorecardContract.ScorecardEntry.buildScoreCardByGolfFieldIdUri(5L);
        final Uri TEST_SCORECARD_BEST_GROSS_DIF= ScorecardContract.ScorecardEntry.buildScoreCardBestGrossDifUri();
        final Uri TEST_SCORECARD_BEST_GROSS_DIF_GOLF_FIELD_ID= ScorecardContract.ScorecardEntry.buildScoreCardBestGrossDifByGolfFieldIdUri(125L);
        final Uri TEST_SCORECARD_BEST_NET_DIF= ScorecardContract.ScorecardEntry.buildScoreCardBestNetDifUri();
        final Uri TEST_SCORECARD_BEST_NET_DIF_GOLF_FIELD_ID= ScorecardContract.ScorecardEntry.buildScoreCardBestNetDifByGolfFieldIdUri(125L);

        UriMatcher testMatcher = ScorecardProvider.buildUriMatcher();

        //Test all Scorecards
        assertEquals("Error: The ScoreCard URI was matched incorrectly.",testMatcher.match(TEST_SCORECARD), ScorecardProvider.SCORECARD);
        Log.i("SCORECARD URI ",TEST_SCORECARD.toString());

        type = mContext.getContentResolver().getType(TEST_SCORECARD);
        assertEquals("Error: the SCORECARD CONTENT_URI was matched incorrectly.", ScorecardContract.ScorecardEntry.CONTENT_DIR_TYPE, type);
        Log.i("CONTENT_DIR_TYPE",type);



        assertEquals("Error: The ScoreCard with ID URI was matched incorrectly.",testMatcher.match(TEST_SCORECARD_WITH_ID), ScorecardProvider.SCORECARD_WITH_ID);
        Log.i("SCORECARD_WITH_ID URI ",TEST_SCORECARD_WITH_ID.toString());

        type = mContext.getContentResolver().getType(TEST_SCORECARD_WITH_ID);
        assertEquals("Error: the SCORECARD WITH CONTENT_URI was matched incorrectly.", ScorecardContract.ScorecardEntry.CONTENT_ITEM_TYPE, type);
        Log.i("CONTENT_ITEM_TYPE",type);



        assertEquals("Error: The ScoreCard with Golf Field id URI was matched incorrectly.",testMatcher.match(TEST_SCORECARD_WITH_GOLF_FIELD_ID), ScorecardProvider.SCORECARD_WITH_GF_ID);
        Log.i("SCORECARD_WITH_GF_URI ",TEST_SCORECARD_WITH_GOLF_FIELD_ID.toString());

        type = mContext.getContentResolver().getType(TEST_SCORECARD_WITH_GOLF_FIELD_ID);
        assertEquals("Error: the TEST_SCORECARD_WITH_GOLF_FIELD_ID  CONTENT_URI was matched incorrectly.", ScorecardContract.ScorecardEntry.CONTENT_DIR_TYPE_GOLF_FIELD, type);
        Log.i("CONTENT_DIR_TYPE",type);



        assertEquals("Error: The ScoreCard Best Gross Dif URI was matched incorrectly.",testMatcher.match(TEST_SCORECARD_BEST_GROSS_DIF), ScorecardProvider.SCORECARD_BEST_GROSS_DIF);
        Log.i("SCORECARD_GROSS_URI ",TEST_SCORECARD_BEST_GROSS_DIF.toString());

        type = mContext.getContentResolver().getType(TEST_SCORECARD_BEST_GROSS_DIF);
        assertEquals("Error: the TEST_SCORECARD_BEST_GROSS_DIF  CONTENT_URI was matched incorrectly.", ScorecardContract.ScorecardEntry.CONTENT_ITEM_TYPE_BEST_GROSS_DIF, type);
        Log.i("CONTENT_ITEM_TYPE",type);


        assertEquals("Error: The ScoreCard Best Gross Dif URI was matched incorrectly.",testMatcher.match(TEST_SCORECARD_BEST_GROSS_DIF_GOLF_FIELD_ID), ScorecardProvider.SCORECARD_BEST_GROSS_DIF_WITH_GF_ID);
        Log.i("SCORECARD_GROSS_URI ",TEST_SCORECARD_BEST_GROSS_DIF_GOLF_FIELD_ID.toString());

        type = mContext.getContentResolver().getType(TEST_SCORECARD_BEST_GROSS_DIF_GOLF_FIELD_ID);
        assertEquals("Error: the TEST_SCORECARD_GROSS_DIF_GF_ID  CONTENT_URI was matched incorrectly.", ScorecardContract.ScorecardEntry.CONTENT_ITEM_TYPE_BEST_GROSS_DIF_GOLF_FIELD, type);
        Log.i("CONTENT_ITEM_TYPE",type);




        assertEquals("Error: The ScoreCard Best Net Dif URI was matched incorrectly.",testMatcher.match(TEST_SCORECARD_BEST_NET_DIF), ScorecardProvider.SCORECARD_BEST_NET_DIF);
        Log.i("SCORECARD_NET_URI ",TEST_SCORECARD_BEST_NET_DIF.toString());

        type = mContext.getContentResolver().getType(TEST_SCORECARD_BEST_NET_DIF);
        assertEquals("Error: the TEST_SCORECARD_BEST_NET_DIF  CONTENT_URI was matched incorrectly.", ScorecardContract.ScorecardEntry.CONTENT_ITEM_TYPE_BEST_NET_DIF, type);
        Log.i("CONTENT_ITEM_TYPE",type);


        assertEquals("Error: The ScoreCard Best <net Dif URI was matched incorrectly.",testMatcher.match(TEST_SCORECARD_BEST_NET_DIF_GOLF_FIELD_ID), ScorecardProvider.SCORECARD_BEST_NET_DIF_WITH_GF_ID);
        Log.i("SCORECARD_NET_URI ",TEST_SCORECARD_BEST_NET_DIF_GOLF_FIELD_ID.toString());

        type = mContext.getContentResolver().getType(TEST_SCORECARD_BEST_NET_DIF_GOLF_FIELD_ID);
        assertEquals("Error: the TEST_SCORECARD_NET_DIF_GF_ID  CONTENT_URI was matched incorrectly.", ScorecardContract.ScorecardEntry.CONTENT_ITEM_TYPE_BEST_NET_DIF_GOLF_FIELD, type);
        Log.i("CONTENT_ITEM_TYPE",type);

    }


}
