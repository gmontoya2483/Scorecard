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

        //Test all Favorite GolfFields
        assertEquals("Error: The ScoreCard URI was matched incorrectly.",testMatcher.match(TEST_GOLF_FIELD_FAVORITE), ScorecardProvider.GOLF_FIELD_FAVORITE);
        Log.i("GOLF_FIELD_FAVORITE URI",TEST_GOLF_FIELD_FAVORITE.toString());






    }


}
