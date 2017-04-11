package com.montoya.gabi.scorecard;

import android.content.Context;

import com.montoya.gabi.scorecard.model.data.ScorecardDbHelper;

/**
 * Created by montoya on 11.04.2017.
 */

public class TestUtils {



    // Since we want each test to start with a clean slate
    public static void deleteTheDatabase(Context context) {

        context.deleteDatabase(ScorecardDbHelper.DATABASE_NAME);
    }







}
