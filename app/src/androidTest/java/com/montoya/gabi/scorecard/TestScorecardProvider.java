package com.montoya.gabi.scorecard;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;

import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardProvider;

/**
 * Created by montoya on 14.04.2017.
 */

public class TestScorecardProvider extends AndroidTestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp();
       TestUtils.deleteAllGolfFieldrecords(mContext);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        TestUtils.deleteAllGolfFieldrecords(mContext);
    }



    /*
         This test checks to make sure that the content provider is registered correctly.
         Students: Uncomment this test to make sure you've correctly registered the WeatherProvider.
      */
    public void testProviderRegistry() {
        PackageManager pm = mContext.getPackageManager();

        // We define the component name based on the package name from the context and the
        // WeatherProvider class.
        ComponentName componentName = new ComponentName(mContext.getPackageName(), ScorecardProvider.class.getName());
        try {
            // Fetch the provider info using the component name from the PackageManager
            // This throws an exception if the provider isn't registered.
            ProviderInfo providerInfo = pm.getProviderInfo(componentName, 0);

            // Make sure that the registered authority matches the authority from the Contract.
            assertEquals("Error: ScorecardProvider registered with authority: " + providerInfo.authority +
                            " instead of authority: " + ScorecardContract.CONTENT_AUTHORITY,
                    providerInfo.authority, ScorecardContract.CONTENT_AUTHORITY);
        } catch (PackageManager.NameNotFoundException e) {
            // I guess the provider isn't registered correctly.
            assertTrue("Error: ScorecardProvider not registered at " + mContext.getPackageName(),
                    false);
        }
    }




    public void testInsertGolfField (){

        Uri insertedGFUri=null;
        UriMatcher testMatcher= ScorecardProvider.buildUriMatcher();


        GolfField golfField=new GolfField("Fake Golf Field Name",ScorecardContract.TRUE_VALUE);
        ContentValues contentValues=golfField.getGolfFieldValues();

        insertedGFUri=mContext.getContentResolver().insert(ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri(),contentValues);

        //Verify that the returned uri is not null
        assertNotNull("The returned URI is null",insertedGFUri);

        if(null!=insertedGFUri){


            //Verify the GolfFielf_WITH_ID matcher
            assertEquals("Error: Golf field  by ID URI was matched incorrectly.",testMatcher.match(insertedGFUri), ScorecardProvider.GOLF_FIELD_WITH_ID);

            Cursor cursor=mContext.getContentResolver().query(insertedGFUri,null,null,null,null);


            // Verify if the query got records
            assertEquals( "Error: There are more than 1 records in the query", 1,cursor.getCount() );


            TestUtils.VerifyExpectedGolfFieldQueryResult(golfField,cursor);


        }else{
            fail("the returned iserted URI was null");
        }

        TestUtils.deleteAllGolfFieldrecords(mContext);

    }








}
