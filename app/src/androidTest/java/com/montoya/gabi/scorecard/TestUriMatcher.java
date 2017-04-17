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


}
